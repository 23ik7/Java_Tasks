
public class Bsp07 {
    public static void main(String[] args) {

    }


    ////// PART 1
    /** 
     * Creates an empty graph with the given order.
     * 
     * @param order number of nodes
     * @return adjacency matrix of a graph with order nodes, or null if 
     *  order is > 9 or <= 0.
     */
    public static int[][] createGraph(int order) {

    int [][] graph = new int[order][order];
    String minus = "-";

        if (order > 9 || order <= 0) {
            return null;
        }
        else if (order == 1){

            for (int i = 0; i < order; i++) {
                System.out.println(" |" + i);
                System.out.println("-|" + minus.repeat(i + 1));
                System.out.println(i + "|" + i);
            }
            return graph;
        }
        else {
            System.out.print(" |");

            for (int n = 0; n < order; n++){
                System.out.print(" " + n);
            }

            System.out.println();
            System.out.print("-|" + minus.repeat(order + 1));
            for (int i = 0; i < order; i++) {
                System.out.println();
                System.out.print(i + "|"  + " ");
                
                for (int j = 0; j < order; j++) {
                    System.out.print(0 + " ");
                }
            }
            return graph;
        }  
    }

    /** 
     * Adds an edge to the graph.
     * 
     * @param graph adjacency matrix of the graph
     * @param src source node
     * @param dst destination node
     * @return true if the edge was added or was already present, false if 
     *  the edge could not be added (e.g., because src or dst are invalid, 
     *  or src is equal to dst, or the graph is null).
     */
    public static boolean addEdge(int[][] graph, int src, int dst) {
        
        if ((src < 0) || (dst < 0) || (src == dst) || (graph == null) 
        || (src >= graph.length) || (dst >= graph.length)) {
            return false; 
        }

        if (graph[src][dst] == 0) {
            graph[src][dst] = 1;
            return true;
        }
        else {
            return true;
        }

    }

    /** 
     * Returns true if, and only if, the graph is complete.
     * 
     * @param graph adjacency matrix of the graph
     * @return true if the graph is complete, false otherwise
     */
    public static boolean isComplete(int[][] graph) {
        int c = 0;
        if (graph.length == 1) {
            return true;
        }
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                if (graph[i][j] == 1 && graph[j][i] == 1) {
                    c++;
                }
            }
        }
        if (c == ((graph.length*graph.length) - graph.length)) {
            return true;
        }
        else{
            return false;
        }
    }

    /** 
     * Returns the number of missing edges in the graph.
     * 
     * @param graph adjacency matrix of the graph
     * @return number of missing edges, or -1 if graph is null
     */
    public static int missingEdges(int[][] graph) {
        int dif = 0;
        int c = 0;
        if (graph == null) {
            return -1;
        }
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                if (graph[i][j] == 1) {
                    c++;
                }
            }
        }
        dif = ((graph.length*graph.length) - graph.length) - c;
        return dif;
    }
    
    /** 
     * Returns the maximum degree of the graph.
     * 
     * @param graph adjacency matrix of the graph
     * @return maximum degree of the graph, or -1 if graph is null
     */
    public static int maxDegree(int[][] graph) {
        int grad = 0;
        int max = 0;
        if (graph == null) {
            return -1;
        }
        for (int i = 0; i < graph.length; i++) {
            if (grad > max) {
                max = grad;
            }
            grad = 0;

            for (int j = 0; j < graph.length; j++) {
                if (graph[i][j] == 1) {
                    grad++;
                }
            }
        }
        return max;
    }

    /** 
     * Returns true if, and only if, the path is present in the graph.
     * 
     * @param graph adjacency matrix of the graph
     * @param path array of nodes
     * @return true if the path exists, false otherwise
     */
    public static boolean isPath(int[][] graph, int[] path) {
        int count = 0;

        for (int k = 0; k < path.length; k++) {
            if (k+1 < path.length && path[k] < graph.length  
            && path[k+1] < graph.length && graph[path[k]][path[k+1]] == 1) {
              count++;  
            } 
        }
        if (count+1 == path.length) {
            return true;
        }
        else {
            return false;
        }  
    }
    
    ////// PART 2
    /**
     * Returns the direct neighbors of a node, in ascending order.
     * 
     * The direct neighbors of a node are all nodes that are directly 
     * reachable from that node.
     * 
     * @param graph adjacency matrix of the graph
     * @param node node for which the direct neighbors are to be returned
     * @return array of nodes that are directly reachable from the given node, 
     *  or null if the node is invalid
     */
    public static int[] directNeighbors(int[][] graph, int node) {

        if (graph == null || node < 0 || node >= graph.length) {
            return null;
        }

        int c = 0;

        for (int i = 0; i < graph[node].length; i++) {
            if (graph[node][i] == 1) {
                c++;
            }
        }

        int [] neighbors = new int[c];
        int index = 0;

        for (int j = 0; j < graph[node].length; j++) {
            if (graph[node][j] == 1) {
                
                neighbors[index] = j;
                index++;
            }
        }

        return neighbors;  
    }
}