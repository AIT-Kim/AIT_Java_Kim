package lesson_24.persons;
/**
 * 09.10.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */
public class Passenger extends Person {
    private int id;

    public Passenger(String name, int age, int id) {
        super(name, age);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void passengerInfo() {
        System.out.println("Пассажир: " + getName() + ", Возраст: " + getAge() + ", ID: " + id);
    }

    @Override
    public void info() {
        System.out.println("Информация о пассажире:");
        super.info();
    }
}
