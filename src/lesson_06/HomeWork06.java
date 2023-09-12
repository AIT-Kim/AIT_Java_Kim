package lesson_06;

/**
 * 12.09.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */

import java.util.Scanner;

public class HomeWork06 {

    public static void main(String[] args) {
        // Запускаем решение первой задачи
        task00();

        // Запускаем решение второй задачи
        task01();
    }

    /**
     * Task 00:
     * Получаем число из консоли и определяем, является ли оно четным, кратным 3,
     * а также четным и кратным 3 одновременно.
     */
    private static void task00() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число: ");
        int number = scanner.nextInt();

        // Определение, является ли число четным
        boolean isEven = number % 2 == 0;
        // Определение, кратно ли число 3
        boolean isDivisibleByThree = number % 3 == 0;

        // Выводим результаты на экран
        System.out.println("Число: " + number +
                " четное: " + isEven +
                "; кратно 3: " + isDivisibleByThree +
                "; четное и кратное 3: " + (isEven && isDivisibleByThree));
    }

    /**
     * Task 01:
     * Построчно сокращаем логическое выражение, соблюдая приоритет операций.
     */
    private static void task01() {
        // 1. Исходное выражение
        System.out.println((true | false) | (45 < 70) & !(true) ^ (6 == 5));

        // 2. Решаем сравнения 45 < 70 (true) и 6 == 5 (false)
        System.out.println(true | false | true & !true ^ false);

        // 3. Решаем логическое отрицание !true (false)
        System.out.println(true | false | true & false ^ false);

        // 4. Решаем логическое и true & false (false)
        System.out.println(true | false | false ^ false);

        // 5. Решаем исключающее или false ^ false (false)
        System.out.println(true | false | false);

        // 6. Решаем логическое или true | false (true)
        System.out.println(true);
    }
}