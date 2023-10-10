package lesson_25;

public class MainBus {

    public static void main(String[] args) {

        Passenger p1 = new Passenger("B. Smith");
        BusDriver bDriver = new BusDriver("K.White", "AB-4343432");
        displayInfo(bDriver);

        Bus neoplanBus = new Bus("Neoplan", 44, bDriver);
        displayInfo(neoplanBus);

        Bus scaniaBus = new Bus("Scania", 40);
        displayInfo(scaniaBus);

        Passenger p2 = new Passenger("N. Paul");
        Passenger p3 = new Passenger("J. Black");

        scaniaBus.boardPassenger(p1);
        scaniaBus.boardPassenger(p3);
        scaniaBus.boardPassenger(p2);
        displayInfo(scaniaBus);

        scaniaBus.offboardPassenger(p3);
        neoplanBus.boardPassenger(p3);
        displayInfo("Bus: ", neoplanBus);
        displayInfo(scaniaBus);

        Passenger p4 = new Passenger("Fix ME");
        scaniaBus.boardPassenger(p4);
        displayInfo(scaniaBus);
    }

    private static void displayInfo(Object obj) {
        System.out.println(obj);
    }

    private static void displayInfo(String message, Object obj) {
        System.out.println(message + obj);
    }
}
