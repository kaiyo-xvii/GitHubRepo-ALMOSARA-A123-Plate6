import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
//GRAPH EDGES COUNTER PROGRAM
public class Problem2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();
        int[][] adjacencyMatrix = new int[vertices][vertices];

        System.out.println("Enter the adjacency matrix:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                adjacencyMatrix[i][j] = scanner.nextInt();
            }
        }

        Map<String, Integer> edgeCountMap = new HashMap<>();

        for (int i = 0; i < vertices; i++) {
            for (int j = i; j < vertices; j++) {
                // Ensure i <= j to avoid duplicate edges in undirected graph
                if (adjacencyMatrix[i][j] != 0) {
                    String edge = i + " - " + j;
                    edgeCountMap.put(edge, edgeCountMap.getOrDefault(edge, 0) +
                            adjacencyMatrix[i][j]);
                }
            }
        }

        System.out.println("Edges and their counts:");
        for (Map.Entry<String, Integer> entry : edgeCountMap.entrySet()) {
            System.out.println("Edge " + entry.getKey() + " appears " + entry.getValue() + " times.");
        }

        scanner.close();
    }
}
