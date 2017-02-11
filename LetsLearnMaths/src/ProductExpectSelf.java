/**
 * Created by tgulati on 1/27/17.
 */
public class ProductExpectSelf {

    public static void main(String[] args) {
        int[] n = new int[]{1,2,3,4};
        int[] res = productExceptSelf(n);
        System.out.println(res[0]);
        System.out.println(res[3]);
    }

    public static int[] productExceptSelf(int[] nums) {

        int[] result = new int[nums.length];
        int[] p1 = new int[nums.length];
        int[] p2 = new int[nums.length];

        p1[0] = 1;
        p2[nums.length - 1] = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            p1[i + 1] = p1[i] * nums[i];
        }

        for (int i = nums.length - 1; i > 0; i--) {
            p2[i - 1] = p2[i] * nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            result[i] = p1[i] *  p2[i];
        }

        return result;
    }
}
