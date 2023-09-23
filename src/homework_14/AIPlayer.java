package homework_14;
/**
 * 23.09.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */
import java.util.Random;
import java.util.*;

public class AIPlayer extends Player {
    private final Difficulty difficulty;
    private final Random random;
    private Coordinates lastHit = null; // последний успешный выстрел
    private List<Coordinates> potentialTargets = new ArrayList<>();

    // Дополнительные поля для AI
    private Set<Coordinates> previousShots = new HashSet<>();
    private Iterator<Coordinates> systematicShotsIterator;

    public AIPlayer(Difficulty difficulty) {
        super();
        this.name = "AI";
        this.difficulty = difficulty;
        this.random = new Random();

        // Инициализация итератора для систематических выстрелов
        List<Coordinates> systematicShots = new ArrayList<>();
        for (int x = 0; x < Battlefield.SIZE; x++) {
            for (int y = x % 2; y < Battlefield.SIZE; y += 2) {
                systematicShots.add(new Coordinates(x, y));
            }
        }
        systematicShotsIterator = systematicShots.iterator();
    }

    @Override
    public void placeShips() {
        for (int i = 1; i <= 5; i++) {
            boolean placedSuccessfully = false;
            while (!placedSuccessfully) {
                int x = random.nextInt(Battlefield.SIZE);
                int y = random.nextInt(Battlefield.SIZE);
                boolean isVertical = random.nextBoolean();

                if (isVertical && x + i >= Battlefield.SIZE) {
                    continue;
                } else if (!isVertical && y + i >= Battlefield.SIZE) {
                    continue;
                }

                Coordinates start = new Coordinates(x, y);
                Ship ship = new Ship(i, start, isVertical);

                placedSuccessfully = battlefield.placeShip(ship, start);
                if (placedSuccessfully) {
                    ships.add(ship);
                }
            }
        }
    }





    /**
    EASY:   Random shoot only
    NORMAL:
            когда AI попадает по кораблю противника, он будет стрелять по соседним ячейкам,
            чтобы попробовать полностью уничтожить этот корабль.
            Как только корабль уничтожен или AI промахивается, он возвращается к случайной стрельбе до следующего попадания.
    HARD:
            Cтреляет через одну ячейку, чтобы увеличить вероятность попадания.
            После попадания, AI будет следовать такой же стратегии, что и для уровня сложности NORMAL - стрелять по соседним ячейкам.
            Однако после уничтожения корабля, вместо возвращения к случайной стрельбе, AI будет продолжать свою стратегию стрельбы через одну ячейку.

     */
    @Override
    public CellStatus shoot(Player opponent) {
        Coordinates shot;
        if (difficulty == Difficulty.EASY) {
            shot = new Coordinates(random.nextInt(Battlefield.SIZE), random.nextInt(Battlefield.SIZE));
        } else if (difficulty == Difficulty.NORMAL) {
            if (lastHit != null && !potentialTargets.isEmpty()) {
                shot = potentialTargets.remove(0);
            } else {
                shot = new Coordinates(random.nextInt(Battlefield.SIZE), random.nextInt(Battlefield.SIZE));
            }
        } else { // HARD difficulty
            if (lastHit != null && !potentialTargets.isEmpty()) {
                shot = potentialTargets.remove(0);
            } else {
                do {
                    if (!systematicShotsIterator.hasNext()) {
                        // Если все возможные систематические выстрелы были сделаны, делаем случайный выстрел
                        shot = new Coordinates(random.nextInt(Battlefield.SIZE), random.nextInt(Battlefield.SIZE));
                    } else {
                        shot = systematicShotsIterator.next();
                    }
                } while (previousShots.contains(shot));
                previousShots.add(shot);

            }
        }

        CellStatus status = opponent.battlefield.shootAt(shot);
        switch (status) {
            case HIT:
                lastHit = shot;
                populatePotentialTargets(shot);
                System.out.println("AI ПОПАЛ!");
                break;
            case SHIP_ALREADY_HIT:
                System.out.println("AI ПОПАЛ В РАНЕНЫЙ КОРАБЛЬ! ");
                break;
            case MISS:
                System.out.println("AI МИМО!");
                break;
            case ALREADY_HIT:
                System.out.println("AI ПОВТОРНОЕ ПОПАДАНИЕ!");
                break;
            case DESTROYED:
                lastHit = null;
                potentialTargets.clear();
                System.out.println("AI КОРАБЛЬ УНИЧТОЖЕН!");
                break;
            default:
                System.out.println("AI НЕИЗВЕСТНЫЙ РЕЗУЛЬТАТ!");
                break;
        }
        return status;
    }

    private void populatePotentialTargets(Coordinates hit) {
        int x = hit.getX();
        int y = hit.getY();

        // проверяем ячейки вокруг попадания
        if (isValidCoordinate(x - 1, y)) potentialTargets.add(new Coordinates(x - 1, y));
        if (isValidCoordinate(x + 1, y)) potentialTargets.add(new Coordinates(x + 1, y));
        if (isValidCoordinate(x, y - 1)) potentialTargets.add(new Coordinates(x, y - 1));
        if (isValidCoordinate(x, y + 1)) potentialTargets.add(new Coordinates(x, y + 1));
    }

    private boolean isValidCoordinate(int x, int y) {
        return x >= 0 && x < Battlefield.SIZE && y >= 0 && y < Battlefield.SIZE;
    }

}
