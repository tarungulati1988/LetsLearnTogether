/**
 * Created by tgulati on 3/1/17.
 */
public class DiagonalTraversalArray {

    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int[] result = new int[matrix.length * matrix[0].length];
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0;
        int col = 0;
        int[][] dir = new int[][]{{-1, 1}, {1, -1}};
        int d = 0;
        for (int i = 0; i < n * m; i++) {

            result[i] = matrix[row][col];
            row += dir[d][0];
            col += dir[d][1];
            // bottom check
            if (row >= m) {
                row = m - 1;
                d = 1 - d;
                col += 2;
            }
            // right check
            if (col >= n) {
                col = n - 1;
                d = 1 - d;
                row += 2;
            }
            // top check
            if (row < 0) {
                row = 0;
                d = 1 - d;
            }
            // left check
            if (col < 0) {
                col = 0;
                d = 1 - d;
            }
        }
        return result;
    }
}
