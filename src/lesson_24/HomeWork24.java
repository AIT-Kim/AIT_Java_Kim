package lesson_24;
/**
 * 09.10.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */
/**
 HomeWork
 Написать как минимум одну иерархию классов в которой будет один родительский клас и два наследника, расширяющих его функционал
 Лучше придумать две такие иерархии
 У всех классов должен быть метод создающий строку с информацией об объекте (метод String info())

 */
import lesson_24.hierarchy.*;
import lesson_24.hierarchy.Vehicle;

public class HomeWork24 {
    public static void main(String[] args) {
        Animal dog = new Dog("Бульдог");
        Animal cat = new Cat(false);

        System.out.println(dog.info());
        System.out.println(cat.info());

        Vehicle car = new Car("Toyota");
        Vehicle bicycle = new Bicycle(true);

        System.out.println(car.info());
        System.out.println(bicycle.info());
    }
}
