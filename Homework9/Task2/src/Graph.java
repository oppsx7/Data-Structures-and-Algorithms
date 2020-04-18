// Java program to check if there is exist a path between two vertices
// of a graph.

import java.io.*;
import java.util.*;
import java.util.LinkedList;

class Graph {
    private int V;
    private LinkedList<Integer> adj[];

    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    Boolean isReachable(int s, int d) {
        LinkedList<Integer> temp;

        boolean visited[] = new boolean[V];

        LinkedList<Integer> queue = new LinkedList<Integer>();

        visited[s] = true;
        queue.add(s);

        Iterator<Integer> i;
        while (queue.size() != 0) {
            s = queue.poll();

            int n;
            i = adj[s].listIterator();

            while (i.hasNext()) {
                n = i.next();

                if (n == d)
                    return true;

                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }

        return false;
    }

    public static void main(String args[]) {

        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int M = input.nextInt();
        Graph g = new Graph(N);
        for (int i = 0; i < M; i++) {
            g.addEdge(input.nextInt()-1, input.nextInt()-1);
        }

        int Q = input.nextInt();
        for (int i = 0; i < Q; i++) {
            int number = input.nextInt();
            if (number == 1) {
                if (g.isReachable(input.nextInt()-1, input.nextInt()-1))
                    System.out.print(1);
                else
                    System.out.print(0);
            } else if (number == 2) {
                g.addEdge(input.nextInt()-1, input.nextInt()-1);
            }
        }

    }
}

