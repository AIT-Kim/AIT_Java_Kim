package lesson_29.triathlete;
/**
 * 15.10.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */
public class Triathlete implements Swimmer, Runner {

    @Override
    public void swim() {
        System.out.println("The triathlete is swimming.");
    }

    @Override
    public void run() {
        System.out.println("The triathlete is running.");
    }
}
