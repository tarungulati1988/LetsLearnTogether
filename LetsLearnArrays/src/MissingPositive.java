/**
 * Created by tgulati on 4/9/16.
 */

/**
 * Given an unsorted integer array, find the first missing positive integer. For example,
 * given [1,2,0] return 3 and [3,4,-1,1] return 2
 */
public class MissingPositive {

    public static void main(String[] args) {
        System.out.println(findMissingPositive(new int[]{1, 2, 0}, 3));
        System.out.println(findMissingPositive(new int[]{3, 4, -1, 1}, 4));
    }

    public static int findMissingPositive(int[] A, int n) {
        for (int i = 0; i < n; i++) {

            while (A[i] != i + 1) {
                // no need to swap when ith element is out of the range [0, n]
                if (A[i] <= 0 || A[i] > n)
                    break;
                // swap elements
                int temp = A[i];
                A[i] = A[temp - 1];
                A[temp - 1] = temp;
            }

        }

        for (int i = 0; i < n; i++)
            if (A[i] != i + 1)
                return i + 1;
        return n + 1;
    }
}
