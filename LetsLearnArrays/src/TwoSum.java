/**
 * Created by tgulati on 4/3/16.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, find two numbers such that they add up to a specific
 * target number.
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] result = twoSum1(new int[]{11, 7, 2, 15}, 9);
        System.out.println(result[0]);
        System.out.println(result[1]);

        result = twoSum2(new int[]{11, 13, 16, 19}, 29);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    /**
     * when the input array isn't sorted
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] numbers, int target) {
        Map<Integer, Integer> numbersMap = new HashMap<Integer, Integer>();

        int[] result = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            if (numbersMap.containsKey(numbers[i])) {
                int index = numbersMap.get(numbers[i]);
                result[0] = index+1 ;
                result[1] = i+1;
                break;
            } else {
                numbersMap.put(target - numbers[i], i);
            }
        }
        return result;
    }


    /**
     * when the input array is sorted
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0)
            return null;
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int x = numbers[i] + numbers[j];
            if (x < target) {
                ++i;
            } else if (x > target) {
                j--;
            } else {
                return new int[] { i + 1, j + 1 };
            }
        }
        return null;
    }



}
