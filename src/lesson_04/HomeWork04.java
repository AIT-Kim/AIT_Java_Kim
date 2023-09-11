package lesson_04;

/**
 * PersonalInfo
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */

import java.util.Scanner;

/**
 * Реализовать приложение, которое читает информацию о вас, и печатает итог на экран.
 *
 * If the user simply presses Enter without entering any data,
 * the program sets a default value and continues its operation.
 */
public class HomeWork04 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите ваше имя: ");
        String firstName = getInputWithFallback(scanner, "Неизвестное имя");

        System.out.print("Введите вашу фамилию: ");
        String lastName = getInputWithFallback(scanner, "Неизвестная фамилия");

        System.out.print("Введите ваш город: ");
        String city = getInputWithFallback(scanner, "Неизвестный город");

        System.out.print("Введите ваш возраст: ");
        int age = getIntWithFallback(scanner, -1);

        System.out.print("Введите ваш рост (в метрах): ");
        double height = getDoubleWithFallback(scanner, -1);

        System.out.println("Меня зовут " + firstName + " " + lastName + ", мне " + (age == -1 ? "неизвестен возраст" : age + " лет") + ", я из " + city + ", мой рост - " + (height == -1 ? "неизвестен" : height));
    }

    private static String getInputWithFallback(Scanner scanner, String fallback) {
        String input = scanner.nextLine().trim();
        if (input.isEmpty()) {
            return fallback;
        }
        return input;
    }

    private static int getIntWithFallback(Scanner scanner, int fallback) {
        String input = scanner.nextLine().trim();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return fallback;
        }
    }

    private static double getDoubleWithFallback(Scanner scanner, double fallback) {
        String input = scanner.nextLine().trim();
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            return fallback;
        }
    }
}