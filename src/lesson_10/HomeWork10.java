package lesson_10;
/**
 * 18.09.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */
import java.util.Scanner;

public class HomeWork10 {

    // Task 0: Распечатать 10 строк: “Task1”. “Task2”. … “Task10”. Используем цикл while
    private static void printTenTasks() {
        int counter = 1;
        while (counter <= 10) {
            System.out.println("Task" + counter);
            counter++;
        }
    }

    // Task 1: Распечатать все числа от 1 до 100, которые делятся на 5 без остатка. Используем цикл do-while
    private static void printDividedByFive() {
        int number = 1;
        do {
            if (number % 5 == 0) {
                System.out.println(number);
            }
            number++;
        } while (number <= 100);
    }

    // Task 2: Распечатать только 7 чисел от 1 до 100, которые делятся на 5 без остатка. Используем цикл while
    private static void printFirstSevenDividedByFive() {
        int number = 1;
        int count = 0;
        while (number <= 100 && count < 7) {
            if (number % 5 == 0) {
                System.out.println(number);
                count++;
            }
            number++;
        }
    }

    // Task 3: Программа просит пользователя слово "hello". Если пользователь вводит правильное слово -
    // программа распечатывает на экран благодарность и завершает работу. Если вводится не верное слово -
    // программа просит ввести слово снова. До тех пор, пока не будет введено запрашиваемое слово.
    // *опционально - считать кол-во попыток, которые потребовались пользователю для введения правильного слова
    // По окончанию - вывести число попыток на экран
    private static void checkUserInput() {
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
        while (true) {
            System.out.println("Введите слово 'hello':");
            String input = scanner.nextLine();
            attempts++;
            if ("hello".equals(input)) {
                System.out.println("Спасибо!");
                System.out.println("Количество попыток: " + attempts);
                break;
            } else {
                System.out.println("Попробуйте снова.");
            }
        }
    }

    // Task 4: Программа просит пользователя ввести произвольное число. Вывести сумму цифр этого числа.
    // Например: 567432 -> 5+6+7+4+3+2 -> 27
    private static void sumOfDigits() {
        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            System.out.println("Введите произвольное число:");
            input = scanner.nextLine();

            // Проверяем, содержит ли строка только цифры
            if (input.matches("\\d+")) {
                break;
            } else {
                System.out.println("Неверный ввод. Пожалуйста, введите только цифры.");
            }
        }

        int sum = 0;
        for (char c : input.toCharArray()) {
            sum += Character.getNumericValue(c);
        }
        System.out.println("Сумма цифр числа: " + sum);
    }

    public static void main(String[] args) {
        printTenTasks();
        printDividedByFive();
        printFirstSevenDividedByFive();
        checkUserInput();
        sumOfDigits();
    }
}
