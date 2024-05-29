import java.util.*;
//BIPARTITE GRAPH PROGRAM
public class Problem5 {

    static boolean isBipartite(int[][] edges, int n) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int[] colors = new int[n];
        Arrays.fill(colors, -1);

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (colors[i] == -1) {
                colors[i] = 0;
                queue.add(i);

                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    for (int neighbor : graph.get(node)) {
                        if (colors[neighbor] == -1) {
                            colors[neighbor] = 1 - colors[node];
                            queue.add(neighbor);
                        } else if (colors[neighbor] == colors[node]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int n = scanner.nextInt();
        System.out.print("Enter the number of edges: ");
        int m = scanner.nextInt();

        int[][] edges = new int[m][2];
        System.out.println("Enter the edges (vertex1 vertex2): ");
        for (int i = 0; i < m; i++) {
            edges[i][0] = scanner.nextInt();
            edges[i][1] = scanner.nextInt();
        }

        if (isBipartite(edges, n)) {
            System.out.println("The graph is bipartite.");
        } else {
            System.out.println("The graph is not bipartite.");
        }
        scanner.close();
    }
}
