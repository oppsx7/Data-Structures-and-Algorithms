import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

   static int binarySearch(int arr[], int l, int r, int x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            if (mid == 0) {
                if (x <= arr[0])
                    return 1;
                else
                    mid++;
            }
            if (arr[mid] >= x && arr[mid - 1] < x) {
                return mid + 1;
            }

            if (arr[mid - 1] >= x)
                return binarySearch(arr, l, mid - 1, x);

            if (arr[mid] < x) {
                return binarySearch(arr, mid + 1, r, x);
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        if (N < 1 || N > 100000)
            return;
        int sum = 0;
        int[] array = new int[N];
        for (int i = 0; i < array.length; i++) {
            int current = input.nextInt();
            sum += current;
            array[i] = sum;
        }

        int sweetOnes = input.nextInt();
        if (sweetOnes < 0 || sweetOnes > 100000)
            return;
        int[] sweetOnesPositions = new int[sweetOnes];
        for (int i = 0; i < sweetOnes; i++) {
            sweetOnesPositions[i] = input.nextInt();
            if (sweetOnesPositions[i] < 1)
                return;
        }

        for (int i = 0; i < sweetOnesPositions.length; i++) {
            System.out.println(binarySearch(array, 0, N - 1, sweetOnesPositions[i]));

        }
    }

}





