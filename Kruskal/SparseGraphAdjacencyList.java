import java.util.ArrayList;
import java.util.List;

public class SparseGraphAdjacencyList {
    private List<List<Edge>> adjacencyList;
    private int numVertices;

    public SparseGraphAdjacencyList(int numVertices) {
        this.numVertices = numVertices;
        this.adjacencyList = new ArrayList<>(numVertices);
        for (int i = 0; i < numVertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination, int weight) {
        // Add an edge with the given weight between source and destination
        adjacencyList.get(source).add(new Edge(destination, weight));
        adjacencyList.get(destination).add(new Edge(source, weight)); // For undirected graph
    }

    public void printGraph() {
        System.out.println("Sparse Graph (Adjacency List):");
        for (int i = 0; i < numVertices; i++) {
            System.out.print(i + ": ");
            for (Edge edge : adjacencyList.get(i)) {
                System.out.print(edge.destination + "(" + edge.weight + ") ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int numVertices = 5;
        SparseGraphAdjacencyList graph = new SparseGraphAdjacencyList(numVertices);

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

    private static class Edge {
        int destination;
        int weight;

        public Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }
}
