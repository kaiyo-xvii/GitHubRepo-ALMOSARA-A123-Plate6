import java.util.*;
//GRAPH CONNECTIVITY CHECKER PROGRAM
public class Problem1 {
    private int V;
    private LinkedList<Integer> adj[];

    Problem1(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adj[v - 1].add(w - 1); // Subtract 1 to adjust for 0-based indexing
        adj[w - 1].add(v - 1); // For undirected graph
    }

    void DFSUtil(int v, boolean visited[]) {
        visited[v] = true;
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    boolean isConnected() {
        boolean visited[] = new boolean[V];
        int componentCount = 0;
        for (int v = 0; v < V; ++v) {
            if (!visited[v]) {
                DFSUtil(v, visited);
                componentCount++;
            }
        }
        return componentCount == 1;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of vertices: ");
        int V = scanner.nextInt();
        System.out.println("Enter the number of edges: ");
        int E = scanner.nextInt();
        Problem1 graph = new Problem1(V);
        System.out.println("Enter the edges (format: v1 v2): ");
        for (int i = 0; i < E; i++) {
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            graph.addEdge(v, w);
        }

        if (graph.isConnected()) {
            System.out.println("The graph is connected.");
        } else {
            System.out.println("The graph is not connected.");
            // Find number of connected components
            boolean visited[] = new boolean[V];
            int componentCount = 0;
            for (int v = 0; v < V; ++v) {
                if (!visited[v]) {
                    graph.DFSUtil(v, visited);
                    componentCount++;
                }
            }
            System.out.println("Number of connected components: " + componentCount);
        }
    }
}
