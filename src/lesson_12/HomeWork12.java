package lesson_12;

/**
 * 20.09.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */

import java.util.Random;
import java.util.Scanner;

public class HomeWork12 {

    public static void main(String[] args) {
        task0();
        task1();
        task2();
        task3();
    }

    // Task 0: Заполните массив 20 случайными целыми числами. Программа должна вывести на экран массив,
    // количество четных чисел в массиве и сумму всех четных чисел.
    private static void task0() {
        System.out.println("Task 0: ");

        Random rand = new Random();
        int[] arr = new int[20];
        int evenCount = 0;
        int evenSum = 0;

        // Заполняем массив и одновременно вычисляем количество четных чисел и их сумму
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(100) + 1;
            if (arr[i] % 2 == 0) {
                evenCount++;
                evenSum += arr[i];
            }
        }

        // Вывод изначального содержимого массива
        System.out.println("Изначальный массив:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.println("Количество четных чисел: " + evenCount);
        System.out.println("Сумма четных чисел: " + evenSum);
    }

    // Task 1: За каждый месяц банк начисляет к сумме вклада 7% от суммы.
    private static void task1() {
        System.out.println("Task 1: ");

        Scanner scanner = new Scanner(System.in);
        float deposit = -1;
        int months = -1;
        final float interestRate = 0.07f;  // Процент начислений

        do {
            System.out.print("Введите сумму вклада: ");
            if (scanner.hasNextFloat()) {
                deposit = scanner.nextFloat();
                if (deposit <= 0) {
                    System.out.println("Пожалуйста, введите положительное число.");
                    continue;
                }
                break;
            } else {
                System.out.println("Это не корректное число. Попробуйте снова.");
                scanner.next(); // очистка неверного ввода
            }
        } while (true);

        do {
            System.out.print("Введите срок вклада в месяцах: ");
            if (scanner.hasNextInt()) {
                months = scanner.nextInt();
                if (months <= 0) {
                    System.out.println("Пожалуйста, введите положительное число месяцев.");
                    continue;
                }
                break;
            } else {
                System.out.println("Это не корректное число. Попробуйте снова.");
                scanner.next(); // очистка неверного ввода
            }
        } while (true);

        for (int i = 0; i < months; i++) {
            deposit += deposit * interestRate;
        }

        System.out.printf("После %d месяцев сумма вклада составит %.2f%n", months, deposit);
    }

    // Task 2: Заполните массив 50 случайными числами от 1 до 100.
    private static void task2() {
        System.out.println("Task 2: ");

        Random rand = new Random();
        int[] arr = new int[50];
        int primeCount = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(100) + 1;
        }

        // Вывод изначального содержимого массива
        System.out.println("Изначальный массив:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.println("Простые числа в массиве:");
        for (int num : arr) {
            if (isPrime(num)) {
                System.out.print(num + " ");
                primeCount++;
            }
        }

        System.out.println("\nКоличество простых чисел в массиве: " + primeCount);
    }

    // Определение простого числа
    private static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // Task3: Написать программу, выводящую на экран треугольник
    private static void task3() {
        System.out.println("Task 3: ");

        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
