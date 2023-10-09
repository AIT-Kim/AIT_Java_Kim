package lesson_24;
/**
 * 09.10.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */
public class InternationalBus extends Bus {
    private String[] travelCountries;

    public InternationalBus(String vehicleModel, int year, int maxPassengers, int mileage, String[] travelCountries) {
        super(vehicleModel, year, maxPassengers, mileage);
        this.travelCountries = travelCountries;
    }

    public InternationalBus(String vehicleModel, int year, int maxPassengers, int mileage) {
        super(vehicleModel, year, maxPassengers, mileage);
        this.travelCountries = new String[0];
    }

    public void startJourney() {
        System.out.println(getVehicleModel() + " is starting the route");
        depart("Italy");
        halt();
    }

    public String[] getTravelCountries() {
        return travelCountries;
    }

    public void setTravelCountries(String[] travelCountries) {
        this.travelCountries = travelCountries;
    }

    public void depart(String country) {
        System.out.println("Departing from " + country);
    }
}

