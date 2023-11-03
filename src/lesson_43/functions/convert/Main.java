package lesson_43.functions.convert;

public class Main {
    public static void main(String[] args) {
        Point a = new Point(4, 1, 5);
        Point b = new Point(6, 2, 8);
        Point c = new Point(10, 11, 15);
        Point d = new Point(15, 2, 5);

        PointsPrinter printer = new PointsPrinter();

        EnglishConvertImpl english = new EnglishConvertImpl();
        RussianConverterImpl russian = new RussianConverterImpl();


        Point[] points = {a, b, c, d};

        printer.printAll(points, (x, y, z) ->  "Point in (" + x + ", " + y + ", " + z + ")");
    }

}