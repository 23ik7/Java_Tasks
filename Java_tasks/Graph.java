public class Graph {
    String title;
    int[][] adjacencyMatrix;
    /** 
     * Constructs a Graph with the given title and adjacency matrix.
     * 
     * @param title title of the graph
     * @param adjacencyMatrix adjacency matrix of the graph
     */
    public Graph(String title, int[][] adjacencyMatrix) {
        this.title = title;
        this.adjacencyMatrix = adjacencyMatrix;
    }

    /** 
     * Checks whether the graph is symmetric.
     * 
     * @return true if the graph is symmetric, otherwise false
     */
    public boolean isSymmetric() {
        
        if (adjacencyMatrix.length == 1) {
            return true;
        }
        
        int c = 0;

        for(int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix.length; j++) {
                if (adjacencyMatrix[i][j] == adjacencyMatrix[j][i]) {
                    c++;
                }
            }
        }
        if (c / adjacencyMatrix.length == adjacencyMatrix.length) {
            return true;
        }
        else {
            return false;
        }
    }

    /** 
     * Turns all edges of the graph. 
     */
    public void turnEdges() {
        int help = 0;
        for(int i = 0; i < adjacencyMatrix.length; i++) {
            int var = -1;
            for (int j = 0 + help; j < adjacencyMatrix.length; j++) {
                if (adjacencyMatrix[i][j] != adjacencyMatrix[j][i]) {
                    var = adjacencyMatrix[i][j];
                    adjacencyMatrix[i][j] = adjacencyMatrix[j][i];
                    adjacencyMatrix[j][i] = var;
                } 
            
            }
            help++;
        }
    }
}
