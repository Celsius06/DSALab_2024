package Task_3;

public class MapApp {
    public static void main(String[] args) {
        Graph graph = new Graph();

        // Add vertices
        graph.addVertex('A'); // 0
        graph.addVertex('B'); // 1
        graph.addVertex('C'); // 2
        graph.addVertex('D'); // 3
        graph.addVertex('E'); // 4
        graph.addVertex('F'); // 5
        graph.addVertex('G'); // 6
        graph.addVertex('H'); // 7
        graph.addVertex('I'); // 8
        graph.addVertex('J'); // 9
        graph.addVertex('K'); // 10
        graph.addVertex('L'); // 11
        graph.addVertex('2'); // 12

        // Add edges with weights
        graph.addEdge(0, 1, 6); // A-B
        graph.addEdge(0, 12, 10); // A-2
        graph.addEdge(1, 2, 11); // B-C
        graph.addEdge(1, 3, 14); // B-D
        graph.addEdge(1, 12, 12); // B-2
        graph.addEdge(2, 4, 6); // C-E
        graph.addEdge(2, 5, 3); // C-F
        graph.addEdge(2, 12, 12); // C-2
        graph.addEdge(3, 4, 4); // D-E
        graph.addEdge(3, 7, 6); // D-H
        graph.addEdge(4, 7, 6); // E-H
        graph.addEdge(5, 7, 16); // F-H
        graph.addEdge(5, 8, 6); // F-I
        graph.addEdge(5, 12, 8); // F-2
        graph.addEdge(6, 8, 8); // G-I
        graph.addEdge(6, 12, 16); // G-2
        graph.addEdge(7, 8, 16); // H-I
        graph.addEdge(7, 10, 12); // H-K
        graph.addEdge(7, 11, 18); // H-L
        graph.addEdge(8, 11, 17); // I-L
        graph.addEdge(9, 11, 20); // J-L
        graph.addEdge(9, 10, 9); // J-K
        graph.addEdge(10, 3, 15); // K-D
        graph.addEdge(10, 7, 12); // K-H

        // Display the vertices
        System.out.println("Vertex list: ");
        for (int i = 0; i < graph.nVerts; i++) {
            graph.displayVertex(i);
            System.out.println();
        }

        // Display the adjacency matrix
        System.out.println("Adjacency Matrix (with weights): ");
        for (int i = 0; i < graph.nVerts; i++) {
            for (int j = 0; j < graph.nVerts; j++) {
                System.out.print(graph.adjMat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
