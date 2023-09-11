//-------------------------------------------------
//	 Copyright (C) 2023
//	 Email:    evgeniikim@gmail.com
//   Author:   Yevhen Kim
//-------------------------------------------------
package homework_02;

public class HomeWork02 {

    public static String FirstName = "Yevhen";
    public static byte Age = 44;
    public static double Price_Milk = 0.90;
    public static String City = "Wolfhagen";

    public static void main(String[] args) {
        System.out.println("Hello world!");

        System.out.format("Меня зовут %s%n", FirstName);
        System.out.format("Мне %s %s%n", Age, GetAgeString(Age));
        System.out.format("Я из %s%n", City);
        System.out.format("Я купил молоко за %.2f€%n", Price_Milk);

        System.out.println("Я умею печатать спец.символы на клавиатуре: # < > + - , . : ; ( ) { } / \\ ");
        System.out.println("Символы напечатаны через пробел, как и просили");

        // # < > + - , . : ; ( ) { } / \

    }

    public static String GetAgeString(int age)
    {
        int ageLastNumber = age % 10;

        String old = "";
        boolean isExclusion = (age % 100 >= 11) && (age % 100 <= 14);

        if (ageLastNumber == 1)
            old = "год";
        else if(ageLastNumber == 0 || ageLastNumber >= 5 && ageLastNumber <= 9)
            old = "лет";
        else if(ageLastNumber >= 2 && ageLastNumber <= 4)
            old = "года";
        if (isExclusion)
            old = "лет";

        return old;
    }
}
