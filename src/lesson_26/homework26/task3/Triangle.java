package lesson_26.homework26.task3;
/**
 * 11.10.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */
// Класс Треугольник
public class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        super("Triangle");
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
}
