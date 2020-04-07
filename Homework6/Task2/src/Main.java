import java.util.*;

public class Main {

    public static double[] medians(double[] arr) {
        //with smaller elements
        PriorityQueue<Double> maxHeap = new PriorityQueue<>(new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return -1 * o1.compareTo(o2);
            }
        });
        //with bigger elements
        PriorityQueue<Double> minHeap = new PriorityQueue<>();

        double[] result = new double[arr.length];

        for (int i = 0; i < arr.length; i++) {
            insertElement(arr[i], maxHeap, minHeap);
            balance(maxHeap, minHeap);
            result[i] = calculateMedian(maxHeap, minHeap);
        }

        return result;
    }

    private static double calculateMedian(PriorityQueue<Double> maxHeap, PriorityQueue<Double> minHeap) {
        PriorityQueue<Double> biggerHeap = maxHeap.size() > minHeap.size() ? maxHeap : minHeap;
        PriorityQueue<Double> smallerHeap = maxHeap.size() > minHeap.size() ? minHeap : maxHeap;

        if (biggerHeap.size() == smallerHeap.size())
            return (smallerHeap.peek() + biggerHeap.peek()) / 2;
        else
            return biggerHeap.peek();
    }

    private static void balance(PriorityQueue<Double> maxHeap, PriorityQueue<Double> minHeap) {
        PriorityQueue<Double> biggerHeap = maxHeap.size() > minHeap.size() ? maxHeap : minHeap;
        PriorityQueue<Double> smallerHeap = maxHeap.size() > minHeap.size() ? minHeap : maxHeap;

        if (biggerHeap.size() - smallerHeap.size() >= 2)
            smallerHeap.add(biggerHeap.poll());


    }

    private static void insertElement(double number, PriorityQueue<Double> maxHeap, PriorityQueue<Double> minHeap) {
        if (maxHeap.size() == 0 || number < maxHeap.peek())
            maxHeap.add(number);
        else
            minHeap.add(number);
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        double[] array = new double[N];
        for (int i = 0; i < N; i++) {
            array[i] = input.nextDouble();
        }
        double[] result = medians(array);
        for (int i = 0; i < result.length; i++)
            System.out.println(result[i]);
    }
}
