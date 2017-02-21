/**
 * Created by tgulati on 2/15/17.
 */
public class FloydWarshallAlgorithmConnectedWeightedGraph {

    public static int numberofVertices;
    public static int INF = 9999;

    public static void main(String[] args) {
        /* Let us create the following weighted graph
           10
        (0)------->(3)
        |         /|\
        5 |          |
        |          | 1
        \|/         |
        (1)------->(2)
           3           */


        int graph[][] = {{0, 5, INF, 10},
                         {INF, 0, 3, INF},
                         {INF, INF, 0, 1},
                         {INF, INF, INF, 0}
        };

        numberofVertices = graph.length;
        FloydWarshallAlgorithmConnectedWeightedGraph floyds = new FloydWarshallAlgorithmConnectedWeightedGraph();

        // Print the solution
        floyds.floydWarshall(graph);
    }

    private void floydWarshall(int[][] graph) {
        // relevant error checks

        int[][] res = new int[numberofVertices][numberofVertices];

        for (int i = 0; i < numberofVertices; i++) {
            for (int j = 0; j < numberofVertices; j++) {
                res[i][j] = graph[i][j];
            }
        }

        for (int k = 0; k < numberofVertices; k++) {
            for (int i = 0; i < numberofVertices; i++) {
                for (int j = 0; j < numberofVertices; j++) {
                    if (res[i][j] > res[i][k] + res[k][j]) {
                        res[i][j] = res[i][k] + res[k][j];
                    }
                }
            }
        }

        printSolution(res);
    }

    void printSolution(int res[][]) {
        for (int i = 0; i < numberofVertices; ++i) {
            for (int j = 0; j < numberofVertices; ++j) {
                if (res[i][j] == INF)
                    System.out.print("~   ");
                else
                    System.out.print(res[i][j] + "   ");
            }
            System.out.println();
        }
    }
}
