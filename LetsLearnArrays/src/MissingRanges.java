import java.util.ArrayList;
import java.util.List;

/**
 * Created by tgulati on 2/28/17.
 */
public class MissingRanges {

    public static void main(String[] args) {
        MissingRanges object = new MissingRanges();
        List<String> res = object.findMissingRanges(new int[]{0, 1, 3, 50, 75}, 0, 99);
    }

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<String>();

        // the next number we need to find
        int next = lower;

        for (int i = 0; i < nums.length; i++) {
            // not within the range yet
            if (nums[i] < next) continue;

            // continue to find the next one
            if (nums[i] == next) {
                next++;
                continue;
            }

            // get the missing range string format
            res.add(getRange(next, nums[i] - 1));

            // now we need to find the next number
            next = nums[i] + 1;
        }

        // do a final check
        if (next <= upper) res.add(getRange(next, upper));

        return res;
    }

    public String getRange(int n1, int n2) {
        return (n1 == n2) ? String.valueOf(n1) : String.format("%d->%d", n1, n2);
    }
}
