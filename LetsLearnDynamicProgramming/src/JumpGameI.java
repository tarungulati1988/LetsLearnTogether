/**
 * Created by tgulati on 1/30/17.
 */
public class JumpGameI {

    public static void main(String[] args) {

        int[] nums = new int[]{2, 3, 1, 1, 4};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;

        int max = 0;
        int i = 0;
        while (i < nums.length) {
            max = Math.max(max, nums[i] + i);

            if (nums[i] == 0 && max <= i)
                return false;

            if (max >= nums.length)
                return true;

            i++;
        }

        return true;
    }
}
