import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static int N;
    public static int M;
    public static int T;

    static class Apple {
        private int x = 0;
        private int y = 0;

        public Apple(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static boolean isWithinBorders(int i, int j) {
        return (i >= 0 && j >= 0 && i < N && j < M);
    }

    static int countRottenApples(int[][] array, int days, int rottenApples) {
        int counter = 0;
        Queue<Apple> queue = new LinkedList<>();
        Apple tempApple;
        int countRottenApples = rottenApples;

        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                if (array[i][j] == 1)
                    queue.add(new Apple(i, j));

        queue.add(new Apple(-1, -1));
        while (counter < days) {
            while (!isSeparator(queue.peek())) {
                tempApple = queue.peek();
                //top element check
                if (isWithinBorders(tempApple.x, tempApple.y + 1) &&
                        array[tempApple.x][tempApple.y + 1] == 0) {

                    array[tempApple.x][tempApple.y + 1] = 1;
                    queue.add(new Apple(tempApple.x, tempApple.y + 1));
                    countRottenApples++;
                }
                //bot element check
                if (isWithinBorders(tempApple.x, tempApple.y - 1) &&
                        array[tempApple.x][tempApple.y - 1] == 0) {

                    array[tempApple.x][tempApple.y - 1] = 1;
                    queue.add(new Apple(tempApple.x, tempApple.y - 1));
                    countRottenApples++;
                }
                //left element check
                if (isWithinBorders(tempApple.x - 1, tempApple.y) &&
                        array[tempApple.x - 1][tempApple.y] == 0) {

                    array[tempApple.x - 1][tempApple.y] = 1;
                    queue.add(new Apple(tempApple.x - 1, tempApple.y));
                    countRottenApples++;
                }
                //right element check
                if (isWithinBorders(tempApple.x + 1, tempApple.y) &&
                        array[tempApple.x + 1][tempApple.y] == 0) {

                    array[tempApple.x + 1][tempApple.y] = 1;
                    queue.add(new Apple(tempApple.x + 1, tempApple.y));
                    countRottenApples++;
                }
                queue.remove();
            }
            queue.remove();

            if (!queue.isEmpty())
                queue.add(new Apple(-1, -1));

            counter++;
        }

        return (N * M - countRottenApples);
    }

    static boolean isSeparator(Apple apple) {
        return (apple.x == -1 && apple.y == -1);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        N = input.nextInt();
        M = input.nextInt();
        T = input.nextInt();
        int[][] array = new int[N][M];
        int rottenApples = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                array[i][j] = 0;

        while (input.hasNextInt()) {
            int rottenAppleRow = input.nextInt();
            int rottenAppleColumn = input.nextInt();
            array[rottenAppleRow - 1][rottenAppleColumn - 1] = 1;
            rottenApples++;
        }
        System.out.println(countRottenApples(array, T, rottenApples));
    }
}
