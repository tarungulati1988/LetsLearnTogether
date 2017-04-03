/**
 * Created by tgulati on 2/28/17.
 */
public class UpdateArray {
    /**
     * Assume you have an array of length n initialized with all 0's and are given k update operations.

     Each operation is represented as a triplet: [startIndex, endIndex, inc] which increments each element of subarray A[startIndex ... endIndex] (startIndex and endIndex inclusive) with inc.

     Return the modified array after all k operations were executed.

     Example:

     Given:

     length = 5,
     updates = [
     [1,  3,  2],
     [2,  4,  3],
     [0,  2, -2]
     ]

     Output:

     [-2, 0, 3, 5, 3]
     Explanation:

     Initial state:
     [ 0, 0, 0, 0, 0 ]

     After applying operation [1, 3, 2]:
     [ 0, 2, 2, 2, 0 ]

     After applying operation [2, 4, 3]:
     [ 0, 2, 5, 5, 3 ]

     After applying operation [0, 2, -2]:
     [-2, 0, 3, 5, 3 ]
     * @param length
     * @param updates
     * @return
     */

    public int[] getModifiedArray(int length, int[][] updates) {
        int[] result = new int[length];

        if (updates == null || updates.length == 0) {
            return result;
        }
        for (int[] update : updates) {
            int start = update[0];
            int end = update[1];
            int value = update[2];
            result[start] += value;
            if (end < length - 1) {
                result[end + 1] -= value;
            }
        }

        int sum = 0;
        for (int i = 0; i < result.length; i++) {
            sum += result[i];
            result[i] = sum;
        }
        return result;
    }
}
