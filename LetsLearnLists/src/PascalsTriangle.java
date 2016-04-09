import java.util.ArrayList;
import java.util.List;

/**
 * Created by tgulati on 4/9/16.
 */
public class PascalsTriangle {

    public static void main(String[] args) {
        System.out.println(pascalsTriangle1(5));
        System.out.println(pascalsTriangle2(5));
    }

    private static List<List<Integer>> pascalsTriangle1(int num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(num == 0)
            return result;

        List<Integer> prev = new ArrayList<Integer>();
        prev.add(1);
        result.add(prev);

        for(int i = 1; i < num; i++) {
            List<Integer> curr = new ArrayList<Integer>();

            curr.add(1);

            for(int j = 0; j < prev.size() - 1; j++) {
                curr.add(prev.get(j) + prev.get(j + 1));
            }
            curr.add(1);
            result.add(curr);
            prev = curr;
        }

        return result;
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
