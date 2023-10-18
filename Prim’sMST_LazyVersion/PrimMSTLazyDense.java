import java.util.Arrays;

public class PrimMSTLazyDense {
    private static final int V = 5000; // Number of nodes
    private static int[][] graph; // Dense adjacency matrix
    private static boolean[] inMST; // To track included vertices in MST
    private static int[] key; // To store key values for each vertex
    private static int[] parent; // To store parent of each vertex in MST

    public PrimMSTLazyDense() {
        graph = new int[V][V];
        inMST = new boolean[V];
        key = new int[V];
        parent = new int[V];

        // Initialize the graph with appropriate edge weights (you can populate this)
        // Initialize key values to a large number and inMST to false
        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(inMST, false);
    }

    private void primMST() {
        key[0] = 0; // Start with the first vertex
        parent[0] = -1; // No parent for the first vertex

        for (int count = 0; count < V - 1; count++) {
            int u = minKey();
            inMST[u] = true;

            // Update key values and parent for adjacent vertices
            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && !inMST[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        // Print the MST or perform other operations as needed
    }

    private int minKey() {
        int min = Integer.MAX_VALUE, minIndex = -1;
        for (int v = 0; v < V; v++) {
            if (!inMST[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    public static void main(String[] args) {
        PrimMSTLazyDense primMST = new PrimMSTLazyDense();
        primMST.primMST();
        // Perform operations with the MST as needed
    }
}
