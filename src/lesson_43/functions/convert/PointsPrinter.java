package lesson_43.functions.convert;

public class PointsPrinter {

    // метод печатает массив точек
    // при этом мы передаем объект, который содержит метод from, принимающий на вход три числа и возвращающий строку
    // таким образом, наш метод printAll не знает о том, как именно следует печатать набор точек
    // это знает конкретная реализация Convert
    public void printAll(Point[] points, Convert convert) {
        for (int i = 0; i < points.length; i++) {// пробегаем по всему массиву точек

            Point current = points[i]; // в текущий момент берем текущую точку

            String pointToPrint = convert.from(current.getX(), current.getY(), current.getZ()); // получаем из этой точки строку
            // с помощью метода from, который есть в convert

            System.out.println(pointToPrint);
        }
    }
}