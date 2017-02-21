/**
 * Created by tgulati on 2/18/17.
 */
public class MaxProductSubArray {

    public static void main(String[] args) {
        MaxProductSubArray object = new MaxProductSubArray();
        System.out.println(object.maxProduct(new int[]{2, 3, -2, 4, 6}));
    }

    public int maxProduct(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max, min, result;
        min = max = result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int tempMax = max;
            max = Math.max(Math.max(nums[i] * max, nums[i] * min), nums[i]);
            min = Math.min(Math.min(nums[i] * tempMax, nums[i] * min), nums[i]);
            result = Math.max(max, min);
        }

        return result;
    }
}
