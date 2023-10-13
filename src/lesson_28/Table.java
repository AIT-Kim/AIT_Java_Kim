package lesson_28;

public class Table {

    // внутренний класс, Inner
    public class Printer {

        private final String prefix;

        public Printer(String prefix) {
            this.prefix = prefix;
        }

        public void print() {
            for (int i = 0; i < count; i++) { // пробегает массив из table
                Pair current = pairs[i]; // получили i-ю пару таблицы, к которой привязан наш Printer
                System.out.println(prefix + " " + current); // печатает
            }
        }
    }

    // вложенный класс, Nested
    private static class Pair {

        private final String key; // ключ

        private int value; // значение

        public Pair(String key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return key + "-" + value;
        }
    }

    private final Pair[] pairs; // массив пар ключ-значение

    private int count; // количество элементов в массиве

    public Table() {
        this.pairs = new Pair[10]; // создаем массив из 10-и элементов (всего может содержать 10 пар)
        this.count = 0; // изначально элементов в массиве ноль
    }

    /**
     * Позволяет добавить в таблицу новую пару ключ-значение
     * @param key ключ, в нашей таблице гарантируется его уникальность
     * @param value значение, которое будет соответствовать этому ключу
     */
    public void put(String key, int value) {
        // Нам необходимо создать новую пару и положить в массив.
        // Но перед этим надо убедиться, что такого ключа еще не было.
        // Если такой ключ уже был - нужно только заменить значение

        for (int i = 0; i < count; i++) { // пробегаем все пары, которые уже есть в массиве

            Pair current = pairs[i]; // получим текущую i-ую пару

            // смотрим ключ, который содержится в current
            if (current.key.equals(key)) { // Если у текущей пары массива ключ совпадает с ключом, который мы добавляем.
                // Надо заменить значение тем, которое мы подали на вход
                current.value = value;
                return; // останавливаем работу метода, зачем нам проверять остальные пары?
            }
        }

        // если такого ключа еще не было, то return не будет вызван и мы окажемся здесь
        // это тот случай, когда мы просто должны добавить пару ключ-значение

        Pair newPair = new Pair(key, value); // создали новую пару ключ-значение
        // нужно положить ее в массив
        pairs[count] = newPair; // кладем в первую пустую ячейку, а это как раз pairs[count]
        count++; // увеличиваем count на 1, мы же добавили новый элемент!
    }

    /**
     * Получение значения по ключу
     * @param key ключ, соответствующее значение которого нужно получить
     * @return целое число, представляющее собой значение из таблицы
     */
    public int get(String key) {
        // нужно найти пару ключ-значение
        // пробегаем по всем парам и ищем нужный ключ
        for (int i = 0; i < count; i++) {
            Pair current = pairs[i]; // получили текущую пару

            if (current.key.equals(key)) { // если у текущей пары ключ-значение совпадает ключ с тем, который ищем
                // возвращаем значение
                return current.value;
            }
        }
        // если ничего не нашли, возвращаем 0
        return 0;
    }

    public Pair[] getPairs() {
        return pairs;
    }

    public int getCount() {
        return count;
    }
}
