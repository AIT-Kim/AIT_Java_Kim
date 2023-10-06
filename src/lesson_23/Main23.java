package lesson_23;

/**
 * 06.10.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */
import java.util.Arrays;

public class Main23 {

    public static void main(String[] args) {
        int[] array1 = {64, 34, 25, 12, 22, 11, 90};
        int[] array2 = {38, 27, 43, 3, 9, 82, 10};

        System.out.println("Original array1: " + Arrays.toString(array1));
        SortingAlgorithms.byBubbleSort(array1);
        System.out.println("Sorted by Bubble Sort: " + Arrays.toString(array1));

        System.out.println("\nOriginal array2: " + Arrays.toString(array2));
        SortingAlgorithms.byMergeSort(array2);
        System.out.println("Sorted by Merge Sort: " + Arrays.toString(array2));
    }
}
