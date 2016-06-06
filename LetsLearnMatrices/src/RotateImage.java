/**
 * Created by tgulati on 6/5/16.
 */
public class RotateImage {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4, 5},
                {2, 3, 4, 5, 6},
                {3, 4, 5, 6, 7},
                {5, 6, 7, 8, 9},
                {11, 12, 13, 14, 15}};

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

    public static void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length ==0)
            return;

        int n = matrix.length;
        for(int i  = 0; i < n/2; i++) {
            for(int j = 0; j < Math.ceil(((double)n)/2); j++) {
                int temp = matrix[i][j];

                matrix[i][j] = matrix[n-1-j][i];

                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];

                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];

                matrix[j][n-1-i] = temp;
            }
        }
    }
}
