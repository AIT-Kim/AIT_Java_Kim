package lesson_26.homework26.task3;
/**
 * 11.10.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */
/**
 Фигуры и их площади
 Создайте класс Фигура с методом рассчитатьПлощадь(). Реализуйте классы различных геометрических фигур (например, Круг, Квадрат, Треугольник). В главном классе создайте список фигур и вычислите площадь каждой из них.
 */
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создаем список фигур
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle(5));
        shapes.add(new Square(4));
        shapes.add(new Triangle(4, 7));

        // Вычисляем площадь каждой фигуры
        for (Shape shape : shapes) {
            System.out.println("Площадь фигуры " + shape.GetShapeType() + ": " + shape.calculateArea());
        }
    }
}