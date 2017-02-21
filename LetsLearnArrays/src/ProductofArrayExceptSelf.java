/**
 * Created by tgulati on 2/16/17.
 */
public class ProductofArrayExceptSelf {

    public static void main(String[] args) {

        ProductofArrayExceptSelf obj = new ProductofArrayExceptSelf();
        System.out.println(obj.productExceptSelf(new int[]{1,2,3,4}));

    }

    public int[] productExceptSelf(int[] nums) {


        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int[] res = new int[nums.length];
        res[0] = 1;

        int[] res2 = new int[nums.length];
        res2[nums.length-1] = 1;

        for (int i=1;i<nums.length;i++) {
            res[i] = res[i-1]*nums[i-1];
        }

        for (int i = nums.length-2;i>=0;i--) {
            res2[i] = res2[i+1]*nums[i+1];
        }

        for (int i=0;i<nums.length;i++) {
            res[i] = res[i]*res2[i];
        }
        return res;

    }
}
