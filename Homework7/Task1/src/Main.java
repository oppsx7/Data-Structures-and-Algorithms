
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static final int CAPACITY = 26;
    static int counter = 0;

    static class Node {
        private Boolean isEndOfWord = false;
        private Node[] children = new Node[CAPACITY];

        public Node() {
            isEndOfWord = false;
            for (int i = 0; i < CAPACITY; i++)
                children[i] = null;
        }
    }


    static boolean isLastNode(Node node) {
        for (int i = 0; i < CAPACITY; i++) {
            if (node.children[i] != null) {
                return false;
            }
        }
        return true;
    }

    static void insert(String key, Node node) {
        Node nextNode = node;
        for (int i = 0; i < key.length(); i++) {

            int index = key.charAt(i) - 'a';
            if (nextNode.children[index] == null)
                nextNode.children[index] = new Node();

            nextNode = nextNode.children[index];
        }

        nextNode.isEndOfWord = true;
    }

    static void checkIfWordIsPrefix(Node node) {
        if (node.isEndOfWord) {
            counter++;
        }

        if (isLastNode(node)) {
            return;
        }

        for (int i = 0; i < CAPACITY; i++) {
            if (node.children[i] != null) {
                checkIfWordIsPrefix(node.children[i]);
            }
        }

    }


    public static void main(String[] args) {
        FastReader input = new FastReader();
        int N = input.nextInt();
        int Q = input.nextInt();
        String[] array = new String[N];
        Node root = new Node();
        Node tempRoot = root;
        boolean indexFlag = false;

        for (int i = 0; i < N; i++) {

            array[i] = input.next();

            insert(array[i], root);
        }

        for (int i = 0; i < Q; i++) {
            String tempString = input.nextLine();
            char[] stringToCharArray = tempString.toCharArray();
            for (Character character : stringToCharArray) {
                int index = character - 'a';
                if (tempRoot.children[index] != null) {
                    tempRoot = tempRoot.children[index];
                }
                else {
                    indexFlag = true;
                    break;
                }
            }

            if (!indexFlag) {
                checkIfWordIsPrefix(tempRoot);
            }

            System.out.println(counter);
            counter = 0;
            indexFlag = false;
            tempRoot = root;
        }


    }

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
}

