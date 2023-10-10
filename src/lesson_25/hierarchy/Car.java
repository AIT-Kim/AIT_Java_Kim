package lesson_25.hierarchy;
/**
 * 10.10.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */
public class Car extends Vehicle {
    String brand;
    Animal owner;  // HAS-A отношение

    public Car(String brand, Animal owner) {
        super("Автомобиль");
        this.brand = brand;
        this.owner = owner;
    }

    @Override
    public String info() {
        return super.info() + ", бренд: " + brand + ", владелец: " + owner.species;
    }
}
