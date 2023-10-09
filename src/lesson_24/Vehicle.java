package lesson_24;
/**
 * 09.10.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */
public class Vehicle {
    private String vehicleModel;
    private int year;

    public Vehicle(String vehicleModel, int year) {
        System.out.println("Vehicle's Constructor");
        this.vehicleModel = vehicleModel;
        this.year = year;
    }

    public Vehicle() {
        this.vehicleModel = "Default";
    }

    public void ignite() {
        System.out.println(vehicleModel + " is starting");
    }

    public void halt() {
        System.out.println(vehicleModel + " is stopping");
    }

    @Override
    public String toString() {
        return vehicleModel + " Year: " + year;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
