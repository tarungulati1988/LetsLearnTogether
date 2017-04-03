import java.util.ArrayList;
import java.util.List;

/**
 * Created by tgulati on 2/27/17.
 */
public class FindMissingPositives {

    public static void main(String[] args) {
        FindMissingPositives object = new FindMissingPositives();
        List<Integer> result = object.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
        for (int i : result)
            System.out.println(i);
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }
}
