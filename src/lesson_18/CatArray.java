package lesson_18;

/**
 * 28.09.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */

import java.util.Arrays;

public class CatArray {
    private String[] cats;
    private int size;

    // Конструктор, принимающий в себя обычный массив
    public CatArray(String[] initialCats) {
        this.cats = Arrays.copyOf(initialCats, initialCats.length);
        this.size = initialCats.length;
    }

    // Добавление котика
    public void addCat(String catName) {
        ensureCapacity(size + 1);
        cats[size++] = catName;
    }

    // Вывод всех котиков
    public void displayCats() {
        for (int i = 0; i < size; i++) {
            System.out.print(cats[i] + " ");
        }
        System.out.println();
    }

    // Поиск котика по имени
    public int indexOfCat(String catName) {
        for (int i = 0; i < size; i++) {
            if (cats[i].equals(catName)) {
                return i;
            }
        }
        return -1;  // не найдено
    }

    // Получение имени котика по индексу
    public String getCat(int index) {
        if (index >= 0 && index < size) {
            return cats[index];
        }
        return null;
    }

    // Текущее количество котиков
    public int catCount() {
        return size;
    }

    // Удаление котика по индексу
    public void removeCat(int index) {
        if (index >= 0 && index < size) {
            for (int i = index; i < size - 1; i++) {
                cats[i] = cats[i + 1];
            }
            size--;
        }
    }

    // Добавление нескольких котиков
    public void addCats(String... catNames) {
        for (String catName : catNames) {
            addCat(catName);
        }
    }

    // Удаление котика по имени
    public void removeCatByName(String catName) {
        int index = indexOfCat(catName);
        if (index != -1) {
            removeCat(index);
        }
    }

    // Замена имени котика по индексу
    public void replaceCatName(int index, String newName) {
        if (index >= 0 && index < size) {
            cats[index] = newName;
        }
    }

    // Замена имени одного котика на другое
    public void replaceCatName(String oldName, String newName) {
        int index = indexOfCat(oldName);
        if (index != -1) {
            cats[index] = newName;
        }
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > cats.length) {
            int oldCapacity = cats.length;
            int newCapacity = oldCapacity + (oldCapacity >> 1); // увеличиваем размер массива на 50%
            cats = Arrays.copyOf(cats, newCapacity);
        }
    }


}
