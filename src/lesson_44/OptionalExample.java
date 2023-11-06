package lesson_44;

import lesson_35.myArrayList.MyArrayList;
import lesson_35.myArrayList.MyList;

import java.util.Optional;

public class OptionalExample {

    public static void main(String[] args) {

        MyList<Integer> integers = new MyArrayList<>();

        integers.addAll(1, 5, 6, 7, 8, 8, 9);

        Optional<Integer> res = getByIndex(20, integers);

        System.out.println(res.isPresent()); // Проверяет, что в Optional есть хначение типа Integer
        System.out.println(res.isEmpty()); // что пришел пустой Optional

        Integer var = 0;
        if (res.isPresent()) {
            var = res.get();
        }
        System.out.println(var);

        Integer var2 = res.orElse(100);
        System.out.println("var2 " + var2);

        Optional<Integer> optional = Optional.empty(); // создает пустой Optional
        System.out.println("present " + optional.isPresent());
        System.out.println("empty " + optional.isEmpty());

    }

    public static Optional<Integer> getByIndex(int idx, MyList<Integer> integers) {
        Integer result;
        if (idx < 0 || idx >= integers.size()) {
            result = null;
        } else {
            result = integers.get(idx);
        }

        return  Optional.ofNullable(result);

    }
}