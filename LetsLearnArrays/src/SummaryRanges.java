import java.util.ArrayList;
import java.util.List;

/**
 * Created by tgulati on 2/27/17.
 */
public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < nums.length; i++) {
            int start = nums[i];
            while (i + 1 < nums.length && nums[i] + 1 == nums[i + 1]) {
                i++;
            }
            if (start != nums[i]) {
                sb.append(start).append("->").append(nums[i]);
            } else {
                sb.append(start);
            }
            result.add(sb.toString());
            sb = new StringBuilder();
        }

        return result;
    }
}
