package homework_14;
/**
 * 23.09.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */
public class Coordinates {
    private final int x;  // x координата
    private final int y;  // y координата

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Coordinates(String input) {
        if (input == null || input.length() < 2) {
            throw new IllegalArgumentException("Неверные координаты");
        }

        // Первый символ в строке - это буква от A до J
        char letter = input.charAt(0);

        // Проверяем корректность буквы
        if (letter < 'A' || letter > 'J') { // заменить на нужную букву
            throw new IllegalArgumentException("Неверная буква в координатах");
        }

        this.y = letter - 'A';  // преобразовываем букву в соответствующее числовое значение

        // Оставшаяся часть строки - это число
        int number;
        try {
            number = Integer.parseInt(input.substring(1)) - 1; // Учитываем, что индексация начинается с 0
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Неверное число в координатах");
        }

        if (number < 0 || number > 9) {
            throw new IllegalArgumentException("Неверное число в координатах");
        }

        this.x = number;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Coordinates that = (Coordinates) obj;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        int result = y;
        result = 31 * result + x;
        return result;
    }

    @Override
    public String toString() {
        return "(" + y + ", " + x + ")";
    }
}

