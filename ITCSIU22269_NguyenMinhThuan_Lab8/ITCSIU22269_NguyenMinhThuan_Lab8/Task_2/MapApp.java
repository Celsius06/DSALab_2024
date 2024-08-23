package Task_2;

public class MapApp {
    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addVertex('A'); // 0
        graph.addVertex('B'); // 1
        graph.addVertex('C'); // 2
        graph.addVertex('D'); // 3
        graph.addVertex('E'); // 4

        graph.addEdge(0, 1, 2); // A-B, weight 2
        graph.addEdge(1, 2, 3); // B-C, weight 3
        graph.addEdge(0, 3, 4); // A-D, weight 4
        graph.addEdge(3, 4, 5); // D-E, weight 5

        System.out.println("Vertex list: ");
        for (int i = 0; i < graph.nVerts; i++) {
            graph.displayVertex(i);
            System.out.println();
        }

        System.out.println("Adjacency Matrix (with weights): ");
        for (int i = 0; i < graph.nVerts; i++) {
            for (int j = 0; j < graph.nVerts; j++) {
                System.out.print(graph.adjMat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
