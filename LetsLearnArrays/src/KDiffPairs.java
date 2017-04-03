import java.util.Arrays;

/**
 * Created by tgulati on 3/8/17.
 */
public class KDiffPairs {

    public int findPairs(int[] nums, int k) {
        if (nums == null && nums.length <= 1) {
            return 0;
        }

        Arrays.sort(nums);
        int left = 0;
        int right = 1;
        int count = 0;

        while (right < nums.length) {
            int x = nums[left];
            int y = nums[right];
            if (y - x < k) {
                right++;
            } else if (y - x > k) {
                left++;
            } else {
                count++;
                while (left < nums.length && nums[left] == x) {
                    left++;
                }
                while (right < nums.length && nums[right] == x) {
                    right++;
                }
            }
            if (left == right) {
                right++;
            }
        }
        return count;
    }
}
