package lesson_33;

public class Main {
    public static void main(String[] args) {
        Bus bus = new Bus("22A"); // создали автобус
        Bus bus2 = new Bus("1"); // создали автобус
        Driver driver = new Driver("Marsel"); // создали водителя

        driver.goToBus(bus);
        driver.goToBus(bus2);

        Passenger p1 = new Passenger("Aysel");
        Passenger p2 = new Passenger("Mykhailo");
        Passenger p3 = new Passenger("Maxim");
        Passenger p4 = new Passenger("Mihail");
        Passenger p5 = new Passenger("Delayed");
        Passenger p6 = new Passenger("Delayed 2");

        bus.addPassenger(p1);
        bus.addPassenger(p2);
        bus.addPassenger(p3);
        bus.addPassenger(p4);

        driver.goToBus(bus);

        bus.go();
        bus.addPassenger(p5);
        bus.addPassenger(p6);

    }
}