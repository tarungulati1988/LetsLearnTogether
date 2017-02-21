import java.util.ArrayList;
import java.util.List;

/**
 * Created by tgulati on 2/19/17.
 */
public class Permutations {

    public static void main(String[] args) {

    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        doPermute(result, new ArrayList<>(), nums, 0);
        return result;
    }

    public void doPermute(List<List<Integer>> result, List<Integer> tempList, int[] nums, int index) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (tempList.contains(nums[i])) {
                continue;
            }
            tempList.add(nums[i]);
            doPermute(result, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
