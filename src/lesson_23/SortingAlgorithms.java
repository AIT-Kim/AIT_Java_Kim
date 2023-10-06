package lesson_23;
/**
 * 06.10.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */

public class SortingAlgorithms {

    // Сортировка пузырьком
    public static void byBubbleSort(int[] elements) {
        int n = elements.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (elements[j] > elements[j + 1]) {
                    int temp = elements[j];
                    elements[j] = elements[j + 1];
                    elements[j + 1] = temp;
                }
            }
        }
    }

    // Сортировка слиянием
    public static void byMergeSort(int[] elements) {
        if (elements.length <= 1) return;

        int mid = elements.length / 2;

        int[] left = new int[mid];
        int[] right = new int[elements.length - mid];

        System.arraycopy(elements, 0, left, 0, mid);
        System.arraycopy(elements, mid, right, 0, elements.length - mid);

        byMergeSort(left);
        byMergeSort(right);

        merge(elements, left, right);
    }

    private static void merge(int[] elements, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                elements[k++] = left[i++];
            } else {
                elements[k++] = right[j++];
            }
        }

        while (i < left.length) {
            elements[k++] = left[i++];
        }

        while (j < right.length) {
            elements[k++] = right[j++];
        }
    }
}
