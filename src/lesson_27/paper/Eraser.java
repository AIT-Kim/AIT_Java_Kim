package lesson_27.paper;
/**
 * 12.10.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */
public class Eraser extends Pen{
    @Override
    public void draw(String figure) {
        System.out.println("Стираю фигуру " + figure);
    }
}