import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static long counter;

    private static void merge(int[] originalArray, int[] mergeArray, int start, int middle, int end) {
        int left = start;
        int right = middle + 1;
        for (int i = start; i <= end; i++) {
            if (left <= middle && (right > end || originalArray[left] <= originalArray[right])) {
                mergeArray[i] = originalArray[left];
                left++;
            } else {
                counter += (middle - left + 1);
                mergeArray[i] = originalArray[right];
                right++;
            }
        }
        for (int i = 0; i <= end; i++) {
            originalArray[i] = mergeArray[i];
        }
    }

    private static void _mergeSort(int[] originalArray, int[] mergeArray, int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;
            _mergeSort(originalArray, mergeArray, start, middle);
            _mergeSort(originalArray, mergeArray, middle + 1, end);
            merge(originalArray, mergeArray, start, middle, end);
        }
    }

    public static void mergeSort(int[] arr, int length) {
        int[] mergeSort = new int[length];
        _mergeSort(arr, mergeSort, 0, length - 1);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        if (N < 0 || N > 100000)
            return;

        int[] array = new int[N];
        for (int i = 0; i < N; i++)
            array[i] = input.nextInt();
        mergeSort(array, array.length);
        System.out.println(counter);
    }
}
