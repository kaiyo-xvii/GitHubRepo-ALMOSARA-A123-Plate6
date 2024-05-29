import java.util.*;

public class Problem3 {

    private int V; // Number of vertices
    private LinkedList<Integer>[] adj; // Adjacency List

    public Problem3(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // A recursive function that uses DFS
    // traversal to detect cycle in subgraph reachable
    // from vertex v.
    Boolean isCyclicUtil(int v, Boolean[] visited,
                         Boolean[] recStack) {
        if (recStack[v])
            return true;

        if (visited[v])
            return false;

        visited[v] = true;
        recStack[v] = true;
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (isCyclicUtil(n, visited, recStack))
                return true;
        }
        recStack[v] = false;
        return false;
    }

    // Returns true if the graph contains a
    // cycle, else false.
    Boolean isCyclic() {
        // Mark all the vertices as not visited and not part of recursion stack
        Boolean[] visited = new Boolean[V];
        Boolean[] recStack = new Boolean[V];
        for (int i = 0; i < V; i++) {
            visited[i] = false;
            recStack[i] = false;
        }
        // Call the recursive helper function to detect cycle in different DFS trees
        for (int i = 0; i < V; i++)
            if (isCyclicUtil(i, visited, recStack))
                return true;

        return false;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int V = scanner.nextInt();
        Problem3 graph = new Problem3(V);
        System.out.println("Enter the edges (vertex pairs): ");
        System.out.println("(Press -1 to stop)");
        while (true) {
            int v1 = scanner.nextInt();
            if (v1 == -1) break;
            int v2 = scanner.nextInt();
            graph.addEdge(v1, v2);
        }
        if (graph.isCyclic())
            System.out.println("The graph contains cycle");
        else
            System.out.println("The graph does not contain cycle");
    }
}