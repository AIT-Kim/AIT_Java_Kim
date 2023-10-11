package lesson_26.homework26.task3;
/**
 * 11.10.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */
// Класс Квадрат
public class Square extends Shape {
    private double sideLength;

    public Square(double sideLength) {
        super("Square");
        this.sideLength = sideLength;
    }

    @Override
    public double calculateArea() {
        return sideLength * sideLength;
    }
}
