/**
 * Created by tgulati on 4/20/16.
 */
public class MoveZeroes {

    public static void moveZeroes(int[] nums) {

        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0)
                nums[j++] = nums[i];
        }

        while(j < nums.length) {
            nums[j++] = 0;
        }

    }

    public static void main(String[] args) {
        moveZeroes(new int[]{1,2,30,0,2,0,6,0,0,1});
    }
}
