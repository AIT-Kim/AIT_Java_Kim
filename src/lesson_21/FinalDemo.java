package lesson_21;
/**
 * 04.10.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */
public class FinalDemo {

    private final int value = 10; // final field is initialized

    private final int[] numbers = new int[10];

    private final String personName = "Max";

    private int z;
    private double[] decimalValues;

    public FinalDemo() {
        // value = 15; impossible to reassign a new value
        // numbers = new int[3]; can't change the reference.
        // But we can modify the object's state (values in the array cells)
        numbers[0] = 10;
        numbers[0] = 100;
        numbers[1] = -15;
    }

    public static void main(String[] args) {}

    public int getValue() {
        return value;
    }

    public int[] getNumbers() {
        return numbers;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public double[] getDecimalValues() {
        return decimalValues;
    }

    public void setDecimalValues(double[] decimalValues) {
        this.decimalValues = decimalValues;
    }
}
