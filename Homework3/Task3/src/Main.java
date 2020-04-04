import java.util.Scanner;

public class Main {
    static boolean areBalloonsEnough(int[] firstArray, int[] secondArray, long number, long M) {
        int counter = 0;
        for (int i = 0; i < firstArray.length; i++) {
            if (firstArray[i] - number / secondArray[i] <= 0)
                continue;
            else
                counter += firstArray[i] - number / secondArray[i];
        }
        if (counter <= M)
            return true;

        return false;
    }

    static long binarySearch(int[] array1, int[] array2, long l, long r, long balloons) {
        long mid = l + (r - l) / 2;
        if (r > l) {
            if (areBalloonsEnough(array1, array2, mid, balloons)) {
                return binarySearch(array1, array2, l, mid, balloons);
            } else
                return binarySearch(array1, array2, mid + 1, r, balloons);
        }
        return mid;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        long M = input.nextLong();
        int[] arrayOfDays = new int[N];
        int[] arrayOfCandies = new int[N];

        for (int i = 0; i < N; i++)
            arrayOfDays[i] = input.nextInt();

        for (int i = 0; i < N; i++)
            arrayOfCandies[i] = input.nextInt();

        System.out.println(binarySearch(arrayOfDays,arrayOfCandies,0,Long.MAX_VALUE,M));
    }
}
