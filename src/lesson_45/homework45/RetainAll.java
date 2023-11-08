package lesson_45.homework45;

import java.util.*;

/*
 Напишите метод, который принимает на вход две реализации интерфейса List и
 возвращает список состоящий из элементов, которые присутствуют в обоих коллекциях.
 */
public class RetainAll {
    public static void main(String[] args) {
        List<String> strings = List.of("Apple", "Banana", "Lemon"); // Создание immutable коллекции. Статический метод. Появился в 9 Java
        System.out.println(strings);
        String str1 = strings.get(0);
        System.out.println(str1);

        List<Integer> integers = new ArrayList<>(List.of(1, 2, 3, 3, 4, 5)); // создание "нормальной" / изменяемой коллекции
        List<Integer> integers2 = new LinkedList<>(List.of(3, 4, 5, 5, 5, 6, 7, 8));
        System.out.println(intersection(integers, integers2));
        System.out.println(intersection(integers2, integers));

    }

    public static List<Integer> intersection(List<Integer> list1, List<Integer> list2) {
        List<Integer> result = new ArrayList<>(list1);
        result.retainAll(list2);
        return result;
    }
}