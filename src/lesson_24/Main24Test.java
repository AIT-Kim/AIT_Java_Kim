package lesson_24;
/**
 * 09.10.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */
public class Main24Test {

    public static void main(String[] mainArgs) {
        Vehicle primaryVehicle = new Vehicle("Vehicle1", 2023);
        Vehicle secondaryVehicle = new Vehicle();
        System.out.println("Модель: " + secondaryVehicle.getVehicleModel());

        System.out.println("\n---Начало теста Bus---");

        Bus testBus = new Bus("Bus-xModel", 2000, 3, 0);  // Добавлен параметр пробег
        System.out.println(testBus);
        testBus.ignite();
        testBus.halt();
        testBus.deboardPassenger();

        testBus.admitPassenger();
        testBus.admitPassenger();
        System.out.println("Пассажиров в автобусе: " + testBus.getCurrentPassengers());
        testBus.admitPassenger();
        testBus.deboardPassenger();

        testBus.admitPassenger();
        System.out.println("Пассажиров в автобусе после: " + testBus.getCurrentPassengers());

        System.out.println("\n---Тестирование Bus без параметров---");

        Bus defaultBus = new Bus();
        defaultBus.ignite();
        defaultBus.halt();

        System.out.println("\n---Начало теста InternationalBus---");

        InternationalBus interBusTest =
                new InternationalBus("Ikarus", 1999, 32, 0, new String[]{"Spain", "Italy", "Germany"});  // Добавлен параметр пробег

        System.out.println(interBusTest);
        interBusTest.ignite();
        interBusTest.admitPassenger();
        interBusTest.admitPassenger();
        interBusTest.deboardPassenger();

        interBusTest.startJourney();
    }
}
