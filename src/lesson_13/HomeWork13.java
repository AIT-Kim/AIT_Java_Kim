package lesson_13;
/**
 * 21.09.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */

import java.util.Arrays;

public class HomeWork13 {

    public static void main(String[] args) {
        // Task 0
        int[] arr = {1, 4, 3, 6, 7};
        System.out.println("Task 0:");
        printArrayReverse(arr);
        printArrayReverse(arr, 2);
        printArrayReverse(arr, false);

        // Task 1
        System.out.println("\nTask 1:");
        printPowerOfTwo(5);

        // Task 2
        System.out.println("\nTask 2:");
        int[] sampleArray = {0, 1, 2, 3, 4 , 5, 6};
        copyOfArray(sampleArray, 3);

        // Task 3
        System.out.println("\nTask 3:");
        int[] array1 = {100, 112, 256, 349, 770};
        int[] array2 = {72, 86, 113, 119, 265, 445, 892};
        findKthElement(array1, array2, 7);
    }

    /** Task 0
     * Написать метод, принимающий массив целых чисел и распечатывающий массив в обратной последовательности.
     *
     * {1, 4, 3, 6, 7} -> распечатывает [7, 6, 3, 4, 1]
     * Перегрузить метод, если в него приходит индекс, то часть массива слева до этого индекса распечатывается в обычном порядке, а начиная с этого индекса в обратном:
     *
     * {1, 4, 3, 6, 7} + индекс 2 - > распечатывает [1, 4, 7, 6, 3]
     * Еще одна перегрузка: метод принимает массив и булевый флаг. Если флаг == true -> печатает массив в обратном порядке Если флаг == false -> печатает массив в прямом порядке
    */
    public static void printArrayReverse(int[] array) {
        System.out.print("[");
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i]);
            if (i != 0) System.out.print(", ");
        }
        System.out.println("]");
    }

    public static void printArrayReverse(int[] array, int index) {
        System.out.print("[");
        for (int i = 0; i < index; i++) {
            System.out.print(array[i] + ", ");
        }
        for (int i = array.length - 1; i >= index; i--) {
            System.out.print(array[i]);
            if (i != index) System.out.print(", ");
        }
        System.out.println("]");
    }

    public static void printArrayReverse(int[] array, boolean flag) {
        System.out.print("[");
        if (flag) {
            for (int i = array.length - 1; i >= 0; i--) {
                System.out.print(array[i]);
                if (i != 0) System.out.print(", ");
            }
        } else {
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i]);
                if (i != array.length - 1) System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    /** Task 1
     * Написать метод, принимающий на вход целое число. Метод должен вывести на экран 2 в степени этоЧисло
     *
     * класс Math для нахождения степени числа использовать нельзя ;)
    */
    public static void printPowerOfTwo(int exponent) {
        long result = 1;
        for (int i = 1; i <= exponent; i++) {
            result *= 2;
        }
        System.out.println(result);
    }

    /** Task 2 опционально

     Написать свой метод copyOfArray, дублирующий функционал метода Arrays.copyOf()

     на вход принимает массив целых чисел и число - длинну нового массива. Метод должен создать и распечатать массив заданной в параметрах длинны. В начало массива должны быть скопированы элементы из входящего массива:

     {0, 1, 2, 3, 4 , 5, 6} -> copyOfArray(array, 3) -> вывод на печать {0, 1, 2}
     Arrays.copyOf() использовать нельзя. Суть задачи - написать собственную реализацию этого метода
    */
    public static void copyOfArray(int[] array, int newLength) {
        int[] newArray = new int[newLength];
        for (int i = 0; i < newLength; i++) {
            newArray[i] = array[i];
        }
        System.out.println(Arrays.toString(newArray));
    }

    /** Task 3
     * опционально
     *
     * Дано: Два отсортированных массива целых чисел. Вам нужно найти элемент, который будет находиться на k-й позиции в объединенном отсортированном массиве.
     *
     * Массив 1 - {100, 112, 256, 349, 770}
     * Массив 2 - {72, 86, 113, 119, 265, 445, 892}
     * k = 7
     * Вывод : 256
     *
     * Можно такой вывод:
     *
     * 72, 86, 100, 112, 113, 119, 256
     * Искомое число: 256
     * Объединенный отсортированный массив был бы такой (выводить, формировать его не обязательно) -
     *
     * [72, 86, 100, 112, 113, 119, 256, 265, 349, 445, 770, 892]
     * 7-й элемент (по счету) этого массива хранит значение 256.
    */
    public static void findKthElement(int[] array1, int[] array2, int k) {
        int m = array1.length;
        int n = array2.length;
        int i = 0, j = 0, count = 0;
        int result = -1;

        while (i < m && j < n) {
            if (array1[i] < array2[j]) {
                count++;
                if (count == k) {
                    result = array1[i];
                    break;
                }
                i++;
            } else {
                count++;
                if (count == k) {
                    result = array2[j];
                    break;
                }
                j++;
            }
        }

        while (i < m) {
            count++;
            if (count == k) {
                result = array1[i];
                break;
            }
            i++;
        }

        while (j < n) {
            count++;
            if (count == k) {
                result = array2[j];
                break;
            }
            j++;
        }

        System.out.println("Искомое число: " + result);
    }
}
