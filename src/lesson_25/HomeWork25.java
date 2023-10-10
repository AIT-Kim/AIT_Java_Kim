package lesson_25;
/**
 * 10.10.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */
/**
 HomeWork
 Добавить к классам из предыдущего домашнего задания хотя бы по одному полю имеющему связь HAS-A с классом Лучше пару полей :)

 */
import lesson_25.computer_and_components.Computer;
import lesson_25.computer_and_components.Memory;
import lesson_25.computer_and_components.Processor;
import lesson_25.computer_and_components.Storage;
import lesson_25.hierarchy.*;
import lesson_25.hierarchy.Vehicle;

public class HomeWork25 {
    public static void main(String[] args) {
        Vehicle collar = new Bicycle(true);
        Animal dog = new Dog("Бульдог", collar);
        Animal cat = new Cat(false);
        Vehicle car = new Car("Toyota", cat);

        System.out.println(dog.info());
        System.out.println(cat.info());
        System.out.println(car.info());

        //----

        Processor proc = new Processor("Intel", "i7");
        Memory mem = new Memory("Kingston", "8GB DDR4");
        Storage stor = new Storage("Samsung", "1TB SSD");

        Computer comp = new Computer(proc, mem, stor);
        System.out.println(comp);
    }
}
