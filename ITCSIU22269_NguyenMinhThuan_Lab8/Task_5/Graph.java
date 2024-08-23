package Task_5;

class Graph {
    private final int MAX_VERTS = 20;
    public Vertex vertexList[]; // array of vertices
    public int adjMat[][]; // adjacency matrix to store weights
    public int nVerts; // current number of vertices

    public Graph() // constructor
    {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for (int j = 0; j < MAX_VERTS; j++) // set adjacency matrix to 0
            for (int k = 0; k < MAX_VERTS; k++)
                adjMat[j][k] = 0;
    }

    public void addVertex(char lab) {
        vertexList[nVerts++] = new Vertex(lab);
    }

    public void addEdge(int start, int end, int weight) {
        adjMat[start][end] = weight;
        adjMat[end][start] = weight; // since the graph is undirected
    }

    public void displayVertex(int v) {
        System.out.print(vertexList[v].label);
    }

    public int getWeight(int start, int end) {
        return adjMat[start][end];
    }
}
