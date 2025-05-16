/*You are given a list of edges of an undirected graph. Your task is to display the adjacency matrix of the graph. */
import java.util.*;

public class UndirectedGraph {

    
    public static void displayAdjacencyMatrix(int numberOfNodes, List<int[]> edges) {
        
        int[][] adjacencyMatrix = new int[numberOfNodes][numberOfNodes];
        
        
        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            adjacencyMatrix[node1][node2] = 1;  
            adjacencyMatrix[node2][node1] = 1;  
        }
        
        
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < numberOfNodes; i++) {
            for (int j = 0; j < numberOfNodes; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        
        System.out.print("Enter the number of nodes: ");
        int numberOfNodes = scanner.nextInt();
        System.out.print("Enter the number of edges: ");
        int numberOfEdges = scanner.nextInt();
        
        
        List<int[]> edges = new ArrayList<>();
        
        System.out.println("Enter the edges (for example, 0 1 for an edge between node 0 and node 1): ");
        
       
        for (int i = 0; i < numberOfEdges; i++) {
            int node1 = scanner.nextInt();
            int node2 = scanner.nextInt();
            edges.add(new int[]{node1, node2});
        }
        
       
        displayAdjacencyMatrix(numberOfNodes, edges);
        
        scanner.close();
    }
}
