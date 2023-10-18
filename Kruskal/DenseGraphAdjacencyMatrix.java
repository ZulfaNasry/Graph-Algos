import java.util.Arrays;

public class DenseGraphAdjacencyMatrix {
    private int[][] adjacencyMatrix;
    private int numVertices;

    public DenseGraphAdjacencyMatrix(int numVertices) {
        this.numVertices = numVertices;
        this.adjacencyMatrix = new int[numVertices][numVertices];
    }

    public void addEdge(int source, int destination, int weight) {
        // Add an edge with the given weight between source and destination
        adjacencyMatrix[source][destination] = weight;
        adjacencyMatrix[destination][source] = weight; // For undirected graph
    }

    public void printGraph() {
        System.out.println("Dense Graph (Adjacency Matrix):");
        for (int i = 0; i < numVertices; i++) {
            System.out.print(i + ": ");
            for (int j = 0; j < numVertices; j++) {
                if (adjacencyMatrix[i][j] != 0) {
                    System.out.print(j + "(" + adjacencyMatrix[i][j] + ") ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int numVertices = 5;
        DenseGraphAdjacencyMatrix graph = new DenseGraphAdjacencyMatrix(numVertices);

        // Adding edges to the graph
        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 2, 4);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 7);
        graph.addEdge(2, 3, 3);
        graph.addEdge(3, 4, 5);

        // Print the graph
        graph.printGraph();
    }
}
