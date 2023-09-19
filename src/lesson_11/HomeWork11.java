package lesson_11;

/**
 * 19.09.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */

import java.util.Random;

public class HomeWork11 {

    public static void main(String[] args) {
        task0();
        task1();
        task2();
    }

    // Task 0: Дан массив целых чисел. Вывести на экран:
    // минимальное значение, максимальное и среднее арифметическое всех значений в массиве.
    private static void task0() {
        // Создание и инициализация массива случайными значениями
        int[] array = new int[10];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100) - 50;  // Генерация числа в диапазоне от -50 до 49
        }

        // Вывод исходного массива
        System.out.println("Исходный массив:");
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();

        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        int sum = 0;

        for (int num : array) {
            if (num < minValue) minValue = num;
            if (num > maxValue) maxValue = num;
            sum += num;
        }

        System.out.println("Минимальное значение: " + minValue);
        System.out.println("Максимальное значение: " + maxValue);
        System.out.println("Среднее значение: " + (double) sum / array.length);
    }

    // Task 1: Дан массив целых чисел. Поменять местами элемент с максимальным и минимальным значением.
    private static void task1() {
        int[] array = {5, 6, -25, 0, 31, -15};

        // Вывод исходного массива
        System.out.println("Исходный массив:");
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();

        int minIndex = 0;
        int maxIndex = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] < array[minIndex]) minIndex = i;
            if (array[i] > array[maxIndex]) maxIndex = i;
        }

        // Поменять элементы местами
        int temp = array[minIndex];
        array[minIndex] = array[maxIndex];
        array[maxIndex] = temp;

        // Вывод массива после манипуляций
        System.out.println("Массив после манипуляций:");
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    // Task 2: Дан массив строк. Вывести на экран все символы из самой длинной строки массива.
    private static void task2() {
        String[] strings = {"One", "Two", "Twenty"};

        // Вывод содержимого массива
        System.out.println("Содержимое массива:");
        for (String str : strings) {
            System.out.println(str);
        }

        String longestString = "";

        for (String s : strings) {
            if (s.length() > longestString.length()) {
                longestString = s;
            }
        }

        // Вывод символов самой длинной строки
        System.out.println("Символы из самой длинной строки:");
        for (char c : longestString.toCharArray()) {
            System.out.println(c);
        }
    }
}
