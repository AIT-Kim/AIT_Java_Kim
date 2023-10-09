package lesson_24;
/**
 * 09.10.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */
public class Train extends Vehicle {
    public int maxPassengers;
    public int currentPassengers;
    public int wagons;
    public static final int WAGON_PASSENGERS = 32;

    public Train(String vehicleModel, int year, int wagons) {
        super(vehicleModel, year);
        this.wagons = wagons;
        this.maxPassengers = wagons * WAGON_PASSENGERS;
    }

    public int getWagons() {
        return wagons;
    }

    public void setWagons(int wagons) {
        maxPassengers = wagons * WAGON_PASSENGERS;
        this.wagons = wagons;
    }
}

