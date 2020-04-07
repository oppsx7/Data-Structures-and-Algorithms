import java.io.*;
import java.util.*;

import static java.lang.Math.pow;

public class SecondImplementation {

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }


    static class Dot {
        private int x;
        private int y;
        private double distance;

        public Dot(int x, int y) {
            this.x = x;
            this.y = y;

        }

        public double getDistance() {
            return distance;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void setDistance(double distance) {
            this.distance = distance;
        }

        public void print() {
            System.out.println(this.x + " " + this.y);
        }

    }

    public static double calculateDistance(Dot dot) {
        return Math.sqrt(pow((0 - dot.x), 2) + pow((0 - dot.y), 2));
    }


    public static void main(String[] args) throws IOException {

        FastReader fr = new FastReader();
        int N = fr.nextInt();
        int K = fr.nextInt();
        final Dot POINT_FMI = new Dot(0, 0);
        List<Dot> listOfDots = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int x = fr.nextInt();
            int y = fr.nextInt();
            Dot tempDot = new Dot(x, y);
            listOfDots.add(tempDot);
            tempDot.setDistance(calculateDistance(tempDot));
        }

        Collections.sort(listOfDots, new Comparator<Dot>() {
            @Override
            public int compare(Dot o1, Dot o2) {
                int value = 0;
                if (o1.getDistance() < o2.getDistance()) value = -1;
                else if (o1.getDistance() > o2.getDistance()) value = 1;
                else
                    value = 0;

                if (value == 0) {
                    if (o1.getX() < o2.getX()) return -1;
                    if (o1.getX() > o2.getX()) return 1;
                    return 0;
                } else
                    return value;

            }
        });

        for (int i = 0; i < K; i++)
            listOfDots.get(i).print();
    }
}
