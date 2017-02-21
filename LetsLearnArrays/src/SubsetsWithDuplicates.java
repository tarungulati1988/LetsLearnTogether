import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tgulati on 2/20/17.
 */
public class SubsetsWithDuplicates {

    public static void main(String[] args) {
        SubsetsWithDuplicates subsets = new SubsetsWithDuplicates();
        List<List<Integer>> result = subsets.subsetsWithDup(new int[]{4, 4, 1, 4});
        for (List list : result) {
            System.out.println(list.toString());
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    public void backtrack(List<List<Integer>> result, ArrayList<Integer> tempList, int[] nums, int index) {
        result.add(new ArrayList<>(tempList));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            tempList.add(nums[i]);
            backtrack(result, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
