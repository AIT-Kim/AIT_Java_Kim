package lesson_39.CarsPredicate.lib;

public interface MyList<T> extends Iterable<T> {
    void add(T value);

    void addAll(T... values);

    int size();

    int indexOf(T value);

    int lastIndexOf(T value);

    boolean contains(T value);

    T[] toArray();

    boolean remove(T value);

    T remove(int index);

    // Отвечает на вопрос является ли коллекция пустой
    boolean isEmpty();

    T get(int index);

}
