package lesson_27.task0;
/**
 * 12.10.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */
/**
 Создайте абстрактный класс Shape с абстрактными методами для вычисления площади и периметра. Реализуйте классы-наследники Circle, Rectangle, и Triangle. Убедитесь, что все классы правильно вычисляют площадь и периметр. Создайте массив объектов Shape и вычислите общую площадь и периметр всех фигур в массиве.
 */
public class Main {
    public static void main(String[] args) {
        Shape[] shapes = {
                new Circle(5),
                new Rectangle(10, 5),
                new Triangle(3, 4, 5)
        };

        double totalArea = 0;
        double totalPerimeter = 0;

        for (Shape shape : shapes) {
            System.out.println("Type: " + shape.getType());
            System.out.println("Area: " + shape.calculateArea());
            System.out.println("Perimeter: " + shape.calculatePerimeter());
            totalArea += shape.calculateArea();
            totalPerimeter += shape.calculatePerimeter();
        }

        System.out.println("Total Area: " + totalArea);
        System.out.println("Total Perimeter: " + totalPerimeter);
    }
}

