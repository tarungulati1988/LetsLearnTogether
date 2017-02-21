import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tgulati on 2/20/17.
 */
public class CombinationSumWithReUse {

    public static void main(String[] args) {
        CombinationSumWithReUse obj = new CombinationSumWithReUse();
        List<List<Integer>> result = obj.combinationSum(new int[]{1, 2, 3, 7, 4}, 7);
        for (List list : result) {
            System.out.println(list.toString());
        }
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        backtrack(result, new ArrayList<>(), 0, nums, target);
        return result;
    }

    public void backtrack(List<List<Integer>> result, ArrayList<Integer> tempList, int index, int[] nums, int target) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            tempList.add(nums[i]);
            // to include duplicates or reuse the same integer backtrack with the same index
            backtrack(result, tempList, i, nums, target - nums[i]);
            tempList.remove(tempList.size() - 1);
        }

    }
}
