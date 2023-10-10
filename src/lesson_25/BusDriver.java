package lesson_25;

public class BusDriver {

    private final int driverID;
    private String driverName;
    private String licenceCode;

    private static int identifier = Passenger.getLastPassengerID(); // Assuming we have a public method in Passenger to get the latest ID

    public BusDriver(String driverName, String licenceCode) {
        this.driverName = driverName;
        this.licenceCode = licenceCode;
        this.driverID = identifier++;
    }

    @Override
    public String toString() {
        return "{Driver ID:" + driverID + "; Name: " + driverName + "; Licence Code: " + licenceCode + "}";
    }

    public int getDriverID() {
        return driverID;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String newName) {
        this.driverName = newName;
    }

    public String getLicenceCode() {
        return licenceCode;
    }

    public void setLicenceCode(String newLicence) {
        this.licenceCode = newLicence;
    }
}

