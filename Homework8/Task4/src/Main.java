import java.util.*;

public class Main {

    static public class Graph {
        private Map<String, Node> nodes = new HashMap<String, Node>();

        public Graph() {
        }

        public void addEdge(String nodeName1, String nodeName2) {
            Node node1 = nodes.get(nodeName1);
            if (node1 == null) {
                node1 = new Node(nodeName1);
            }

            Node node2 = nodes.get(nodeName2);
            if (node2 == null) {
                node2 = new Node(nodeName2);
            }

            node1.addNeighbor(node2);

            nodes.put(nodeName1, node1);
            nodes.put(nodeName2, node2);
        }

        public List<String> shortestPath(String startNodeName, String endNodeName) {

            Map<String, String> parents = new HashMap<String, String>();
            List<Node> temp = new ArrayList<Node>();

            if (nodes.get(startNodeName) != null && nodes.get(startNodeName).neighbors.get(0) != null) {
                Node start = nodes.get(startNodeName).neighbors.get(0);
                temp.add(start);
                parents.put(nodes.get(startNodeName).neighbors.get(0).getName(), null);
            }

            while (temp.size() > 0) {
                Node currentNode = temp.get(0);
                List<Node> neighbors = currentNode.getNeighbors();

                for (int i = 0; i < neighbors.size(); i++) {
                    Node neighbor = neighbors.get(i);
                    String nodeName = neighbor.getName();


                    boolean visited = parents.containsKey(nodeName);
                    if (visited) {
                        continue;
                    } else {
                        temp.add(neighbor);

                        parents.put(nodeName, currentNode.getName());

                        if (nodeName.equals(endNodeName)) {

                            return getPath(parents, endNodeName);
                        }
                    }
                }

                temp.remove(0);
            }
            List<String> noPathList = new ArrayList<>();
            noPathList.add("-1");

            return noPathList;
        }

        private List<String> getPath(Map<String, String> parents, String endNodeName) {
            List<String> path = new ArrayList<String>();
            String node = endNodeName;
            while (node != null) {
                path.add(0, node);
                String parent = parents.get(node);
                node = parent;
            }
            return path;
        }
    }

    static class Node {
        String name;
        List<Node> neighbors = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public void addNeighbor(Node neighbor) {
            neighbors.add(neighbor);
        }

        public List<Node> getNeighbors() {
            return neighbors;
        }

        public String toString() {
            return this.name;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int M = input.nextInt();
        Graph graph = new Graph();

        for (int i = 0; i < M; i++) {
            String city = input.next();
            String secondCity = input.next();
            graph.addEdge(city, secondCity);
        }

        input.nextLine();
        String begin = input.nextLine();
        System.out.print(begin + " ");
        for (String name : graph.shortestPath(begin, begin))
            System.out.print(name + " ");

    }
}