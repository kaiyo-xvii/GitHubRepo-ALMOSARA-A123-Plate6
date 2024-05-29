import java.util.Scanner;
// INCIDENCE MATRIX PROGRAM
public class Problem7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of vertices and edges
        System.out.print("Enter the number of vertices: ");
        int numVertices = scanner.nextInt();
        System.out.print("Enter the number of edges: ");
        int numEdges = scanner.nextInt();

        // Create an empty incidence matrix
        int[][] incidenceMatrix = new int[numVertices][numEdges];

        // Input the edges and their counts
        for (int i = 0; i < numEdges; i++) {
            System.out.print("Enter the vertices of edge " + (i + 1) + ": ");
            int vertex1 = scanner.nextInt();
            int vertex2 = scanner.nextInt();

            // Mark the vertices in the incidence matrix
            incidenceMatrix[vertex1 - 1][i] = 1;
            incidenceMatrix[vertex2 - 1][i] = 1;

            // Input the number of times the edge appears (This part is optional and can be removed)
            System.out.print("Enter the count for edge " + (i + 1) + ": ");
            int count = scanner.nextInt();
            // The count input is currently not utilized correctly in the matrix.
            // Adjustments need to be made based on specific requirements for counts.
        }

        // Print the incidence matrix
        System.out.println("\nIncidence Matrix:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numEdges; j++) {
                System.out.print(incidenceMatrix[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
