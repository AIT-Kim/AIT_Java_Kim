package lesson_25;

public class Passenger {

    private final int passengerID;
    private String passengerName;
    private String ticketCode;

    private static int identifier = 1;

    public Passenger(String passengerName) {
        this.passengerName = passengerName;
        this.passengerID = identifier++;
    }

    @Override
    public String toString() {
        return "{Passenger ID:" + passengerID + "; Name: " + passengerName
                + "; " + (ticketCode != null ? "Ticket Code: " + ticketCode : "") + "}";
    }

    public int getPassengerID() {
        return passengerID;
    }

    public static int getLastPassengerID() {
        return identifier;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String name) {
        this.passengerName = name;
    }

    public String getTicketCode() {
        return ticketCode;
    }

    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode;
    }
}

