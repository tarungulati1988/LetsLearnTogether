import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by tgulati on 2/14/17.
 */
public class DepthFirtSearchConnectedGraph {


    public int numberOfVertices;
    public ArrayList<ArrayList<Integer>> adjList;

    public DepthFirtSearchConnectedGraph(int x) {
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

        DepthFirtSearchConnectedGraph graph = new DepthFirtSearchConnectedGraph(8);

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
        graph.addEdge(8, 8);

        graph.dfsRecursive(2);
        System.out.println("-------------");
        graph.dfsFromEveryNode();


    }

    private void dfsFromEveryNode() {
        HashSet<Integer> visited = new HashSet<>();
        for (int i = 0; i <= numberOfVertices; i++) {
            if (!visited.contains(i)) {
                dfsRecursive(i, visited);
            }
        }
    }

    private void dfsRecursive(int i) {
        HashSet<Integer> visited = new HashSet<>();
        dfsRecursive(i, visited);
    }

    private void dfsRecursive(int i, HashSet<Integer> visited) {
        visited.add(i);
        System.out.println(i);

        List<Integer> children = adjList.get(i);

        for (int x : children) {
            if (!visited.contains(x)) {
                dfsRecursive(x, visited);
            }
        }
    }

}
