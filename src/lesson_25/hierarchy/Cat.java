package lesson_25.hierarchy;
/**
 * 09.10.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */
public class Cat extends Animal {
    boolean isWild;

    public Cat(boolean isWild) {
        super("Кот");
        this.isWild = isWild;
    }

    @Override
    public String info() {
        return super.info() + (isWild ? ", дикий." : ", домашний.");
    }
}