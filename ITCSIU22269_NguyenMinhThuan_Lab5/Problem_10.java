import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;

public class Problem_10 extends JPanel {
    // The depth represents the level of recursion/the number of iterations in the
    // construction of the triangle
    private final int depth;

    public Problem_10(int depth) {
        this.depth = depth;
        setPreferredSize(new Dimension(600, 550));
        setBackground(Color.WHITE);
    }

    private void drawTriangle(Graphics2D g, int depth, double x, double y, double size) {
        // Base case: If depth is 0, draw the triangle
        if (depth == 0) {
            Path2D.Double triangle = new Path2D.Double();
            triangle.moveTo(x, y);
            triangle.lineTo(x + size / 2, y + size * Math.sqrt(3) / 2);
            triangle.lineTo(x - size / 2, y + size * Math.sqrt(3) / 2);
            triangle.closePath();
            g.setColor(Color.BLUE);
            g.fill(triangle);
        } else {
            // Recursive case: Divide the triangle into smaller triangles and draw them
            // Top triangle
            drawTriangle(g, depth - 1, x, y, size / 2);
            // Right triangle
            drawTriangle(g, depth - 1, x + size / 4, y + size * Math.sqrt(3) / 4, size / 2);
            // Left triangle
            drawTriangle(g, depth - 1, x - size / 4, y + size * Math.sqrt(3) / 4, size / 2);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        drawTriangle(g2d, depth, getWidth() / 2.0, 0, 600);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Sierpinski Triangle");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new Problem_10(5)); // Depth represents the thickness of the triangle
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
