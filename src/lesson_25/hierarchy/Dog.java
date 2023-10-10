package lesson_25.hierarchy;
/**
 * 10.10.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */
public class Dog extends Animal {
    String breed;
    Vehicle collar;  // HAS-A отношение

    public Dog(String breed, Vehicle collar) {
        super("Собака");
        this.breed = breed;
        this.collar = collar;
    }

    @Override
    public String info() {
        return super.info() + ", порода: " + breed + ", ошейник: " + collar.type;
    }
}