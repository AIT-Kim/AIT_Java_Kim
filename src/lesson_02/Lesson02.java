//-------------------------------------------------
//	 Copyright (C) 2023
//	 Email:    evgeniikim@gmail.com
//   Author:   Yevhen Kim
//-------------------------------------------------
package lesson_02;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.DayOfWeek;



public class Lesson02 {

    public static void main(String[] args) throws Exception {
        Task_01();
        Task_02();
        Task_03();
        Task_04();
        Task_05();
    }

    /**
     * Task 01 ---------------------
     * Объявите 10 переменных типа int со значениями 0,1, 2, 3, 4, 5, 6, 7, 8, 9.
     * Объявите ещё одну переменную int и сохраните в неё сумму этих переменных, деленную на 10.
     * Получается, у вас будет среднее арифметическое этих чисел в одной переменной.
     * Распечатайте её через println. Сколько программа отбросила в дробной части?
     */
    public static void Task_01() throws Exception {
        int condition = 10;

        int val01 = 0;
        int val02 = 1;
        int val03 = 2;
        int val04 = 3;
        int val05 = 4;
        int val06 = 5;
        int val07 = 6;
        int val08 = 7;
        int val09 = 8;
        int val10 = 9;
        int result;

        int sum = val01 + val02 + val03 + val04 + val05 + val06 + val07 + val08 + val09 + val10;
        result = sum / condition;

        System.out.println("Task 1:");
        System.out.format("In the fractional part: %s%n", result);
        System.out.format("The program discarded the fractional part because of type conversion. We lost: 0.%s%n", sum % condition);
        System.out.println("");

    }

    /**
     * Task 02 ---------------------
     * Пусть цена товара A обычно составляет 1000 Euro, и товара B составляет 500 Euro.
     * Если клиент покупает товары вместе, то на них действует скидка 10% на всю покупку.
     * Выведите на экран переменную, которая соответствует стоимости суммы A+B со скидкой.
     * Отдельно выведите на экран сумму скидки от этой покупки.
     */
    public static void Task_02() throws Exception {
        double product_A = 1000;
        double product_B = 500;
        int discont_01 = 10;
        List<Double> products = new ArrayList<Double>();

        products.add(product_A);
        products.add(product_B);

        double card = products.stream().mapToDouble(Double::doubleValue).sum();
        double card_discount = card / discont_01;
        double amount = card - card_discount;

        System.out.println("Task 2:");
        System.out.format("Payable, including discount: %.2f€%n", amount);
        System.out.format("Discount %.2f€ (%d%%)%n", card_discount, discont_01);
        System.out.println("");

/*
        //Basic solution
        double product_A = 1000;
        double product_B = 500;
        double discont_01 = 10;

        double card = product_A + product_B;
        double card_discount = card / discont_01;
        double amount = card - card_discount;

        System.out.println("Task 2:");
        System.out.println(amount);
        System.out.println(card_discount);
*/
    }

    /**
     * Task 03 ---------------------
     *  Найдите в Интернете данные по температуре в вашем городе за прошедшую неделю.
     *  Вычислите среднюю температуру за неделю и выведете ее на печать.
     */
    public static void Task_03() throws Exception {
        System.out.println("Task 3:");

        //calculate dates for prev week
        LocalDate now = LocalDate.now();
        LocalDate lastWeekStart = now.minusWeeks(1).with(DayOfWeek.MONDAY);
        LocalDate lastWeekEnd = lastWeekStart.plusDays(6);

        String location = "Wolfhagen,DE";
        var temps = TimelineApiForecast.GetForecast(location, lastWeekStart, lastWeekEnd);
        if ((temps != null) && (temps.stream().count() > 0)) {
            Double avgTemp = temps.stream().mapToDouble(Double::doubleValue).sum() / temps.stream().count();
            System.out.format("Average temperature for the previous week (from %s to %s): %.2f°%n", lastWeekStart, lastWeekEnd, avgTemp);

        } else {
            System.out.println("Data not found!");
        }
        System.out.println("");
    }

    /**
     * Task 04 ---------------------
     *  Какие числа могут получаться в качестве остатка от деления какого-либо целого числа на 2? На 3?
     *  Покажите это на конкретных примерах.
     */
    public static void Task_04() throws Exception {
        System.out.println("Task 4:");
        List<Integer> list = new ArrayList<Integer>();
        int factorialLimit = 1000;
        int condition = 2;
        for(int i=0; i<factorialLimit; i++)
        {
            int data = i % condition;
            if (!list.contains(data))
                list.add(data);
        }
        System.out.format("Numbers that result as the remainder of dividing an integer by %d: %s%n", condition, list);

        list.clear();
        condition = 3;
        for(int i=0; i<factorialLimit; i++)
        {
            int data = i % condition;
            if (!list.contains(data))
                list.add(data);
        }
        System.out.format("Numbers that result as the remainder of dividing an integer by %d: %s%n", condition, list);

        System.out.println("");

    }

    /**
     * Task 05 ---------------------
     * int x = 3 Чему будет равно значение х после выполнения операции x += x++ ?
     * Проверьте свое предположение на практике.
     */
    public static void Task_05() throws Exception {
        System.out.println("Task 5:");
        int sourceX = 3;
        int x = sourceX;
        x += x++;
        System.out.format("The result of the operation (x += x++), if x = %s : %s%n", sourceX, x);

        System.out.println("");

    }


}

