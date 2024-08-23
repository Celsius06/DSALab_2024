package Task_5;

public class Edge {
    private int startVertex;
    private int endVertex;
    private int weight;

    public Edge(int start, int end) {
        this(start, end, 1);
    }

    public Edge(int start, int end, int weight) {
        this.startVertex = start;
        this.endVertex = end;
        this.weight = weight;
    }

    public int getStartVertex() {
        return startVertex;
    }

    public int getEndVertex() {
        return endVertex;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "startVertex=" + startVertex +
                "endVertex=" + endVertex +
                "weight=" + weight +
                '}';
    }
}
