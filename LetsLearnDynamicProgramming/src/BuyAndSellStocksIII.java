/**
 * Created by tgulati on 1/31/17.
 */
public class BuyAndSellStocksIII {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1, 4, 5, 7, 6, 3, 2, 9}));
    }

    public static int maxProfit(int[] nums) {

        if (nums == null || nums.length == 0)
            return 0;

        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int min = nums[0];
        left[0] = 0;
        int profit = 0;

        for (int i = 1; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            left[i] = Math.max(left[i - 1], nums[i] - min);
        }

        right[nums.length - 1] = 0;
        int max = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            max = Math.max(max, nums[i]);
            right[i] = Math.max(right[i + 1], max - nums[i]);
        }


        for (int i = 0; i < nums.length; i++) {
            profit = Math.max(profit, left[i] + right[i]);
        }

        return profit;
    }
}
