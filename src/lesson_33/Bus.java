package lesson_33;

public class Bus {

    private final String number;

    private final Passenger[] passengers;
    private int count; // по умолчанию 0, boolean -> false, double - 0.0, String - null

    private boolean isGo;

    public Bus(String number) {
        this.number = number;
        this.passengers = new Passenger[5];
    }

    private Driver driver; // агрегирование, композиция, включение

    public void setDriver(Driver driver) {
        this.stop();
        if (driver == null) { // если мы пытаемся положить null-водителя
            System.err.println("Вы пытаетесь положить водителя null");
        } else if (this.driver == driver) {
            System.err.println("Вы пытаетесь положить того же самого водителя...");
        } else if (this.driver != null) { // если ссылка на водителя уже есть
            System.err.println("А водитель уже есть! Освободите сначала его!");
        } else {
            System.out.println("Водитель " + driver.getName() + " в автобусе " + number);
            this.driver = driver; // положили нового водителя
        }
    }

    public void freeDriver() { // метод для освобождения водителя
        this.stop();
        System.out.println("Водитель " + driver.getName() + " освобожден из автобуса " + number);
        this.driver = null;
    }

    public void addPassenger(Passenger passenger) {
        this.stop();
        if (count < passengers.length) {
            passengers[count] = passenger;
            count++;
        } else {
            System.err.println("Автобус заполнен");
        }
    }


    public String getNumber() {
        return number;
    }

    public void go() {
        if (driver != null) {
            this.isGo = true;
            System.out.println("Автобус " + number + " поехал под управлением " + driver.getName());

            System.out.println("Пассажиры автобуса");
            for (int i = 0; i < count; i++) { // пробегаемся по всем пассажирам
                System.out.println(passengers[i].getName()); // выводим имя каждого
            }

        } else System.err.println("У автобуса нет водителя :(");
    }

    public void stop() {
        System.out.println("Автобус " + number + " был остановлен/или уже стоит");
        this.isGo = false;
    }
}