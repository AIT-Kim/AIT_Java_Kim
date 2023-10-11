package lesson_26.homework26.task2;
/**
 * 11.10.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */
/**
 Создайте иерархию классов для разных типов транспортных средств: Vehicle (родительский класс), Car, Bicycle и Motorcycle (дочерние классы).
 Родительский класс Vehicle должен иметь метод startEngine(), который не будет иметь реализации.
 Дочерние классы Car, Bicycle и Motorcycle должны переопределить метод startEngine() для запуска соответствующего типа двигателя (если есть).
 Создайте массив транспортных средств разных типов. Используйте полиморфизм для вызова метода startEngine() для каждого транспортного средства.

 */
public class Main {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
                new Car(),
                new Bicycle(),
                new Motorcycle()
        };

        for (Vehicle v : vehicles) {
            v.startEngine();
        }
    }
}
