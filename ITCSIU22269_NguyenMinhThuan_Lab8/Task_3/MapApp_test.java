// This class will represent the illustrative view of the given figure in the question
// The figure quality will be a little bit ugly, I have tried my best :<

package Task_3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MapApp_test extends JPanel {
    private Graph graph;
    private String[] vertexNames;

    public MapApp_test(Graph graph, String[] vertexNames) {
        this.graph = graph;
        this.vertexNames = vertexNames;
        setLayout(new BorderLayout()); // Set BorderLayout for the JPanel
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Coordinates for vertices (manually positioned for the provided graph)
        int[][] positions = {
                { 50, 150 }, // A
                { 150, 100 }, // B
                { 150, 200 }, // C
                { 250, 70 }, // D
                { 250, 200 }, // E
                { 350, 200 }, // F
                { 50, 300 }, // G
                { 350, 100 }, // H
                { 450, 200 }, // I
                { 550, 300 }, // J
                { 550, 70 }, // K
                { 400, 300 }, // L
                { 100, 250 } // 2
        };

        // Draw edges and weights
        for (int i = 0; i < graph.nVerts; i++) {
            for (int j = i; j < graph.nVerts; j++) {
                int weight = graph.adjMat[i][j];
                if (weight != 0) {
                    int x1 = positions[i][0];
                    int y1 = positions[i][1];
                    int x2 = positions[j][0];
                    int y2 = positions[j][1];

                    g.drawLine(x1, y1, x2, y2);

                    // Calculate midpoint and offset for the weight
                    int midX = (x1 + x2) / 2;
                    int midY = (y1 + y2) / 2;

                    // Calculate unit vector components
                    double length = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
                    double unitX = (x2 - x1) / length;
                    double unitY = (y2 - y1) / length;

                    // Calculate offset
                    int offsetX = (int) (unitY * 3);
                    int offsetY = (int) (-unitX * 3);

                    g.drawString(String.valueOf(weight), midX + offsetX, midY + offsetY);
                }
            }
        }

        // Draw vertices
        for (int i = 0; i < graph.nVerts; i++) {
            g.setColor(Color.WHITE);
            g.fillOval(positions[i][0] - 15, positions[i][1] - 15, 30, 30);
            g.setColor(Color.BLACK);
            g.drawOval(positions[i][0] - 15, positions[i][1] - 15, 30, 30);
            g.drawString(vertexNames[i], positions[i][0] - 5, positions[i][1] + 5);
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

        // Vertex names
        String[] vertexNames = {
                "A", "B", "C", "D", "E",
                "F", "G", "H", "I", "J",
                "K", "L", "2"
        };

        // Create the JFrame and add the MapApp panel
        JFrame frame = new JFrame("Graph Visualization");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        MapApp_test mapApp = new MapApp_test(graph, vertexNames);
        frame.add(mapApp, BorderLayout.CENTER);
        frame.addComponentListener((ComponentListener) new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                mapApp.repaint();
            }
        });
        frame.setVisible(true);
    }
}
