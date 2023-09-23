package homework_14;
/**
 * 23.09.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */
import java.util.Random;
import java.util.Scanner;

public class Game {
    private Player humanPlayer;
    private AIPlayer aiPlayer;
    private Player currentPlayer;
    private Difficulty difficulty;

    private static final Random random = new Random();


    public Game() {
        initialize();
    }

    private void initialize() {
        Scanner scanner = new Scanner(System.in);

        displayWelcomeMessage();
        displayRules();

        System.out.println("Выберите уровень сложности:");
        System.out.println("1. EASY");
        System.out.println("2. NORMAL");
        System.out.println("3. HARD");

        int choice = scanner.nextInt();
        scanner.nextLine(); // очистить буфер

        switch (choice) {
            case 1:
                difficulty = Difficulty.EASY;
                break;
            case 2:
                difficulty = Difficulty.NORMAL;
                break;
            case 3:
                difficulty = Difficulty.HARD;
                break;
            default:
                System.out.println("Неверный выбор! Устанавливаю сложность по умолчанию (NORMAL).");
                difficulty = Difficulty.NORMAL;
                break;
        }

        humanPlayer = new Player();
        aiPlayer = new AIPlayer(difficulty);

        humanPlayer.display();
        System.out.println("Расставьте свои корабли:");
        humanPlayer.placeShips();
        humanPlayer.display();

        // Temporary display for AI ships (for debugging)
        System.out.println("\033[31mAI ships: (TODO: Remove this later)\033[0m");
        aiPlayer.placeShips();
        aiPlayer.display(true); //TODO Remove DEBUG

        currentPlayer = humanPlayer;
    }

    public void start() {


        CellStatus status;

        while (!gameOver()) {
            Player opponent = (currentPlayer == humanPlayer) ? aiPlayer : humanPlayer;

            // Проверяем, если ходит AI
            if (currentPlayer == aiPlayer) {
                System.out.print("Ходит AI...");
                delayRandomly();
            } else {
                opponent.displayHidden();
            }

            //Стреляем
            status = currentPlayer.shoot(opponent);

            //Проверяем статус матча
            if (aiPlayer.allShipsDestroyed()) {
                ColorfulConsole.printColoredText("YOU WIN!!!", ColorfulConsole.ANSI_BLUE);
                return;
            } else if (humanPlayer.allShipsDestroyed()) {
                ColorfulConsole.printColoredText("YOU LOSE...", ColorfulConsole.ANSI_RED);
                return;
            }

            if (currentPlayer == aiPlayer) {
                opponent.display();
            }
            else
            {
                opponent.displayHidden();
            }

            if (status != CellStatus.HIT && status != CellStatus.SHIP_ALREADY_HIT && status != CellStatus.DESTROYED) {
                delayRandomly(2);
                switchCurrentPlayer();
            }
        }
    }

    public static void delayRandomly() {
        int delay = (random.nextInt(3) + 3) * 1000;  // для задержки от 3 до 5 секунд
        int interval = 1000; // 1 секунда
        int intervalsCount = delay / interval;

        for (int i = 0; i < intervalsCount; i++) {
            System.out.print(".");
            try {
                Thread.sleep(interval);  // Задержка на 1 секунду
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }

    public static void delayRandomly(int delaySec) {
        try {
            Thread.sleep(delaySec*1000);  // Задержка
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private boolean gameOver() {
        return aiPlayer.allShipsDestroyed() || humanPlayer.allShipsDestroyed();
    }

    private void switchCurrentPlayer() {
        currentPlayer = currentPlayer == humanPlayer ? aiPlayer : humanPlayer;
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }

    private static void displayWelcomeMessage() {
        ColorfulConsole.printColoredText("*****************************************",   ColorfulConsole.ANSI_BLUE);
        ColorfulConsole.printColoredText("*********** Добро пожаловать! ************",  ColorfulConsole.ANSI_BLUE);
        ColorfulConsole.printColoredText("****** В игру \"Морской бой\"! ***********",  ColorfulConsole.ANSI_BLUE);
        ColorfulConsole.printColoredText("*****************************************",   ColorfulConsole.ANSI_BLUE);
        ColorfulConsole.printColoredText("",                                            ColorfulConsole.ANSI_BLUE);
    }

    private static void displayRules() {
        ColorfulConsole.printColoredText("Правила игры:",                                                   ColorfulConsole.ANSI_PURPLE);
        ColorfulConsole.printColoredText("1. Игра проходит на квадратном поле 10x10.",                      ColorfulConsole.ANSI_PURPLE);
        ColorfulConsole.printColoredText("2. У каждого игрока есть флот, состоящий из следующих кораблей:", ColorfulConsole.ANSI_PURPLE);
        ColorfulConsole.printColoredText("   - 1 линкор (размером в 4 клетки)",                             ColorfulConsole.ANSI_PURPLE);
        ColorfulConsole.printColoredText("   - 2 крейсера (размером в 3 клетки)",                           ColorfulConsole.ANSI_PURPLE);
        ColorfulConsole.printColoredText("   - 3 эсминца (размером в 2 клетки)",                            ColorfulConsole.ANSI_PURPLE);
        ColorfulConsole.printColoredText("   - 4 миноносца (размером в 1 клетку)",                          ColorfulConsole.ANSI_PURPLE);
        ColorfulConsole.printColoredText("3. Игроки по очереди делают выстрелы в клетки противника.",       ColorfulConsole.ANSI_PURPLE);
        ColorfulConsole.printColoredText("4. Цель игры - потопить все корабли противника.",                 ColorfulConsole.ANSI_PURPLE);
        ColorfulConsole.printColoredText("5. Когда все корабли одного игрока потоплены, другой игрок объявляется победителем.", ColorfulConsole.ANSI_PURPLE);
        ColorfulConsole.printColoredText("",                                                                ColorfulConsole.ANSI_PURPLE);
        ColorfulConsole.printColoredText("Удачи и приятной игры!",                                          ColorfulConsole.ANSI_PURPLE);
    }
}
