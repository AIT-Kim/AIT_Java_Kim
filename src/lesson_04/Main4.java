package lesson_04;

/**
 * InputOutput
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */


public class Main4 {
    public static void main(String[] args) {
        // Объявляем переменные целых типов и потом их инициализируем
        int x;
        x = 10;
        int y;
        y = 5;
        int z;
        // Складываем два числа и получаем третье, как сумму этих чисел
        z = x + y;

        // Объявляем и инициализируем три строки
        String a = "Hello";
        String b = ", ";
        String c = "Marsel";
        // Соединяем их с помощью операции конкатенации - получаем четвертую строку, которая объединяет все предыдущие
        String d = a + b + c;
        // Выводим значения
        System.out.println(d);
        System.out.println(z);
    }
}