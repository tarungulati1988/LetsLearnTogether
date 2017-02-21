import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by tgulati on 2/15/17.
 */
public class CycleInGraph {


    public int numberOfVertices;
    public ArrayList<ArrayList<Integer>> adjList;

    public CycleInGraph(int x) {
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

        CycleInGraph graph1 = new CycleInGraph(4);

        graph1.addEdge(0, 1);
        graph1.addEdge(0, 2);
        graph1.addEdge(1, 2);
        graph1.addEdge(2, 0);
        graph1.addEdge(2, 3);
        graph1.addEdge(3, 3);

        System.out.println("graph1 contains a cycle: " + graph1.isCyclic());


        CycleInGraph graph2 = new CycleInGraph(4);

        graph2.addEdge(0, 1);
        graph2.addEdge(0, 2);
        graph2.addEdge(2, 3);

        System.out.println("graph2 contains a cycle: " + graph2.isCyclic());

        CycleInGraph graph3 = new CycleInGraph(4);

        graph3.addEdge(0, 1);
        graph3.addEdge(0, 2);
        graph3.addEdge(2, 3);
        graph3.addEdge(3, 3);

        System.out.println("graph3 contains a cycle: " + graph3.isCyclic());


    }

    public boolean isCyclic() {
        HashSet<Integer> visited = new HashSet<>();
        for (int i = 0; i < numberOfVertices; i++) {
            if (!visited.contains(i) && dfs(i, visited)) {
                return true;
            }
        }
        return false;

    }

    private boolean dfs(int i, HashSet<Integer> visited) {

        if (!visited.contains(i)) {
            HashSet<Integer> parent = new HashSet<>();
            parent.add(i);
            visited.add(i);
            List<Integer> children = adjList.get(i);

            for (int x : children) {
                if (visited.contains(x) || parent.contains(x)) {
                    return true;
                } else {
                    dfs(x, visited);
                }
            }
        }

        return false;
    }
}
