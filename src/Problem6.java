import java.util.*;
//ADJACENCY MATRIX PROGRAM
public class Problem6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();
        int[][] adjacencyMatrix = new int[vertices][vertices];

        System.out.print("Enter the number of edges: ");
        int edges = scanner.nextInt();

        for (int i = 0; i < edges; i++) {
            System.out.println("Enter the edge " + (i + 1) + " (vertex pairs separated by space): ");
            int vertex1 = scanner.nextInt();
            int vertex2 = scanner.nextInt();

            // Assuming the graph is undirected, set both edges to 1
            adjacencyMatrix[vertex1][vertex2] = 1;
            adjacencyMatrix[vertex2][vertex1] = 1;
        }

        System.out.println("The adjacency matrix is:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}