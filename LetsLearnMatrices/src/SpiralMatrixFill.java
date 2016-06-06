/**
 * Created by tgulati on 6/5/16.
 */

/**
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 */
public class SpiralMatrixFill {

    public static void main(String[] args) {
        display(generateMatrix(9));
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

    public static int[][] generateMatrix(int z) {

        if(z == 0)
            return new int[0][0];

        int[][] matrix = new int[z][z];
        int m = matrix.length;
        int n = matrix[0].length;
        int x = 0;
        int y = 0;
        int count = 1;

        while(m > 0 && n > 0) {

            // when no circle can be formed
            if(m == 1) {
                for(int i = 0; i < n; i++){
                    matrix[x][y++] = count;
                    count++;
                }
                break;
            } else if(n == 1) {
                for(int i = 0; i < m; i++){
                    matrix[x++][y] = count;
                    count++;
                }
                break;
            }

            // top row
            for(int i = 0 ; i < n-1; i++) {
                matrix[x][y++] = count;
                count++;
            }

            // right column
            for(int i = 0 ; i < m-1; i++) {
                matrix[x++][y] = count;
                count++;
            }

            // bottom row
            for(int i = 0 ; i < n-1; i++) {
                matrix[x][y--] = count;
                count++;
            }

            // left row
            for(int i = 0 ; i < m-1; i++) {
                matrix[x--][y] = count;
                count++;
            }

            x++;
            y++;
            m -= 2;
            n -= 2;

        }

        return matrix;
    }
}
