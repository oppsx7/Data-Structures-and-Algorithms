import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static class Graph {
        static int counter = 0;
        int V;
        List<Integer>[] adjListArray;

        Graph(int V) {
            this.V = V;
            adjListArray = new LinkedList[V];

            for (int i = 0; i < V; i++) {
                adjListArray[i] = new LinkedList<>();
            }
        }

        void addEdge(int src, int dest) {
            adjListArray[src].add(dest);
            adjListArray[dest].add(src);
        }

        void DFSUtil(int v, boolean[] visited) {
            visited[v] = true;
            for (int x : adjListArray[v]) {
                if (!visited[x]) DFSUtil(x, visited);
            }

        }

        void countNumberOfColors() {
            boolean[] visited = new boolean[V];
            for (int v = 0; v < V; ++v) {
                if (!visited[v]) {
                    DFSUtil(v, visited);
                    counter++;
                }
            }
            System.out.println(counter);
        }


    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int M = input.nextInt();
        Graph graph = new Graph(N);
        for (int i = 0; i < M; i++) {
            graph.addEdge(input.nextInt(), input.nextInt());
        }

        graph.countNumberOfColors();
    }
}