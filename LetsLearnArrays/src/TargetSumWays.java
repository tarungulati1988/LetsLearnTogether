/**
 * Created by tgulati on 3/5/17.
 */

/**
 * Input: nums is [1, 1, 1, 1, 1], S is 3.
 Output: 5
 Explanation:

 -1+1+1+1+1 = 3
 +1-1+1+1+1 = 3
 +1+1-1+1+1 = 3
 +1+1+1-1+1 = 3
 +1+1+1+1-1 = 3

 There are 5 ways to assign symbols to make the sum of nums be target 3
 */
public class TargetSumWays {


    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] result = new int[1];
        result[0] = 0;
        dfsHelper(result, nums, S, 0, 0);
        return result[0];
    }

    public void dfsHelper(int[] result, int[] nums, int target, int index, int sum) {
        if (nums.length == index) {
            if (target == sum) {
                result[0]++;
            }
            return;
        }
        dfsHelper(result, nums, target, index + 1, sum + nums[index]);
        dfsHelper(result, nums, target, index + 1, sum - nums[index]);
    }
}
