package lesson_04;

/**
 * InputOutput
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */


public class Main5 {
    public static void main(String[] args) {
        // Создаем строку с текстом
        String message = "Hello, My name is Marsel, I'm ";

        // Создаем число со значением
        int age = 29;

        // Создаем еще одну строку с текстом
        String message2 = " years old, and my height is ";

        // Создаем еще одно число со значением
        double height = 1.85;

//        String text = message + age + message2 + height;
//        System.out.println(text);

        // Новая строка - это результат конкатенации строки и числа = строка
        String part1 = message + age;

        // Печатаем ее в консоль
        System.out.println(part1);

        // Аналогично предыдущему случаю
        String part2 = message2 + height;
        System.out.println(part2);
    }
}