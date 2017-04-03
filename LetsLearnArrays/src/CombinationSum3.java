import java.util.ArrayList;
import java.util.List;

/**
 * Created by tgulati on 2/28/17.
 */
public class CombinationSum3 {


    /**
     * @param k the size of the subset
     * @param n the sum that the subset should sum up to
     * @return
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        backtrack(result, new ArrayList<>(), k, n, 1, 0);
        return result;
    }

    public void backtrack(List<List<Integer>> result, List<Integer> tempList, int k, int n, int index, int sum) {
        if (sum == n && tempList.size() == k) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = index; i <= 9; i++) {
            tempList.add(i);
            backtrack(result, tempList, k, n, i + 1, sum + i);
            tempList.remove(tempList.size() - 1);
        }
    }
}
