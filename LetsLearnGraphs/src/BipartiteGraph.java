import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tgulati on 7/12/16.
 */
/*
 * Check whether a given graph is Bipartite or not
 * A Bipartite Graph is a graph whose vertices can be divided into two independent sets,
 * U and V such that every edge (u, v) either connects a vertex from U to V or a vertex
 * from V to U. In other words, for every edge (u, v), either u belongs to U and v to V,
 * or u belongs to V and v to U. We can also say that there is no edge that connects
 * vertices of same set.
 * http://www.geeksforgeeks.org/bipartite-graph/
 */

public class BipartiteGraph {
    private enum Color {
        RED, BLUE;

        public Color getOtherColor() {
            if (this == RED) {
                return (BLUE);
            } else {
                return (RED);
            }
        }
    }

    private static class Graph {
        public int vertices;
        public Map<Integer, List<Integer>> adjList;

        public Graph(int vertices) {
            this.vertices = vertices;
            this.adjList = new HashMap<>();
        }

        private void addEdge(int start, int end) {
            List<Integer> currentList = adjList.get(start);
            if (currentList == null) {
                currentList = new ArrayList<>();
                adjList.put(start, currentList);
            }
            currentList.add(end);

            List<Integer> currentList2 = adjList.get(end);
            if (currentList2 == null) {
                currentList2 = new ArrayList<>();
                adjList.put(end, currentList2);
            }
            currentList2.add(start);
        }

        public List<Integer> getNeighbors(Integer front) {
            return (adjList.get(front));
        }
    }

    public static void main(String[] args) {
        // setup graph
        System.out.println("Graph 1:");
        Graph g = new Graph(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        System.out.println(isBipartite(g));

        System.out.println("Graph 2:");
        Graph g2 = new Graph(7);
        g2.addEdge(0, 1);
        g2.addEdge(0, 2);
        g2.addEdge(1, 3);
        g2.addEdge(2, 3);
        g2.addEdge(2, 4);
        g2.addEdge(3, 4);
        System.out.println(isBipartite(g2));
    }

    private static boolean isBipartite(Graph g) {
        return false;
    }

}
