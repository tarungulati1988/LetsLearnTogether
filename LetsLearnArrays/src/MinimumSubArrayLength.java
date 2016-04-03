/**
 * Created by tgulati on 4/3/16.
 */

/**
 * Given an array of n positive integers and a positive integer s, find the minimal length
 * of a subarray of which the sum ≥ s. If there isn’t one, return 0 instead.
 * For example, given the array [2,3,1,2,4,3] and s = 7, the subarray [4,3] has the minimal
 * length of 2 under the problem constraint.
 * Keep a sliding window when iterating over the array to find the window
 * if the sum of the sub array is larger than the sum, then increment the left pointer
 * else shift the right pointer
 */
public class MinimumSubArrayLength {

    public static void main(String[] args) {
        System.out.println(minSubArrayLength(7, new int[]{2, 3, 1, 2, 4, 3}));
    }

    public static int minSubArrayLength(int s, int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        // initialize min length to be the input array length
        int result = nums.length;
        int i = 0;
        int sum = nums[0];
        for(int j=0; j<nums.length; ) {
            if(i==j) {
                if(nums[i]>=s) {
                    return 1; //if single elem is large enough
                } else {
                    j++;
                    if(j<nums.length) {
                        sum = sum + nums[j];
                    } else {
                        return result;
                    }
                }
            } else {
                //if sum is large enough, move left cursor
                if(sum >= s) {
                    result = Math.min(j-i+1, result);
                    sum = sum - nums[i];
                    i++;
                //if sum is not large enough, move right cursor
                }else {
                    j++;
                    if(j<nums.length) {
                        sum = sum + nums[j];
                    } else {
                        if(i==0) {
                            return 0;
                        } else {
                            return result;
                        }
                    }
                }
            }
        }
        return result;
    }

}
