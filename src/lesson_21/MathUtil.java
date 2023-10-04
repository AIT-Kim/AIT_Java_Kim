package lesson_21;
/**
 * 04.10.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */
public class MathUtil {

    public static int total(int baseValue, int... numbers) {
        int result = baseValue;
        for (int num: numbers) {
            result += num;
        }

        return result;
    }
}
