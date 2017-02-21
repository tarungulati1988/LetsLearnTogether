import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tgulati on 2/20/17.
 */
public class CombinationSumWithoutRepetition {

    public static void main(String[] args) {
        CombinationSumWithoutRepetition obj = new CombinationSumWithoutRepetition();
        List<List<Integer>> result = obj.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        for (List list : result) {
            System.out.println(list.toString());
        }
    }

    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        backtrack(result, new ArrayList<>(), target, nums, 0);
        return result;
    }

    public void backtrack(List<List<Integer>> result, ArrayList<Integer> tempList, int target, int[] nums, int index) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            tempList.add(nums[i]);
            backtrack(result, tempList, target - nums[i], nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
