import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static int counter = -1;

    static class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
            right = null;
            left = null;
        }
    }

    static class BinaryTree {
        private Node root;

        private Node insert(Node current, int value) {
            if (current == null)
                return new Node(value);
            if (value < current.value)
                current.left = insert(current.left, value);
            else if (value > current.value)
                current.right = insert(current.right, value);
            else
                return current;

            return current;
        }

        public void add(int value) {
            root = insert(root, value);
        }

        private boolean find(Node current, int value) {
            if (current == null)
                return false;
            if (value == current.value) {
                counter++;
                return true;
            }
            counter++;
            return value < current.value ?
                    find(current.left, value) :
                    find(current.right, value);
        }

        public boolean contains(int value) {
            return find(root, value);
        }
    }

    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int K = input.nextInt();
        int[] array = new int[K];
        BinaryTree bt = new BinaryTree();
        for (int i = 0; i < N; i++) {
            int number = input.nextInt();
            bt.add(number);
        }
        for (int i = 0; i < K; i++) {
            array[i] = input.nextInt();
        }

        for (int i = 0; i < K; i++) {
            if (bt.contains(array[i])) {
                System.out.println(counter);
                counter = -1;
            } else {
                System.out.println(-1);
                counter = -1;
            }
        }

    }
}
