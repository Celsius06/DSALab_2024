// This class is the solution for this following requirement: Print out the number of paths to go from A to K
// Breadth-First Search (BFS)

package Task_4;

import java.util.*;

public class MapApp_req1 {

    static class Graph {
        private int MAX_VERTS = 20;
        private Vertex vertexList[];
        private int adjMat[][];
        private int nVerts;
        private Map<Character, Integer> labelToIndex;

        public Graph() {
            vertexList = new Vertex[MAX_VERTS];
            adjMat = new int[MAX_VERTS][MAX_VERTS];
            nVerts = 0;
            labelToIndex = new HashMap<>();
        }

        public void addVertex(char label) {
            vertexList[nVerts] = new Vertex(label);
            labelToIndex.put(label, nVerts++);
        }

        public void addEdge(int start, int end, int weight) {
            adjMat[start][end] = weight;
        }

        public void displayVertex(int v) {
            System.out.print(vertexList[v].label);
        }

        public List<List<Character>> findAllPaths(int start, int target) {
            List<List<Character>> paths = new ArrayList<>();
            boolean[] visited = new boolean[MAX_VERTS];
            Queue<List<Character>> queue = new LinkedList<>();
            List<Character> pathList = new ArrayList<>();
            pathList.add(vertexList[start].label);
            queue.offer(pathList);
            while (!queue.isEmpty()) {
                pathList = queue.poll();
                char currentVertexLabel = pathList.get(pathList.size() - 1);
                int currentVertex = labelToIndex.get(currentVertexLabel); // Get index from label
                visited[currentVertex] = true;
                if (currentVertex == target) {
                    paths.add(new ArrayList<>(pathList));
                } else {
                    for (int i = 0; i < nVerts; i++) {
                        if (adjMat[currentVertex][i] != 0 && !visited[i]) {
                            List<Character> newPathList = new ArrayList<>(pathList);
                            newPathList.add(vertexList[i].label);
                            queue.offer(newPathList);
                        }
                    }
                }
            }
            return paths;
        }
    }

    static class Vertex {
        public char label;

        public Vertex(char label) {
            this.label = label;
        }
    }

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

        // Find all paths from A to K and print the number of paths
        List<List<Character>> paths = graph.findAllPaths(0, 10); // 0: A, 10: K
        System.out.println("[BFS] Number of paths from A to K: " + paths.size());

        // Print all paths
        System.out.println("[BFS] All paths from A to K: ");
        for (List<Character> path : paths) {
            boolean isAtoKPath = path.get(0) == 'A' && path.get(path.size() - 1) == 'K';
            if (isAtoKPath) {
                for (char vertex : path) {
                    System.out.print(vertex + " ");
                }
                System.out.println();

                // // Print all paths
                // System.out.println("All paths from A to K: ");
                // for (List<Character> path : paths) {
                // for (char vertex : path) {
                // System.out.print(vertex + " ");
                // }
                // System.out.println();
                // }

                // // Display the vertices
                // System.out.println("\nVertex list:");
                // for (int i = 0; i < graph.nVerts; i++) {
                // graph.displayVertex(i);
                // System.out.println();
                // }

                // // Display the adjacency matrix
                // System.out.println("\nAdjacency Matrix (with weights):");
                // for (int i = 0; i < graph.nVerts; i++) {
                // for (int j = 0; j < graph.nVerts; j++) {
                // System.out.print(graph.adjMat[i][j] + " ");
                // }
                // System.out.println();
                // }
            }
        }
    }
}