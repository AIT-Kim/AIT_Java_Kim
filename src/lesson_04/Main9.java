package lesson_04;

import java.util.Scanner;

/**
 * InputOutput
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */

public class Main9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        int number = scanner.nextInt();
        double value = scanner.nextDouble();

        String message = text + " " + number + " " + value;

        System.out.println(message);
    }
}