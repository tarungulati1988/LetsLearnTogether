/**
 * Created by tgulati on 6/5/16.
 */
public class FindDuplicate {

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{1,6,2,9,2,6,5,7,8,11,12,14,15}));
    }

    public static int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int lo = 1;
        int hi = nums.length - 1;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            int count = countNumbers(nums, mid);

            if (count <= mid) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return hi;
    }

    private static int countNumbers(int[] nums, int mid) {

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= mid) {
                count++;
            }
        }

        return count;
    }
}
