package lesson_24.hierarchy;
/**
 * 09.10.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */
public class Dog extends Animal {
    String breed;

    public Dog(String breed) {
        super("Собака");
        this.breed = breed;
    }

    @Override
    public String info() {
        return super.info() + ", порода: " + breed;
    }
}