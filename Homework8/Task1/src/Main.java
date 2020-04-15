import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {

    static Set<String> set = new LinkedHashSet<>();
    static List<String> arrayList = new ArrayList<>(set);

    static class Graph {
        int V;
        List<String> adjListArray[];

        Graph(int V) {
            this.V = V;

            adjListArray = new ArrayList[V];

            for (int i = 0; i < V; i++) {
                adjListArray[i] = new ArrayList<>();
            }
        }
    }

    static void addEdge(Graph graph, String src, String dest) {

        graph.adjListArray[arrayList.indexOf(src)].add(dest);
    }



    static int value = 0;

    public static boolean isConnected(Graph graph, String src, String dest,
                                      boolean[] discovered, Stack<String> path) {

        discovered[arrayList.indexOf(src)] = true;
        discovered[arrayList.indexOf(dest)] = false;
        path.add(src);

        if (src.equals(dest) && value != 0) {
            return true;
        }

        value = 1;

        for (String i : graph.adjListArray[arrayList.indexOf(src)]) {
            if (!discovered[arrayList.indexOf(i)]) {
                if (isConnected(graph, i, dest, discovered, path)) {
                    return true;
                }
            }
        }

        path.pop();

        return false;
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

    public static void main(String[] args) {
        FastReader input = new FastReader();
        int N = input.nextInt();
        int M = input.nextInt();
        Graph graph = new Graph(7);

        for (int i = 0; i < M; i++) {
            String city = input.next();
            String secondCity = input.next();
            set.add(city);
            set.add(secondCity);
            arrayList.clear();
            arrayList.addAll(set);
            addEdge(graph, city, secondCity);
        }


        String begin = input.nextLine();
        Stack<String> path = new Stack<>();
        boolean[] discovered = new boolean[N];
        if (isConnected(graph, begin, begin, discovered, path)) {
            List<String> resultList = new ArrayList<>(path);
            for(String token : resultList)
                System.out.print(token + " ");
        }
        else
            System.out.println(-1);
    }


}