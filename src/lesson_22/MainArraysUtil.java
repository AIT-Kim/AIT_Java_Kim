package lesson_22;
/**
 * 05.10.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */
import java.util.Arrays;

public class MainArraysUtil {

    public static void main(String[] args) {
        int[] values = {25, 13, -56, 44, 57, 78, 34, 8, 10, 77, -25, 34};
        int searchValue = 150;

        ArraysUtil.arraySort(values);
        System.out.println(Arrays.toString(values));
        System.out.println("Binary search result: " + ArraysUtil.binarySearch(values, searchValue));

        ArraysUtil.displayArray(values);

        int[] testData = ArraysUtil.generateArray(1_000_000);
        long start = System.currentTimeMillis();
        int[] linearResults = new int[100];

        for (int i = 0; i < linearResults.length; i++) {
            linearResults[i] = ArraysUtil.linearSearch(testData, 1001);
        }

        long end = System.currentTimeMillis();
        System.out.println("Linear search time: " + (end - start));

        start = System.currentTimeMillis();

        for (int i = 0; i < linearResults.length; i++) {
            linearResults[i] = ArraysUtil.binarySearch(testData, 1001);
        }

        end = System.currentTimeMillis();
        System.out.println("Binary search time: " + (end - start));
    }
}