package lesson_20;

import java.util.Arrays;
import java.util.Random;

class RubberArray20 {
    private int[] array;
    private int size;  // текущий размер (не ёмкость) массива

    public RubberArray20() {
        array = new int[10];  // начальная ёмкость
        size = 0;
    }

    public void add(int... values) {
        ensureCapacity(size + values.length);
        System.arraycopy(values, 0, array, size, values.length);
        size += values.length;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > array.length) {
            int newCapacity = Math.max(minCapacity, array.length * 2);
            array = Arrays.copyOf(array, newCapacity);
        }
    }

    public boolean contains(int value) {
        return indexOf(value) != -1;
    }

    public int indexOf(int value) {
        for (int i = 0; i < size; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(int value) {
        for (int i = size - 1; i >= 0; i--) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public boolean removeValue(int value) {
        int index = indexOf(value);
        if (index == -1) return false;
        removeAt(index);
        return true;
    }

    public void removeAt(int index) {
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        size--;
    }

    public int min() {
        int minValue = array[0];
        for (int i = 1; i < size; i++) {
            if (array[i] < minValue) minValue = array[i];
        }
        return minValue;
    }

    public int max() {
        int maxValue = array[0];
        for (int i = 1; i < size; i++) {
            if (array[i] > maxValue) maxValue = array[i];
        }
        return maxValue;
    }

    public double average() {
        return (double) sum() / size;
    }

    public int sum() {
        int total = 0;
        for (int i = 0; i < size; i++) {
            total += array[i];
        }
        return total;
    }

    public int size() {
        return size;
    }

    public void addRandom(int count) {
        addRandom(count, 0, Integer.MAX_VALUE);
    }

    public void addRandom(int count, int from, int to) {
        Random rand = new Random();
        for (int i = 0; i < count; i++) {
            add(rand.nextInt(to - from) + from);
        }
    }

    public int[] toArray() {
        return Arrays.copyOf(array, size);
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(array, size));
    }
}

