import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static class Graph {
        static class Edge implements Comparable<Edge> {
            private int source;
            private int destination;
            private int weight;


            @Override
            public int compareTo(Edge o) {
                return this.weight - o.weight;
            }
        }

        static class Subset {
            private int parent;
            private int rank;
        }

        private int V;
        private int E;
        private Edge[] edges;

        public Graph(int V, int E) {
            this.V = V;
            this.E = E;
            edges = new Edge[E];
            for (int i = 0; i < E; i++) {
                edges[i] = new Edge();
            }
        }

        public int find(Subset[] subsets, int i) {
            if (subsets[i].parent != i) {
                subsets[i].parent = find(subsets, subsets[i].parent);
            }
            return subsets[i].parent;
        }

        public void union(Subset[] subsets, int x, int y) {
            int xRoot = find(subsets, x);
            int yRoot = find(subsets, y);
            if (subsets[xRoot].rank < subsets[yRoot].rank) {
                subsets[xRoot].parent = yRoot;
            } else if (subsets[yRoot].rank < subsets[xRoot].rank) {
                subsets[yRoot].parent = xRoot;
            } else {
                subsets[yRoot].parent = xRoot;
                subsets[xRoot].rank++;
            }
        }

        public void KruskalAlgorithm() {
            Edge[] result = new Edge[V];
            int e = 0;
            int i = 0;
            for (i = 0; i < V; i++) {
                result[i] = new Edge();
            }
            Arrays.sort(edges);
            Subset subsets[] = new Subset[V];
            for (i = 0; i < V; ++i)
                subsets[i] = new Subset();

            for (int v = 0; v < V; ++v) {
                subsets[v].parent = v;
                subsets[v].rank = 0;
            }

            i = 0;

            while (e < V - 1) {
                if (edges.length == i) {
                    e = V - 1;
                    continue;
                }
                Edge nextEdge = edges[i++];

                int x = find(subsets, nextEdge.source);
                int y = find(subsets, nextEdge.destination);

                if (x != y) {
                    result[e++] = nextEdge;
                    union(subsets, x, y);
                }
            }

            int sum = 0;
            for (i = 0; i < e; i++) {
                sum += result[i].weight;
            }

            System.out.println(sum);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int M = input.nextInt();
        Graph graph = new Graph(N, M);
        if (N <= 0 || M <= 0) {
            System.out.println(0);
            return;
        }
        for (int i = 0; i < M; i++) {
            graph.edges[i].source = input.nextInt();
            graph.edges[i].destination = input.nextInt();
            graph.edges[i].weight = input.nextInt();
        }

        graph.KruskalAlgorithm();
    }
}

