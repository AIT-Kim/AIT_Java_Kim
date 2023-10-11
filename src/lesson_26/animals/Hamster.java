package lesson_26.animals;
/**
 * 11.10.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */
public class Hamster extends Animal{

    @Override
    public void sound() {
        System.out.println("Hamster say hrum-hrum");
    }

    @Override
    public String toString() {
        return "Хомяк";
    }
}