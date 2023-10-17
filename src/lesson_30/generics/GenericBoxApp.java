package lesson_30.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericBoxApp {

    public static void main(String[] args) {

        GenericBox<String> stringBox = new GenericBox<>("Hello");
        GenericBox<String> stringBox2 = new GenericBox<>(", world");
        System.out.println(stringBox);
        System.out.println(stringBox.getValue() + stringBox2.getValue());

        // Дженерики не поддерживают примитивные типы данных
        //GenericBox<int> intBox = new GenericBox<>();
        GenericBox<Integer> intBox = new GenericBox<>(150);
        GenericBox<Integer> intBox2 = new GenericBox<>(20);
        System.out.println(intBox.getValue() + intBox2.getValue());

        // ограничение снизу. Класс и все его родители.
        GenericBox<? super Integer> gBox = new GenericBox<>(150.5);
        System.out.println(gBox.toString());

    }
}
