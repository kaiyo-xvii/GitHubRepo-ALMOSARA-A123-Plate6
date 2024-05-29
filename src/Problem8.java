import java.util.*;
//GRAPH ISOMORPHISM PROGRAM
public class Problem8 {

    static class Graph {
        int V;
        LinkedList<Integer>[] adjList;

        Graph(int V) {
            this.V = V;
            adjList = new LinkedList[V];
            for (int i = 0; i < V; i++) {
                adjList[i] = new LinkedList<>();
            }
        }

        void addEdge(int src, int dest) {
            adjList[src].add(dest);
            adjList[dest].add(src); // Uncomment this line if the graph is undirected
        }

        boolean isIsomorphic(Graph g) {
            if (V != g.V) {
                return false;
            }
            return checkIsomorphism(g, new HashMap<>(), new boolean[V], 0);
        }

        boolean checkIsomorphism(Graph g, Map<Integer, Integer> map,
                                 boolean[] visited, int index) {
            if (index == V) {
                return true;
            }

            for (int i = 0; i < V; i++) {
                if (!visited[i]) {
                    map.put(index, i);
                    visited[i] = true;

                    if (isMappingValid(map, index, g)) {
                        if (checkIsomorphism(g, map, visited, index + 1)) {
                            return true;
                        }
                    }

                    visited[i] = false;
                    map.remove(index);
                }
            }
            return false;
        }

        boolean isMappingValid(Map<Integer, Integer> map, int index, Graph g) {
            for (int i = 0; i < index; i++) {
                for (int j : adjList[index]) {
                    int mappedNeighbor = map.get(i);
                    if (g.adjList[map.get(index)].contains(mappedNeighbor) != adjList[i].contains(j)) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input Graph 1
        System.out.println("Enter the number of vertices in Graph 1:");
        int V1 = scanner.nextInt();
        Graph graph1 = new Graph(V1);
        System.out.println("Enter the edges for Graph 1 (vertex indexing starts from 0):");
        System.out.println("Enter -1 -1 to stop.");
        while (true) {
            int src = scanner.nextInt();
            int dest = scanner.nextInt();
            if (src == -1 && dest == -1) break;
            graph1.addEdge(src, dest);
        }

        // Input Graph 2
        System.out.println("Enter the number of vertices in Graph 2:");
        int V2 = scanner.nextInt();
        Graph graph2 = new Graph(V2);
        System.out.println("Enter the edges for Graph 2 (vertex indexing starts from 0):");
        System.out.println("Enter -1 -1 to stop.");
        while (true) {
            int src = scanner.nextInt();
            int dest = scanner.nextInt();
            if (src == -1 && dest == -1)
                break;
            graph2.addEdge(src, dest);
        }

        // Check for isomorphism
        if (graph1.isIsomorphic(graph2)) {
            System.out.println("Graph 1 and Graph 2 are isomorphic.");
        } else {
            System.out.println("Graph 1 and Graph 2 are not isomorphic.");
        }
    }
}
