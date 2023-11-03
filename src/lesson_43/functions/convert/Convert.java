package lesson_43.functions.convert;

public interface Convert {
    // 4, 5, 8 -> "Ваша точка имеет координаты (4, 5, 8)"
    // 1, 2, 3 -> "Point at (4, 5, 8)
    // 3, 1, 5 -> "X = 3, Y = 1, Z = 5"
    String from(int a, int b, int c);
}