package lesson_27.task0;
/**
 * 12.10.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */
public abstract class Shape {
    public abstract double calculateArea();
    public abstract double calculatePerimeter();

    public String getType() {
        ShapeInfo annotation = this.getClass().getAnnotation(ShapeInfo.class);
        if (annotation != null) {
            return annotation.name();
        }
        return "Unknown Shape";
    }


}
