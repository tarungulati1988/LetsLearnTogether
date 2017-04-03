/**
 * Created by tgulati on 2/27/17.
 */
public class MinimumSizeSubArray {

    /**
     * right always moves
     * if sum satifies the given condition, calculate the min length and move left
     *
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        int min = Integer.MAX_VALUE;
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0;
        int right = 0;
        int size = nums.length;
        int sum = 0;

        while (right < size && left < size) {
            sum += nums[right];
            right++;

            while (sum >= s) {
                min = Math.min(min, right - left);
                sum -= nums[left];
                left++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
