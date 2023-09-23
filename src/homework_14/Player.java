package homework_14;
/**
 * 23.09.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    protected String name;
    protected final Battlefield battlefield;
    protected final List<Ship> ships;

    public Player() {
        this.name = "Player";
        this.battlefield = new Battlefield();
        this.ships = new ArrayList<>();
    }

    public void display()
    {
        battlefield.display(this, false);
    }
    public void display(boolean useRedColor)
    {
        battlefield.display(this, useRedColor);
    }

    public void displayHidden()
    {
        battlefield.displayHidden(this);
    }

    public void placeShips() {
        Scanner scanner = new Scanner(System.in);

        // Проходимся по каждому кораблю, который нужно разместить
        for (int i = 1; i <= 5; i++) {
            boolean isPlaced = false; // флаг успешного размещения корабля

            // Пока корабль не будет успешно размещен
            while (!isPlaced) {
                System.out.println("Расставьте корабль длиной " + i);

                // Получаем координаты начала корабля
                System.out.print("Введите координаты начала корабля (например, A5): ");
                String startInput = scanner.nextLine().toUpperCase();
                Coordinates start;
                try {
                    start = new Coordinates(startInput);
                } catch (IllegalArgumentException e) {
                    System.out.println("Неверные координаты. Попробуйте снова.");
                    continue;
                }

                // Получаем ориентацию корабля
                System.out.print("Введите ориентацию корабля (h - горизонтально, v - вертикально): ");
                Orientation orientation;
                try {
                    orientation = Orientation.fromString(scanner.nextLine());
                } catch (IllegalArgumentException e) {
                    System.out.println("Неверная ориентация. Попробуйте снова.");
                    continue;
                }

                boolean isVertical = (orientation == Orientation.VERTICAL);
                Ship ship = new Ship(i, start, isVertical);

                // Пытаемся разместить корабль на поле битвы
                if (battlefield.placeShip(ship, start)) {
                    ships.add(ship);
                    isPlaced = true;
                    battlefield.display(this);
                } else {
                    System.out.println("Невозможно разместить корабль на этом месте. Попробуйте снова.");
                }
            }
        }
    }






    public CellStatus shoot(Player opponent) {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;
        String shotInput = "";

        while (!validInput) {
            System.out.println("Ваш ход! Введите координаты выстрела (например, A5): ");
            shotInput = scanner.nextLine().toUpperCase();

            // Проверка на корректность
            if (shotInput.matches("[A-J][1-9]0?")) {
                validInput = true;
            } else {
                System.out.println("Некорректный ввод. Попробуйте еще раз.");
            }
        }

        Coordinates shot = new Coordinates(shotInput);
        CellStatus status = opponent.battlefield.shootAt(shot);

        switch (status) {
            case HIT:
                ColorfulConsole.printColoredText("ПОПАЛ!", ColorfulConsole.ANSI_GREEN);
                break;
            case SHIP_ALREADY_HIT:
                ColorfulConsole.printColoredText("ПОПАЛ В РАНЕНЫЙ КОРАБЛЬ! ", ColorfulConsole.ANSI_GREEN);
                break;
            case MISS:
                ColorfulConsole.printColoredText("МИМО!", ColorfulConsole.ANSI_CYAN);
                break;
            case ALREADY_HIT:
                ColorfulConsole.printColoredText("ПОВТОРНОЕ ПОПАДАНИЕ!", ColorfulConsole.ANSI_GREEN);
                break;
            case DESTROYED:
                ColorfulConsole.printColoredText("КОРАБЛЬ УНИЧТОЖЕН!", ColorfulConsole.ANSI_GREEN);
                break;
            default:
                ColorfulConsole.printColoredText("НЕИЗВЕСТНЫЙ РЕЗУЛЬТАТ!", ColorfulConsole.ANSI_BLACK);
                break;
        }

        return status;
    }


    public boolean allShipsDestroyed() {
        for (Ship ship : ships) {
            if (!ship.isDestroyed()) {
                return false;
            }
        }
        return true;
    }
}
