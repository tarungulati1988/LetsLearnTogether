import java.util.HashSet;
import java.util.Set;

/**
 * Created by tgulati on 4/3/16.
 */

/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements
 * sequence.
 * For example, given [100, 4, 200, 1, 3, 2], the longest consecutive elements sequence
 * should be [1, 2, 3, 4]. Its length is 4.
 * Your algorithm should run in O(n) complexity
 *
 * If O(n) run time complexity wasn't required this could be done in O(nlogn)
 * to do so we would sort the array and iterate over it
 */
public class LongestConsecutiveSubsequence {

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 2, 3, 5, 101, 102, 103, 104, 105, 106}));
    }

    public static int longestConsecutive(int[] numbers) {
        // if array is empty, return 0
        if (numbers.length == 0) {
            return 0;
        }
        Set<Integer> numberSet = new HashSet<Integer>();
        int max = 1;
        for (int number : numbers)
            numberSet.add(number);
        for (int e : numbers) {
            int left = e - 1;
            int right = e + 1;
            int count = 1;
            while (numberSet.contains(left)) {
                count++;
                numberSet.remove(left);
                left--;
            }
            while (numberSet.contains(right)) {
                count++;
                numberSet.remove(right);
                right++;
            }
            max = Math.max(count, max);
        }
        return max;
    }
}
