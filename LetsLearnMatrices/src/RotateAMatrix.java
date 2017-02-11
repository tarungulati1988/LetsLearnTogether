/**
 * Created by tgulati on 5/26/16.
 */
public class RotateAMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4, 5, 6},
                {2, 3, 4, 5, 6, 7},
                {3, 4, 5, 6, 7, 8},
                {5, 6, 7, 8, 9, 9},
                {11, 12, 13, 14, 15, 16},
                {111, 112, 113, 114, 115, 116}};

        display(matrix);

        rotate(matrix);

        display(matrix);

    }

    public static void display(int[][] matrix) {
        System.out.println("---------");
        for (int i = 0 ; i < matrix.length; i++) {
            for (int j  = 0 ; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("---------");
    }


    /**
     * works on the principle that m[i][j] == m[n - 1 - j][i]
     * @param matrix
     */
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n/2; j++) {
                // temp for top left
                int temp = matrix[i][j];
                // top left to top right
                matrix[i][j] = matrix[n - 1 - j][i];
                // top right to bottom right
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                // bottom right to bottom left
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                // bottom left to top left
                matrix[j][n - 1 - i] = temp;
            }
        }
    }
}
