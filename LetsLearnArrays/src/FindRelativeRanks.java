import java.util.Arrays;

/**
 * Created by tgulati on 3/6/17.
 */
public class FindRelativeRanks {

    /**
     * Input: [5, 4, 3, 2, 1]
     Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
     Explanation: The first three athletes got the top three highest scores, so they got "Gold Medal", "Silver Medal" and "Bronze Medal".
     For the left two athletes, you just need to output their relative ranks according to their scores.
     * @param nums
     * @return
     */

    public String[] findRelativeRanks(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new String[0];
        }

        Integer[] index = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            index[i] = i;
        }

        Arrays.sort(index, (a, b) -> {
            return (nums[b] - nums[a]);
        });
        String[] result = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                result[index[i]] = "Gold Medlal";
            } else if (i == 1) {
                result[index[i]] = "Silver Medlal";
            } else if (i == 2) {
                result[index[i]] = "Bronze Medlal";
            } else {
                result[index[i]] = String.valueOf(i + 1);
            }
        }
        return result;
    }
}
