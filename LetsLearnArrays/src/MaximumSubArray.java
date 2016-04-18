/**
 * Created by tgulati on 4/17/16.
 */
/**
 * Max sum sub array using KADANE's ALGORITHM
 *
 *
 * start:
 * max_so_far = 0
 * max_ending_here = 0
 * loop i= 0 to n
 *      (i) max_ending_here = max_ending_here + a[i]
 *      (ii) if(max_ending_here < 0)
 *              max_ending_here = 0
 *      (iii) if(max_so_far < max_ending_here)
 *              max_so_far = max_ending_here
 *
 * return max_so_far
 *
 * Modified Kadane Algorithm:
 * max_so_far = a[0]
 * max_endinf_here = a[0]
 * loop i=0...n
 *      max_ending_here = Math.max(a[i], max_ending_here + a[i])
 *      max_so_far = Math.max(max_so_far, max_ending_here)
 *
 * Time complexity: O(n)
 */
public class MaximumSubArray {

    public int kandane(int[] arrA) {
        int max_so_far = 0;
        int max_ending_here = 0;

        for (int i = 0; i < arrA.length; i++) {
            max_ending_here += arrA[i];

            if (max_ending_here < 0)
                max_ending_here = 0;
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;

        }
        return max_ending_here;
    }

    public static void main(String args[]) {
        int arrA[] = {1, 2, -3, -4, 2, 7, -2, 3};
        MaximumSubArray obj = new MaximumSubArray();
        System.out.println("Maximum subarray is  " + obj.kandane(arrA));
        int arrB[] = {-2, -3, -4, -2, -7, -2, -3, -11};
        System.out.println("Maximum Subarray when all elements are negative : " + obj.kadaneModified(arrB));
    }

    private int kadaneModified(int[] arrB) {
        int max_ending_here = arrB[0];
        int max_so_far = arrB[0];

        for (int i = 0; i < arrB.length; i++) {
            max_ending_here = Math.max(arrB[i], max_ending_here + arrB[i]);
            max_so_far = Math.max(max_so_far, max_ending_here);
        }
        return max_so_far;
    }
}
