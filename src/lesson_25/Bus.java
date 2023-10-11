package lesson_25;
/**
 * 10.10.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */
public class Bus {

    private final int busID;
    private final String vehicleModel;
    private int distanceCovered;
    private final int maxPassengers;

    private BusDriver assignedDriver;
    private final Passenger[] busPassengers;

    private final AutoPilot pilotSystem;
    private int passengerCount;
    private static int busCounter;
    private static int ticketIDGenerator;

    public Bus(String model, int maxSeats) {
        this.vehicleModel = model;
        this.maxPassengers = maxSeats;
        this.busID = busCounter++;
        busPassengers = new Passenger[maxSeats];
        this.pilotSystem = new AutoPilot("V.001-B");
    }

    public Bus(String model, int maxSeats, BusDriver assignedDriver) {
        this.assignedDriver = assignedDriver;
        this.vehicleModel = model;
        this.maxPassengers = maxSeats;
        this.busID = busCounter++;
        busPassengers = new Passenger[maxSeats];
        this.pilotSystem = new AutoPilot("V.001-B");
    }

    public boolean boardPassenger(Passenger traveler) {
        if (passengerCount < maxPassengers) {
            traveler.setTicketCode(generateTicketCode(traveler.getPassengerID()));
            busPassengers[passengerCount++] = traveler;
            return true;
        }
        return false;
    }

    public boolean offboardPassenger(Passenger traveler) {
        int index = findPassengerIndex(traveler.getPassengerID());
        if (index >= 0) {
            if (traveler.getTicketCode() != null) {
                traveler.setTicketCode(null);  // Сначала аннулируем билет
            }
            for (int j = index; j < passengerCount - 1; j++) {
                busPassengers[j] = busPassengers[j + 1];
            }
            busPassengers[passengerCount - 1] = null;
            passengerCount--;
            return true;
        }
        return false;
    }

    private int findPassengerIndex(int passID) {
        for (int i = 0; i < passengerCount; i++) {
            if (busPassengers[i].getPassengerID() == passID) {
                return i;
            }
        }
        return -1;
    }

    private String generateTicketCode(int passID) {
        return "Bus" + busID + "-" + passID + "-" + String.format("%05d", ++ticketIDGenerator);
    }

    @Override
    public String toString() {
        StringBuilder description = new StringBuilder();
        description.append("{Bus ID: ").append(busID).append(", Model: ").append(vehicleModel);
        description.append(", Capacity: ").append(maxPassengers);
        description.append(", Driver: ").append((assignedDriver == null ? "None" : assignedDriver.toString()));
        description.append(", Passengers: ").append(displayPassengers()).append(", AP: ").append(pilotSystem).append("}");
        return description.toString();
    }

    private String displayPassengers() {
        StringBuilder list = new StringBuilder("[");
        for (Passenger p : busPassengers) {
            if (p != null) {
                list.append(p.toString()).append(", ");
            }
        }
        if (list.length() > 1) {
            list.setLength(list.length() - 2);
        }
        list.append("]");
        return list.toString();
    }


    public int getId() {
        return busID;
    }

    public String getModel() {
        return vehicleModel;
    }


    public int getMileage() {
        return distanceCovered;
    }

    public void setMileage(int mileage) {
        this.distanceCovered = mileage;
    }

    public int getCapacity() {
        return maxPassengers;
    }

    public BusDriver getDriver() {
        return assignedDriver;
    }

    public void setDriver(BusDriver driver) {
        this.assignedDriver = driver;
    }

    public Passenger[] getPassengers() {
        return busPassengers;
    }
}

