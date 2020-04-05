import java.util.*;

import static java.util.Arrays.sort;

public class Main {

    static boolean checkIfPossible(Queue<Integer> queueOfTrucks) {

        Stack<Integer> stack = new Stack<>();
        int counter = 0;
        while (!queueOfTrucks.isEmpty()) {
            if (!stack.empty() && stack.peek() == counter + 1) {
                stack.pop();
                counter++;
            } else if (queueOfTrucks.peek() == counter + 1) {
                queueOfTrucks.poll();
                counter++;
            } else if (stack.empty()) {
                stack.push(queueOfTrucks.poll());
            } else if (queueOfTrucks.peek() < stack.peek()) {
                stack.push(queueOfTrucks.poll());
            } else
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();
        int T = input.nextInt();
        boolean[] answers = new boolean[T];
        for (int i = 0; i < T; i++) {
            int N = input.nextInt();
            for (int j = 0; j < N; j++) {
                queue.add(input.nextInt());
            }
            answers[i] = checkIfPossible(queue);
            queue.clear();
        }

        for (int i = 0; i < T; i++)
            if (answers[i])
                System.out.println("yes");
            else
                System.out.println("no");
    }
}
