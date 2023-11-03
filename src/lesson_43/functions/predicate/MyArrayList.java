package lesson_43.functions.predicate;

import java.util.Iterator;
import java.util.Random;

public class MyArrayList<T> implements Iterable<T> {
    private T[] array;
    private int cursor;
    static final int MULTIPLIER = 2;

    Random random = new Random();

    public MyArrayList() {
        array = (T[]) new Object[10];
    }

    public MyArrayList(int sizeDefault) {
        array = (T[]) new Object[sizeDefault];
    }

    public void add(T number) {
        if (cursor == array.length - 1) {
            expandArray();
        }
        array[cursor++] = number;
    }


    public void addAll(T... values) {
        for (T value : values) {
            add(value);
        }
    }

    private void expandArray() {
//        int[] newArray = Arrays.copyOf(array, array.length * 2);
        T[] newArray = (T[]) new Object[array.length * MULTIPLIER];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    @Override
    public String toString() {
        if (cursor == 0) return "[]";
        String result = "[";
        for (int i = 0; i < cursor; i++) {
            result += array[i] + ((i < cursor - 1) ? ", " : "]");
        }
        return result;
    }

    public int size() {
        return cursor;
    }

    public int indexOf(T value) {
        // 1. Перебрать массив, сравнить элементы, вернуть индекс
        // Если совпадений нет - вернуть минус 1.

        for (int i = 0; i < cursor; i++) {
//            if (array[i] == value) return i;
            if (array[i].equals(value)) return i;
        }
        return -1;
    }

    public int lastIndexOf(T value) {

        for (int i = cursor - 1; i >= 0; i--) {
            if (array[i].equals(value)) return i;
        }
        return -1;
    }

    public boolean contains(T value) {
        return indexOf(value) >= 0; //переиспользуем уже написанный код (метод)
    }

    public boolean remove(T value) {
        int index = indexOf(value);
        remove(index);
        return index >= 0;
    }


    public T remove(int index) {
        if (index < 0 || index > cursor - 1) return null;

        T value = array[index];

        T[] result = (T[]) new Object[array.length - 1];

        for (int i = 0; i < result.length; i++) {
            if (i < index) {
                result[i] = array[i];
            } else { // i >= index
                result[i] = array[i + 1];
            }
        }

        cursor--;
        array = result;

        return value;
    }

    public boolean isEmpty() {
        return cursor == 0;
    }

    public T get(int index) {
        if (index < 0 || index > cursor - 1) return null;
        return array[index];
    }

    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T> {

        int currentIndex;

        @Override
        public boolean hasNext() {
            return currentIndex < cursor;
        }

        @Override
        public T next() {
            return array[currentIndex++];
        }
    }

    public T[] toArray() {
        T[] result = (T[]) new Object[cursor];
        for (int i = 0; i < cursor; i++) {
            result[i] = array[i];
        }
        return result;
    }

    public void trim() {
        array = toArray();
    }
}