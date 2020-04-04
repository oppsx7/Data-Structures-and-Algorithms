import java.util.Scanner;

import static java.lang.Math.abs;

public class Main {
    static long countMonsters(long[][] array, long mid) {
        long counter = 0;
        for (int i = 0; i < array.length; i++)
            counter += abs(array[i][0] - mid) * array[i][1];


        return counter;
    }

    static long ternarySearch(long[][] array, long l, long r) {
        long key = Long.MAX_VALUE;
        while (r >= l) {
            long mid1 = l + (r - l) / 3;
            long mid2 = r - (r - l) / 3;

            long monstersForFirstMid = countMonsters(array, mid1);
            long monstersForSecondMid = countMonsters(array, mid2);
            if (monstersForFirstMid < monstersForSecondMid) {
                if (key > monstersForFirstMid)
                    key = monstersForFirstMid;
                r = mid2 - 1;
            }
            if (monstersForFirstMid > monstersForSecondMid) {
                if (key > monstersForSecondMid)
                    key = monstersForSecondMid;
                l = mid1 + 1;
            }

            if (monstersForFirstMid == monstersForSecondMid) {
                if (key > monstersForFirstMid)
                    key = monstersForFirstMid;
                l = mid1 + 1;
                r = mid2 - 1;

            }
        }
        return key;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        long[][] array = new long[N][2];
        int counter = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < 2; j++)
                array[i][j] = input.nextInt();

        long max = array[0][0];
        long min = array[0][0];
        for (int i = 1; i < N; i++) {
            if (array[i][0] > max)
                max = array[i][0];
            else if (array[i][0] < min)
                min = array[i][0];
        }


        System.out.println(ternarySearch(array,min,max));
    }
}
