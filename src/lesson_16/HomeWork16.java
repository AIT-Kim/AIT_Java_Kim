package lesson_16;

/**
 * 26.09.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */

public class HomeWork16 {


    public static void main(String[] args) {
        // Task 0
        System.out.println(toUpper("hello")); // HELLO

        //Task 1
        int[] nums = {0, 1, 2, 3, 4, 5, 6};
        swap(nums, 1, 5);
        for (int num : nums) {
            System.out.print(num + " "); // 0 5 2 3 4 1 6
        }
        System.out.println();

        // Task 2
        System.out.println(substring("Java", 1)); // ava
        System.out.println(substring("Java", 1, 3)); // av

        // Task 3
        String[] strings = {"Hello", "world", "Java"};
        System.out.println(contains(strings, "Java")); // true
        System.out.println(contains(strings, "Python")); // false

        // Task 4
        System.out.println(extractAndToUpper("Hello")); // EL
        System.out.println(extractAndToUpper("He")); // E
        System.out.println(extractAndToUpper("H")); //

        // Task 5
        int[] array = {1, 2, 3, 4, 5};
        System.out.println(sumOfArray(array)); // 15
    }

    /** Task 0
     * Написать метод переводящие все маленькие буквы латинского алфавита в строке в верхний регистр.
     * toUpperCase() использовать низзя.
     */
    public static String toUpper(String str) {
        StringBuilder result = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                result.append((char) (c - 'a' + 'A'));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    /** Task 1
     * Написать метод swap, принимающий на вход массив целых чисел, и два индекса.
     * Метод должен поменять местами значения, хранящихся в этих индексах
     *
     * {0, 1, 2, 3, 4, 5, 6} -> swap(arr, 1, 5} -> {0, 5, 2, 3, 4, 1, 6}
     * Если индексы за пределами массива?
     *
     * Перегрузка метода для работы с массивами строк.
     */
    public static void swap(int[] arr, int index1, int index2) {
        // Проверка валидности индексов
        if (index1 < 0 || index1 >= arr.length || index2 < 0 || index2 >= arr.length) {
            System.out.println("Один или оба индекса выходят за границы массива.");
            return;
        }

        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }


    public static void swap(String[] arr, int index1, int index2) {
        // Проверка валидности индексов
        if (index1 < 0 || index1 >= arr.length || index2 < 0 || index2 >= arr.length) {
            System.out.println("Один или оба индекса выходят за границы массива.");
            return;
        }

        String temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }


    /** Task 2
     * Написать метод, принимающий строку и один или два индекса (перегрузка).
     * Метод должен возвращать подстроку начиная с первого индекса (включительно) и
     * заканчивая вторым индексом (не включительно) Если индекс 1 - начиная с индекса и до конца строки.
     *
     * Функционал повторяет метод String.substring(), так что этот метод использовать не нужно.
     * Оригинальный метод ломает программу, если введены не корректные индексы.
     * Наш метод аварийно завершать программу не должен.
     */
    public static String substring(String str, int start) {
        if (start < 0 || start >= str.length()) {
            return "";
        }
        return substring(str, start, str.length());
    }

    public static String substring(String str, int start, int end) {
        if (start < 0 || start >= str.length() || end <= 0 || end > str.length() || start >= end) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        for (int i = start; i < end; i++) {
            result.append(str.charAt(i));
        }
        return result.toString();
    }

    /** Task 3
     * Написать метод по поиску строки в массиве строк. На вход метод принимает массив строк, и строку для поиска.
     */
    public static boolean contains(String[] arr, String target) {
        for (String s : arr) {
            if (s.equals(target)) {
                return true;
            }
        }
        return false;
    }

    /** Task 4
     *Написать метод, принимающий строку и возвращающий новую строку, состоящую из 2го и 3го символа входящей строки,
     * переведенных в верхний регистр. Распечатать полученный результат в методе main
     *
     * "Hello" -> "EL"
     * "He" -> "E"
     * "H" -> ???
     */
    public static String extractAndToUpper(String str) {
        if (str.length() < 2) {
            return "";
        }
        String extracted = str.length() >= 3 ? str.substring(1, 3) : str.substring(1, 2);
        return toUpper(extracted);
    }

    /** Task 5
     *Реализуйте метод sumOfArray (сумма элементов массива), который получает на вход массив и определяет сумму его элементов.
     */
    public static int sumOfArray(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }

}
