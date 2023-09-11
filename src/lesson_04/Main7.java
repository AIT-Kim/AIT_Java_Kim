package lesson_04;

import java.util.Scanner;

/**
 * InputOutput
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */


public class Main7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Создали сканнер для чтения данных из консоли

        System.out.println("Введите первое слово:");
        String word1 = scanner.nextLine(); // Считали первую строку из консоли
        System.out.println("Введите второе слово:");
        String word2 = scanner.nextLine(); // Считали вторую строку из консоли

        String result = word1 + word2; // Соединили эти два слова и положили их в третье

        System.out.println(result); // Вывели на экран
    }
}