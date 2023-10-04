package lesson_21;
/**
 * 04.10.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */
public class Car {

    static int totalCars;
    private final String carModel;
    private int enginePower;

    public Car(String carModel, int enginePower) {
        this.carModel = carModel;
        this.enginePower = enginePower;
        totalCars++;
    }

    public void displayInfo() {
        System.out.println("Car model: " + carModel + "; Power: " + enginePower + ". Total cars produced: " + totalCars);
    }

    public static int getTotalCars() {
        return totalCars;
    }

    public static void main(String[] args) {
        Car firstCar = new Car("BMW", 200);
        Car secondCar = new Car("Skoda", 150);

        firstCar.displayInfo();
        System.out.println("Total cars created: " + Car.totalCars);
        System.out.println("Total cars created via method: " + Car.getTotalCars());
    }
}