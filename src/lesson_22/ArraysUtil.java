package lesson_22;
/**
 * 05.10.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class ArraysUtil {

    public static int linearSearch(int[] arr, int val) {
        for (int idx = 0; idx < arr.length; idx++) {
            if (arr[idx] == val) return idx;
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int target) {
        int startIdx = 0;
        int endIdx = arr.length - 1;
        int ctr = 0;

        while (startIdx <= endIdx) {
            ctr++;
            int midIdx = startIdx + (endIdx - startIdx) / 2;
            if (arr[midIdx] == target) {
                System.out.println("Value found in " + ctr + " steps.");
                return midIdx;
            }
            if (arr[midIdx] > target) {
                endIdx = midIdx - 1;
            } else {
                startIdx = midIdx + 1;
            }
        }

        System.out.println("Element not found after " + ctr + " steps.");
        return -1;
    }

    public static void arraySort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIdx = getMinIndex(arr, i);
            int tmp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = tmp;
        }
    }

    private static int getMinIndex(int[] arr, int startFrom) {
        int smallest = arr[startFrom];
        int smallestIdx = startFrom;
        for (int i = startFrom; i < arr.length; i++) {
            if (arr[i] < smallest) {
                smallest = arr[i];
                smallestIdx = i;
            }
        }
        return smallestIdx;
    }

    public static int[] generateArray(int size) {
        Random rnd = new Random();
        int[] output = new int[size];
        for (int i = 0; i < output.length; i++) {
            output[i] = rnd.nextInt(2001) - 1000;
        }
        return output;
    }

    public static void displayArray(int[] arr) {
        String delimiter = " | ";
        int longestIdxLength = Integer.toString(arr.length - 1).length();
        int longestValueLength = Arrays.stream(arr).mapToObj(String::valueOf).max(Comparator.comparingInt(String::length)).orElse("0").length();

        for (int i = 0; i < arr.length; i++) {
            String formattedIndex = String.format("%" + longestIdxLength + "d", i);
            String formattedValue = String.format("%" + longestValueLength + "d", arr[i]);
            System.out.println(formattedIndex + delimiter + formattedValue);
        }
    }

}
