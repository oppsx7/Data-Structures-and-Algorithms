import java.sql.SQLOutput;
import java.util.*;

public class Main {


    static class Student {
        private int position;
        private String name;

        public Student(String name, int position) {
            this.name = name;
            this.position = position;
        }

        public void printStudent() {
            System.out.printf(name + " " + position + " ");
        }

    }

    public static void checkIfCounterIsEven(int counter, List<Queue<Student>> list, Queue<Integer> integerQueue) {
        if (counter != 0 && counter % 2 == 0) {
            list.get(integerQueue.peek()).poll().printStudent();
            System.out.println(counter);
            if (list.get(integerQueue.peek()).size() == 0) {
                integerQueue.poll();
            }
        }
        counter++;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        int M = input.nextInt();
        List<Queue<Student>> list = new ArrayList<>(M + 1);
        for (int i = 0; i < M + 1; i++)
            list.add(new LinkedList<>());
        Queue<Integer> integerQueue = new LinkedList<>();
        Queue<Student> studentQueue = new LinkedList<>();
        int counter = 0;

        for (int i = 0; i < N; i++) {
            String name = input.next();
            int group = input.nextInt();
            Student student = new Student(name, i);
            Queue<Student> queue = new LinkedList<>();
            if (list.get(group).isEmpty()) {
                list.get(group).add(student);
                integerQueue.add(group);
            } else {
                list.get(group).add(student);

            }

            checkIfCounterIsEven(counter, list, integerQueue);

        }
        while (integerQueue.size() != 0) {
            checkIfCounterIsEven(counter, list, integerQueue);
        }


    }
}
