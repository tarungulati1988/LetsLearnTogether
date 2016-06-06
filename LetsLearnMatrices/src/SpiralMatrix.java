import java.util.ArrayList;
import java.util.List;

/**
 * Created by tgulati on 6/5/16.
 */
public class SpiralMatrix {

    public static void main(String[] args) {

        int[][] matrix = {{1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 0},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 0, 1}};

        display(matrix);

        List<Integer> result = spiralOrder(matrix);

        for(Integer i : result) {
            System.out.print(i.intValue());
        }

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

    public static List<Integer> spiralOrder(int[][] matrix) {

        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return null;

        List<Integer> result = new ArrayList<>();

        int m = matrix.length;
        int n = matrix[0].length;
        int x = 0;
        int y = 0;


        while(m > 0 && n > 0) {

            // when no circle can be formed
            if(m == 1) {
                for(int i = 0; i < n; i++){
                    result.add(matrix[x][y++]);
                }
                break;
            } else if(n == 1) {
                for(int i = 0; i < m; i++){
                    result.add(matrix[x++][y]);
                }
                break;
            }

            // top row
            for(int i = 0 ; i < n-1; i++)
                result.add(matrix[x][y++]);
            // right column
            for(int i = 0 ; i < m-1; i++)
                result.add(matrix[x++][y]);
            // bottom row
            for(int i = 0 ; i < n-1; i++)
                result.add(matrix[x][y--]);
            // left row
            for(int i = 0 ; i < m-1; i++)
                result.add(matrix[x--][y]);


            x++;
            y++;
            m -= 2;
            n -= 2;

        }

        return result;
    }
}
