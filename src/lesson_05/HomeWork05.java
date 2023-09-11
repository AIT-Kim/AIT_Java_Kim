package lesson_05;

/**
 * 11.09.2023
 * Char&String types
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */

public class HomeWork05 {

    public static void main(String[] args) {
        // Task 01
        /*
           Создайте переменную с типом String, в которой будет хранится ВАше имя.
           Сколько букв в вашем имени? Выведите значение на экран
           Создайте две переменные типа char. Одной присвойте первый символ имени, второй - последний символ
           Выведите на экран десятичный код первого и последнего символа вашего имени
         */
        String myName = "Yevhen";
        System.out.println("Name is: " + myName);
        System.out.println("Количество букв в имени: " + myName.length());

        char firstChar = myName.charAt(0);
        char lastChar = myName.charAt(myName.length() - 1);

        System.out.println("Десятичный код первого символа: " + (int) firstChar);
        System.out.println("Десятичный код последнего символа: " + (int) lastChar);

        // Task 02
        /*
           Создайте строки:
            "Java"
            "is"
            "a"
            "powerful"
            "language"
           Из созданных строк склейте двумя разными способами строку: "Java is a powerful language"
           Распечатать эту строку и ее длину
         */
        String str1 = "Java";
        String str2 = "is";
        String str3 = "a";
        String str4 = "powerful";
        String str5 = "language";

        String combinedStr = str1 + " " + str2 + " " + str3 + " " + str4 + " " + str5;
        System.out.println(combinedStr);
        System.out.println("Длина строки: " + combinedStr.length());

        // Task 02.2
        /*
            Заменить в результирующей строке слово "powerful" на "super"
            Содержит ли строка подстроку "age"? Создайте переменную boolean типа c ответом
         */
        String replacedStr = combinedStr.replace("powerful", "super");
        System.out.println(replacedStr);
        boolean containsSubString = replacedStr.contains("age");
        System.out.println("Содержит ли строка подстроку 'age'? " + containsSubString);

        // Task 03 *опционально
        /*
            Даны строки разной длины (длина - четное число)
                "string"
                "code"
                "Practice"
            Необходимо распечатать два средних символа строки.
            Например, если дана строка "string" - результат будет "ri", для строки "code" результат "od",
            для "Practice" результат "ct".
         */
        printMiddleChars("string");
        printMiddleChars("code");
        printMiddleChars("Practice");
    }

    /**
     * In the function, the case of using an odd number of characters is considered.
     * In any scenario, the function outputs two characters from the middle of the string.
     */
    public static void printMiddleChars(String s) {
        int middle = s.length() / 2;
        System.out.println(s.substring(middle - 1, middle + 1));
    }
}