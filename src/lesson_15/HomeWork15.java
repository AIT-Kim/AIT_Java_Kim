package lesson_15;

/**
 * 25.09.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */

public class HomeWork15 {


    public static void main(String[] args) {
        // Test Task 0
        System.out.println(isPrime(13));  // true

        // Test Task 1
        int[] numbers = {0, 13, -25, 11, 31, 55, 98, 11, 5};
        System.out.println(countPrimes(numbers));  // 5

        // Test Task 2
        String[] strings = {"iPhone", "world", "Java", "AIT", "a"};
        String[] resultStrings = shortestAndLongest(strings);
        System.out.println("Shortest: " + resultStrings[0] + ", Longest: " + resultStrings[1]);

        // Test Task 3 (optional)
        int[] primeNumbers = filterPrimes(numbers);
        for (int prime : primeNumbers) {
            System.out.print(prime + " ");
        }
    }

    /** Task 0
     * Написать метод принимающий целое число и проверяющий является ли число простым.
     * Если является, метод должен вернуть true, не является - false
     */
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    /** Task 1
     * Написать метод, принимающий массив целых чисел. Метод должен вернуть количество простых чисел в массиве.
     * Для проверки на "простоту" числа рекомендуется использовать метод из Task 0
    */
    public static int countPrimes(int[] numbers) {
        int count = 0;
        for (int num : numbers) {
            if (isPrime(num)) {
                count++;
            }
        }
        return count;
    }

    /** Task 2
     * Написать метод, принимающий на вход массив строк.
     * Метод должен вернуть массив, состоящий из самой короткой и самой длинной строки изначального массива.
    */
    public static String[] shortestAndLongest(String[] strings) {
        if (strings == null || strings.length == 0) {
            return new String[0]; // empty array
        }

        String shortest = strings[0];
        String longest = strings[0];

        for (String str : strings) {
            if (str.length() < shortest.length()) {
                shortest = str;
            }
            if (str.length() > longest.length()) {
                longest = str;
            }
        }
        return new String[]{shortest, longest};
    }

    /** Task 3 (optional)
     * Написать метод, принимающий на вход массив целых чисел.
     * Метод должен вернуть массив, состоящий только из простых чисел, присутствующих в изначальном массиве
    */
    public static int[] filterPrimes(int[] numbers) {
        int[] primes = new int[countPrimes(numbers)];
        int index = 0;

        for (int num : numbers) {
            if (isPrime(num)) {
                primes[index++] = num;
            }
        }

        return primes;
    }


}
