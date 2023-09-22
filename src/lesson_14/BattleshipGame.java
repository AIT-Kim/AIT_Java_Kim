package lesson_14;
/**
 * 22.09.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */

/**
 Задание

 Написать программу "Морской бой".

 Технические требования:

 Дан квадрат 5х5, где программа случайным образом ставит цель.
 Перед началом игры на экран выводится текст: All set. Get ready to rumble!.
 Сам процесс игры обрабатывается в бесконечном цикле.
 Игроку предлагается ввести линию для стрельбы; программа проверяет что бьло введено число,
 и введенная линия находится в границах игрового поля (1-5). В случае,
 если игрок ошибся предлагает ввести число еще раз.
 Игроку предлагается ввести столбик для стрельбы (должен проходить аналогичную проверку).
 После каждого выстрела необходимо отображать обновленное игровое поле в консоли. Клетки, куда игрок уже стрелял,
 необходимо отметить как *.
 Игра заканчивается при поражении цели. В конце игры вывести в консоль фразу You have won!, а также игровое поле.
 Пораженную цель отметить как x.
 Задание должно быть выполнено используя массивы (НЕ используйте интерфейсы List, Set, Map).
 Пример вывода в консоль:

 0 | 1 | 2 | 3 | 4 | 5 |
 1 | - | - | - | - | - |
 2 | - | * | * | - | - |
 3 | * | - | - | * | - |
 4 | - | - | - | - | * |
 5 | * | - | * | - | - |
 */

import java.util.Random;
import java.util.Scanner;

public class BattleshipGame {

    public static void main(String[] args) {
        char[][] board = new char[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                board[i][j] = '-';
            }
        }

        Random rand = new Random();
        int targetRow = rand.nextInt(5);
        int targetCol = rand.nextInt(5);

        System.out.println("All set. Get ready to rumble!");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayBoard(board);

            int row = getInput("Enter row (1-5): ", scanner) - 1;
            int col = getInput("Enter column (1-5): ", scanner) - 1;

            if (row == targetRow && col == targetCol) {
                board[row][col] = 'x';
                displayBoard(board);
                System.out.println("You have won!");
                break;
            } else {
                board[row][col] = '*';
            }
        }
        scanner.close();
    }

    private static int getInput(String prompt, Scanner scanner) {
        int choice;
        while (true) {
            System.out.print(prompt);
            if (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number!");
                scanner.next();
                continue;
            }
            choice = scanner.nextInt();
            if (choice < 1 || choice > 5) {
                System.out.println("Please enter a number between 1 and 5!");
                continue;
            }
            break;
        }
        return choice;
    }

    private static void displayBoard(char[][] board) {
        System.out.println("  | 1 | 2 | 3 | 4 | 5 |");
        for (int i = 0; i < 5; i++) {
            System.out.print(i + 1 + " | ");
            for (int j = 0; j < 5; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
        }
    }
}