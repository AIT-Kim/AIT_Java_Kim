package lesson_24.hierarchy;
/**
 * 09.10.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */
public class Bicycle extends Vehicle {
    boolean isRacing;

    public Bicycle(boolean isRacing) {
        super("Велосипед");
        this.isRacing = isRacing;
    }

    @Override
    public String info() {
        return super.info() + (isRacing ? ", гоночный." : ", не гоночный.");
    }
}
