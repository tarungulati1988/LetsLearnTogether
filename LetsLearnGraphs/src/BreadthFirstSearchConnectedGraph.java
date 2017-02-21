import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tgulati on 2/13/17.
 */
public class BreadthFirstSearchConnectedGraph {


    public int numberOfVertices;
    public ArrayList<ArrayList<Integer>> adjList;

    public BreadthFirstSearchConnectedGraph(int x) {
        this.numberOfVertices = x;
        this.adjList = new ArrayList<>(x);
        for (int i = 0; i <= x; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int vertice, int edge) {
        adjList.get(vertice).add(edge);
    }


    public static void main(String[] args) {

        BreadthFirstSearchConnectedGraph graph = new BreadthFirstSearchConnectedGraph(7);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
        graph.addEdge(3, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);
        graph.addEdge(5, 6);
        graph.addEdge(6, 7);
        graph.addEdge(6, 3);

        graph.bfs(2);


    }

    private void bfs(int i) {
        LinkedList<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();

        visited.add(i);
        queue.add(i);

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            System.out.println(temp);

            List<Integer> list = adjList.get(temp);
            for (int x : list) {
                if (!visited.contains(x)) {
                    queue.add(x);
                    visited.add(x);
                }
            }
        }
    }

}
