import java.util.*;
//GRAPH DEGREE CALCULATOR
public class Problem4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of edges: ");
        int numEdges = scanner.nextInt();

        // Creating an adjacency list to represent the graph
        Map<Integer, List<Integer>> graph = new HashMap<>();

        // Taking input for each edge and building the graph
        for (int i = 0; i < numEdges; i++) {
            System.out.print("Enter edge " + (i + 1) + " (vertex1 vertex2): ");
            int vertex1 = scanner.nextInt();
            int vertex2 = scanner.nextInt();
            addEdge(graph, vertex1, vertex2);
        }

        // Asking for the vertex whose degree is to be calculated
        System.out.print("Enter the vertex to find its degree: ");
        int vertex = scanner.nextInt();

        // Calculating and printing the degree of the specified vertex
        int degree = getDegree(graph, vertex);
        System.out.println("Degree of vertex " + vertex + " is: " + degree);

        scanner.close();
    }

    // Function to add an undirected edge to the graph
    private static void addEdge(Map<Integer, List<Integer>> graph, int vertex1, int vertex2) {
        graph.putIfAbsent(vertex1, new ArrayList<>());
        graph.putIfAbsent(vertex2, new ArrayList<>());
        graph.get(vertex1).add(vertex2);
        graph.get(vertex2).add(vertex1);
    }

    // Function to get the degree of a vertex in the graph
    private static int getDegree(Map<Integer, List<Integer>> graph, int vertex) {
        return graph.containsKey(vertex) ? graph.get(vertex).size() : 0;
    }
}