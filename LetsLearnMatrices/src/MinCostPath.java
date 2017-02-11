/**
 * Created by tgulati on 6/29/16.
 */

/**
 * Given a cost matrix cost[][] and a position (m, n) in cost[][],
 * write a function that returns cost of minimum cost path to reach
 * (m, n) from (0, 0). Each cell of the matrix represents a cost to
 * traverse through that cell. Total cost of a path to reach (m, n)
 * is sum of all the costs on that path (including both source and destination).
 * You can only traverse down, right and diagonally lower cells from a given cell,
 * i.e., from a given cell
 * (i, j), cells (i+1, j), (i, j+1) and (i+1, j+1) can be traversed.
 * You may assume that all costs are positive integers.
 */
public class MinCostPath {

    public static void main(String[] args) {
        int[][] cost = new int[][]{{1,2,3}, {1,8,2}, {1,1,9}};
        System.out.println(minimizeCostRecursive(cost, 0, 0));
        System.out.println(minimizeCostIterative(cost, cost.length, cost[0].length));
    }

    private static int minimizeCostIterative(int[][] cost, int m, int n) {
        if(m > cost.length-1 || n > cost[0].length-1)
            return Integer.MAX_VALUE;
        else if(m == cost.length-1 && n == cost[0].length-1)
            return cost[m][n];
            // calculate val for top row
            // calculate val for first column
            // use above to calculate for remaining matrix
            int[][] temp = new int[m][n];
            temp[0][0] = cost[0][0];
            for(int i = 1; i < cost[0].length; i++)
                temp[0][i] = temp[0][i-1] + cost[0][i];

            for(int i = 1; i < cost.length; i++)
                temp[i][0] = temp[i-1][0] + cost[i][0];

            for(int i = 1; i < cost.length; i++) {
                for(int j = 1; j < cost[0].length; j++) {
                    temp[i][j] = cost[i][j] + min(temp[i+1][j], temp[i+1][j+1], temp[i][j+1]);
                }
            }
        return temp[m][n];
    }

    private static int minimizeCostRecursive(int[][] cost, int m, int n) {
        if(m > cost.length-1 || n > cost[0].length-1)
            return Integer.MAX_VALUE;
        else if(m == cost.length-1 && n == cost[0].length-1)
            return cost[m][n];
        else
            return cost[m][n] + min(minimizeCostRecursive(cost, m+1, n+1),
                    minimizeCostRecursive(cost, m+1, n),
                    minimizeCostRecursive(cost, m, n+1));

    }

    private static int min(int a, int b, int c) {
        if(a < b)
            return a < c ? a : c;
        else
            return b<c ? b: c;
    }

}
