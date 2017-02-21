import java.util.HashSet;

/**
 * Created by tgulati on 2/14/17.
 */
public class DjikstrasAlgorithmWeightedGraph {

    public int numberOfVertices;


    public static void main(String[] args) {
        /* Let us create the example graph discussed above */
        int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
                                    {4, 0, 8, 0, 0, 0, 0, 11, 0},
                                    {0, 8, 0, 7, 0, 4, 0, 0, 2},
                                    {0, 0, 7, 0, 9, 14, 0, 0, 0},
                                    {0, 0, 0, 9, 0, 10, 0, 0, 0},
                                    {0, 0, 4, 14, 10, 0, 2, 0, 0},
                                    {0, 0, 0, 0, 0, 2, 0, 1, 6},
                                    {8, 11, 0, 0, 0, 0, 1, 0, 7},
                                    {0, 0, 2, 0, 0, 0, 6, 7, 0}};

        DjikstrasAlgorithmWeightedGraph t = new DjikstrasAlgorithmWeightedGraph();
        t.numberOfVertices = 9;
        t.dijkstra(graph, 0);
    }

    private void dijkstra(int[][] graph, int src) {

        HashSet<Integer> shortestSet = new HashSet<>(numberOfVertices);
        int[] distance = new int[numberOfVertices];

        for (int i  = 0; i < 9; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        distance[src] = 0;

        for (int v = 0; v <numberOfVertices-1; v++) {

            int minIndex = minDistance(distance, shortestSet);
            shortestSet.add(minIndex);

            for(int k = 0 ; k < numberOfVertices; k++) {

                if(!shortestSet.contains(k)
                        && graph[minIndex][k] != 0
                        && distance[minIndex] != Integer.MAX_VALUE
                        && distance[k] > distance[minIndex] + graph[minIndex][k]) {
                    distance[k] = distance[minIndex] + graph[minIndex][k];
                }

            }
        }

        // print the shortest paths
        printShortestPaths(distance);

    }

    private void printShortestPaths(int[] distance) {
        for(int i =0; i < numberOfVertices;i++) {
            System.out.println("src 0 to: " + i + " distance is: " + distance[i]);
        }
    }

    private int minDistance(int[] distance, HashSet<Integer> shortestSet) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i =0;i<numberOfVertices;i++) {
            if(!shortestSet.contains(i) && distance[i] < min) {
                min = distance[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}
