/**
 * Created by tgulati on 8/6/16.
 */

import java.util.*;

class CycleDirected {
    private int V;
    private ArrayList<ArrayList<Integer>> graph;

    public CycleDirected(int V) {
        this.V = V;
        graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < V; i++)
            graph.add(new ArrayList<Integer>());
    }

    public void addEdge(int s, int d) {
        graph.get(s).add(d);
    }

    public boolean containsCycle() {
        ArrayList<Boolean> visited = new ArrayList<Boolean>();

        for (int i = 0; i < V; i++)
            visited.add(false);

        for (int j = 0; j < V; j++) {
            if (visited.get(j) == false && DFSUtil(visited, j))
                return true;
        }
        return false;
    }

    public boolean DFSUtil(ArrayList<Boolean> visited, int src) {
        List<Boolean> parent = new ArrayList<Boolean>();
        for (int i = 0; i < V; i++) {
            parent.add(false);
        }
        Stack<Integer> st = new Stack<Integer>();
        visited.set(src, true);
        parent.set(src, true);
        st.push(src);
        while (!st.isEmpty()) {
            int front = st.peek();
            st.pop();
            for (int num : graph.get(front)) {
                if (parent.get(num) == true)
                    return true;
                visited.set(num, true);
                parent.set(num, true);
                st.push(num);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CycleDirected g = new CycleDirected(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        System.out.println(g.containsCycle());
    }
}
