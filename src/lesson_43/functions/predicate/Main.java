package lesson_43.functions.predicate;

import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        ListFilter filter = new ListFilter();

        MyArrayList<Integer> numbers = new MyArrayList<>();
        numbers.addAll(10, -15, 20, 11, -28, 7, -5);

        MyArrayList<String> strings = new MyArrayList<>();
        strings.addAll("Hello", "Hi", "Marsel", "Henry", "Berlin");

        MyArrayList<Integer> filteredNumbers = filter.filter(numbers, x -> x % 2 == 0);
        MyArrayList<String> filteredStrings = filter.filter(strings, (word -> word.startsWith("H")));

        System.out.println(filteredNumbers);
        System.out.println(filteredStrings);
    }
}