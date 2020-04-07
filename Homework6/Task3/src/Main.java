import java.util.*;

import static java.lang.StrictMath.abs;
import static java.lang.StrictMath.pow;

public class Main {

    static class Dot {
        private int x;
        private int y;

        public Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void print() {
            System.out.println(this.x + " " + this.y);
        }

    }

    public static double calculateDistance(Dot first, Dot second) {
        return Math.sqrt(pow((first.x - second.x), 2) + pow((first.y - second.y), 2));
    }

    public static void sortByKey(Map<Double, Dot> map) {
        Map<Double, Dot> treeMap = new TreeMap<>();
        treeMap.putAll(map);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int K = input.nextInt();
        final Dot POINT_FMI = new Dot(0, 0);
        Map<Double, List<Dot>> map = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            List<Dot> listOfDots = new ArrayList<>();

            Dot tempPoint = new Dot(input.nextInt(), input.nextInt());
            if (map.containsKey(calculateDistance(POINT_FMI, tempPoint))) {
                listOfDots.add(tempPoint);
                for (Dot dot : map.get(calculateDistance(POINT_FMI, tempPoint)))
                    listOfDots.add(dot);

            } else
                listOfDots.add(tempPoint);

            map.put(calculateDistance(POINT_FMI, tempPoint), listOfDots);
        }

        int i = 0;
        for (Map.Entry<Double, List<Dot>> distance : map.entrySet()) {
            if (i == K)
                break;
            for (Dot dot : distance.getValue()) {
                dot.print();
                i++;
            }

        }
    }
}

