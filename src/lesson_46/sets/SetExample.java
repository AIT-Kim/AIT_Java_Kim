package lesson_46.sets;

import java.util.*;

public class SetExample {
    public static void main(String[] args) {
        // Конструкторы
        Set<Integer> integers = new HashSet<>(); //пустой конструктор. По умолчанию capacity 16, loadFactor = 0.75
        Set<Integer> integers1 = new HashSet<>(32); // принимает capacity
        Set<Integer> integers2 = new HashSet<>(32, 0.8f); // принимает capacity и loadFactor
        Set<Integer> integers3 = new HashSet<>(integers); // принимает коллекцию. Создает Set из уникальных элементов из коллекций

        Set<Integer> hashSet = new HashSet<>(List.of(1, 2, 3, 3, 2, 1, 4, 4, 5, 6, 15, 7, 8));
        System.out.println("hashSet " + hashSet);
        Set<Integer> linkedSet = new LinkedHashSet<>(List.of(1, 2, 3, 3, 2, 1, 4, 4, 5, 6, 15, 7, 8));
        System.out.println("linkedSet " + linkedSet);

        Set<Integer> treeSet = new TreeSet<>(List.of(1, 2, 3, 3, 2, 1, 4, 4, 5, 6, 15, 7, 8));
        System.out.println("treeSet: " + treeSet);

        treeSet = new TreeSet<>(Comparator.reverseOrder()); // в конструктор может быть передан компаратор
        treeSet.addAll(List.of(1, 2, 3, 3, 2, 1, 4, 4, 5, 6, 15, 7, 8));
        System.out.println("treeSet reversed: " + treeSet);


        Set<Integer> reversedSortedSet = new TreeSet<>((i1, i2) -> i2.compareTo(i1));
        reversedSortedSet.addAll(List.of(1, 2, 3, 3, 2, 1, 4, 4, 5, 6, 15, 7, 8));
        System.out.println("reversedSortedSet " + reversedSortedSet);

        // Task1
        // Написать метод, принимающий Список1 и возвращающий список2, состоящий только из уникальных значений, входящих в список1

        List<Integer> integerList = new ArrayList<>(List.of(1, 2, 3, 3, 2, 1, 4, 4, 5, 6, 15, 7, 8));
        List<Integer> uniqueList = getUniqueList(integerList);
        System.out.println("uniqueList: " + uniqueList);

        // Task2
        // Написать метод, принимающий Список1 и возвращающий список2, состоящий только из уникальных значений, входящих в список1;
        // список2 должен быть отсортирован в обратном порядке

        List<Integer> integerList2 = new ArrayList<>(List.of(1, 2, 3, 3, 2, 1, 4, 4, 5, 6, 15, 7, 8));
        List<Integer> uniqueList2 = getUniqueListReversed(integerList2);
        System.out.println("uniqueList2: " + uniqueList2);

    }

    public static <T> List<T> getUniqueList(List<T> list) {
        Set<T> result = new HashSet<>(list);
        return new ArrayList<>(result);
    }

    public static  List<Integer> getUniqueListReversed(List<Integer> list) {
        Set<Integer> result = new TreeSet<>((i1, i2) -> i2.compareTo(i1));
        result.addAll(list);
        return new ArrayList<>(result);
    }

}