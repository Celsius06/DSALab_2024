package Task_5.Draft;

import java.util.*;

public class MapApp_AH {

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
            adjMat[end][start] = weight;
        }

        public void displayVertex(int v) {
            System.out.print(vertexList[v].label);
        }

        // Dijkstra's Algorithm to find the shortest path
        public List<Character> shortestPath(int start, int target) {
            int[] distance = new int[MAX_VERTS];
            boolean[] visited = new boolean[MAX_VERTS];
            int[] previous = new int[MAX_VERTS];
            Arrays.fill(distance, Integer.MAX_VALUE);
            Arrays.fill(previous, -1);
            distance[start] = 0;

            while (true) {
                int minDistance = Integer.MAX_VALUE;
                int closestVertex = -1;

                for (int i = 0; i < nVerts; i++) {
                    if (!visited[i] && distance[i] < minDistance) {
                        minDistance = distance[i];
                        closestVertex = i;
                    }
                }

                if (closestVertex == -1)
                    break;
                visited[closestVertex] = true;

                for (int i = 0; i < nVerts; i++) {
                    if (adjMat[closestVertex][i] > 0) {
                        int tentative = distance[closestVertex] + adjMat[closestVertex][i];
                        if (tentative < distance[i]) {
                            distance[i] = tentative;
                            previous[i] = closestVertex;
                        }
                    }
                }
            }

            List<Character> path = new ArrayList<>();
            int current = target;
            while (current != -1) {
                path.add(vertexList[current].label);
                current = previous[current];
            }
            Collections.reverse(path);
            return path;
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

        // Find the shortest path from A to H
        List<Character> shortestPath = graph.shortestPath(0, 7); // 0: A, 7: H

        // Print the shortest path
        System.out.print("[Dijkstra] Shortest path from A to H: ");
        for (char vertex : shortestPath) {
            System.out.print(vertex + " ");
        }
    }
}
