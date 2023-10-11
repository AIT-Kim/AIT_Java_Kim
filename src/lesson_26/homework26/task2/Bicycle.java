package lesson_26.homework26.task2;
/**
 * 11.10.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */
public class Bicycle extends Vehicle {
    @Override
    public void startEngine() {
        System.out.println("Bicycles don't have engines!");
    }
}