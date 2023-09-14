package lesson_08;
/**
 * 14.09.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */

import java.util.Scanner;
import java.util.Random;

public class HomeWork08 {
    public static void main(String[] args) {
        // Task 0
        userInputNumber();

        // Task 1
        dayOfWeek();

        // Task 2
        tvTimeForChild();
    }

    // Задача 0: Используем switch для вывода введенного числа
    public static void userInputNumber() {
        System.out.println("Введите число на выбор: 1, 2 или 3:");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Вы ввели число 1");
                break;
            case 2:
                System.out.println("Вы ввели число 2");
                break;
            case 3:
                System.out.println("Вы ввели число 3");
                break;
            default:
                System.out.println("Вы ввели недопустимое число!");
                break;
        }
    }

    // Задача 1: Определение дня недели
    public static void dayOfWeek() {
        System.out.println("Введите число от 1 до 7:");
        Scanner scanner = new Scanner(System.in);
        int day = scanner.nextInt();

        switch (day) {
            case 1:
                System.out.println("Понедельник");
                break;
            case 2:
                System.out.println("Вторник");
                break;
            case 3:
                System.out.println("Среда");
                break;
            case 4:
                System.out.println("Четверг");
                break;
            case 5:
                System.out.println("Пятница");
                break;
            case 6:
            case 7:
                System.out.println("Выходной");
                break;
            default:
                System.out.println("Недопустимый ввод");
                break;
        }
    }

    // Задача 2: Время для просмотра ТВ в зависимости от оценки
    public static void tvTimeForChild() {
        Random random = new Random();
        int score = random.nextInt(13);
        System.out.println("Оценка ребенка: " + score);
        int remainingTime = 45; // Оставшееся время

        switch (score) {
            case 10:
            case 11:
            case 12:
                System.out.println("Как я рад!");
                remainingTime += 60;
                break;
            case 7:
            case 8:
            case 9:
                System.out.println("Молодец!");
                remainingTime += 45;
                break;
            case 4:
            case 5:
            case 6:
                System.out.println("Нормально.");
                remainingTime += 15;
                break;
            case 3:
                System.out.println("Очень плохо.");
                remainingTime -= 30;
                break;
            default:
                System.out.println("Трагедия. Сегодня ТВ смотреть запрещено.");
                remainingTime = 0;
                break;

        }

        // Проверим, чтобы у ребенка не было больше 60 минут на просмотр
        if (remainingTime > 60) {
            remainingTime = 60;
        }

        System.out.println("Оставшееся время для просмотра ТВ: " + remainingTime + " " + getCorrectMinuteFormRu(remainingTime));
    }

    public static String getCorrectMinuteFormRu(int minutes) {
        int lastDigit = minutes % 10;
        if (minutes % 100 >= 11 && minutes % 100 <= 14) {
            return "минут";
        } else if (lastDigit == 1) {
            return "минута";
        } else if (lastDigit >= 2 && lastDigit <= 4) {
            return "минуты";
        } else {
            return "минут";
        }
    }
}
