package lesson_24.hierarchy;
/**
 * 09.10.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */
public class Car extends Vehicle {
    String brand;

    public Car(String brand) {
        super("Автомобиль");
        this.brand = brand;
    }

    @Override
    public String info() {
        return super.info() + ", бренд: " + brand;
    }
}
