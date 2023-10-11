package lesson_26.homework26.task3;
/**
 * 11.10.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */
// Абстрактный класс Фигура
public abstract class Shape {
    private String shapeType;

    public Shape(String shapeType)
    {
        this.shapeType = shapeType;
    }
    public abstract double calculateArea();

    public String GetShapeType()
    {
        return this.shapeType;
    }

}

