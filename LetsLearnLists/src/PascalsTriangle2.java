import java.util.ArrayList;
import java.util.List;

/**
 * Created by tgulati on 6/5/16.
 */
public class PascalsTriangle2 {

    public static void main(String[] args) {
        System.out.println(pascalsTriangle2(5));
    }

    private static List pascalsTriangle2(int num) {
        List<Integer> result = new ArrayList<Integer>();

        if(num == 0)
            return result;

        result.add(1);
        for(int i = 1; i < num; i++) {
            for(int j = result.size() - 2; j >= 0; j--) {
                result.set(j + 1, result.get(j) + result.get(j + 1));
            }
            result.add(1);
        }

        return result;
    }
}
