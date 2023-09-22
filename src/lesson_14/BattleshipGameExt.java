package lesson_14;
/**
 * 22.09.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */

/**
 * Доработайте "Морской бой" так, чтобы "цель" занимала 2(3, 4) клетки (по горизонтали или вертикали),
 * а пораженные отсеки отмечались x.
 */

import java.util.Random;
import java.util.Scanner;

public class BattleshipGameExt {

    private static final int BOARD_SIZE = 5;
    private static char[][] board = new char[BOARD_SIZE][BOARD_SIZE];
    private static int shipStartRow, shipStartCol, shipLength, shipDirection;

    public static void main(String[] args) {
        initBoard();
        placeShip();

        System.out.println("All set. Get ready to rumble!");

        Scanner scanner = new Scanner(System.in);
        int hitCount = 0;

        while (hitCount < shipLength) {
            displayBoard();

            int row = getInput("Enter row (1-5): ", scanner) - 1;
            int col = getInput("Enter column (1-5): ", scanner) - 1;

            if (board[row][col] == 'S') {
                board[row][col] = 'x';
                hitCount++;
            } else {
                board[row][col] = '*';
            }
        }

        displayBoard();
        System.out.println("You have won!");
        scanner.close();
    }

    private static void initBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = '-';
            }
        }
    }

    private static void placeShip() {
        Random rand = new Random();
        shipLength = rand.nextInt(3) + 2; // ship length will be 2, 3, or 4
        shipDirection = rand.nextInt(2); // 0 for horizontal, 1 for vertical

        if (shipDirection == 0) {
            shipStartRow = rand.nextInt(BOARD_SIZE);
            shipStartCol = rand.nextInt(BOARD_SIZE - shipLength + 1);
        } else {
            shipStartRow = rand.nextInt(BOARD_SIZE - shipLength + 1);
            shipStartCol = rand.nextInt(BOARD_SIZE);
        }

        for (int i = 0; i < shipLength; i++) {
            if (shipDirection == 0) {
                board[shipStartRow][shipStartCol + i] = 'S';
            } else {
                board[shipStartRow + i][shipStartCol] = 'S';
            }
        }
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
            if (choice < 1 || choice > BOARD_SIZE) {
                System.out.println("Please enter a number between 1 and " + BOARD_SIZE + "!");
                continue;
            }
            break;
        }
        return choice;
    }

    private static void displayBoard() {
        System.out.print("  ");
        for (int i = 1; i <= BOARD_SIZE; i++) {
            System.out.print("| " + i + " ");
        }
        System.out.println("|");
        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] != 'S') { // Hiding the ship
                    System.out.print("| " + board[i][j] + " ");
                } else {
                    System.out.print("| - ");
                }
            }
            System.out.println("|");
        }
    }
}
