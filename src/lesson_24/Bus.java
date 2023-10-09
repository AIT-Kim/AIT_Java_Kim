package lesson_24;
/**
 * 09.10.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */
public class Bus extends Vehicle {
    public int maxPassengers;
    public int currentPassengers;
    private int mileage; // Добавленный параметр пробег

    public Bus() {
        this.setVehicleModel("Bus-ModelX");
    }

    public Bus(String vehicleModel, int year, int maxPassengers, int mileage)  // Добавлен параметр пробег в конструктор
    {
        super(vehicleModel, year);
        System.out.println("Bus's Constructor");
        this.maxPassengers = maxPassengers;
        this.mileage = mileage; // Присваиваем значение параметру пробег
    }

    public void admitPassenger() {
        if (currentPassengers < maxPassengers) {
            currentPassengers++;
            System.out.println("A passenger boarded the bus " + this.getVehicleModel());
        } else {
            System.out.println("Bus is full!");
        }
    }

    public void deboardPassenger() {
        if (currentPassengers > 0) {
            currentPassengers--;
            System.out.println("A passenger left the bus");
        } else {
            System.out.println("No more passengers in the bus!");
        }
    }

    public int getMileage() {
        // Геттер для пробега
        return mileage;
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }

    public int getCurrentPassengers() {
        return currentPassengers;
    }
}
