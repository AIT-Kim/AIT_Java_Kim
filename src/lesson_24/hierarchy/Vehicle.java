package lesson_24.hierarchy;
/**
 * 09.10.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */
// иерархия: Транспорт

public class Vehicle {
    String type;

    public Vehicle(String type) {
        this.type = type;
    }

    public String info() {
        return "Это транспорт: " + type;
    }
}





