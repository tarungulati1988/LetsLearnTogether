/**
 * Created by tgulati on 6/5/16.
 */
public class SetMatrixZeroes {

    public static void main(String[] args) {
        int[][] matrix = {{1, 0, 1, 1, 1},
                          {1, 1, 1, 1, 1},
                          {1, 1, 1, 1, 0},
                          {0, 1, 1, 1, 0},
                          {1, 1, 1, 0, 1}};

        display(matrix);

        setZeroes(matrix);

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

    public static void setZeroes(int[][] matrix) {

        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return;

        boolean topRow = false;
        boolean leftCol = false;


        // mark zero for top row
        for(int i = 0; i < matrix.length; i++) {
            if(matrix[i][0] == 0) {
                leftCol = true;
                break;
            }
        }

        // mark zero for first column
        for(int j = 0; j < matrix[0].length; j++) {
            if(matrix[0][j] == 0) {
                topRow = true;
                break;
            }
        }

        // mark zeros for the rest of the matrix on the first row and column
        for(int i  = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // use the marks to set locations to 0
        for(int i  = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // if first row is set then set to zero
        if(leftCol) {
            for(int i = 0; i < matrix.length; i++)
                matrix[i][0] = 0;
        }

        // if first colum is set then set to zero
        if(topRow) {
            for(int j = 0; j < matrix[0].length; j++)
                matrix[0][j] = 0;
        }

    }
}
