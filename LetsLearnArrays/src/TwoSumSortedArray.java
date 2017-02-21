/**
 * Created by tgulati on 2/17/17.
 */
public class TwoSumSortedArray {

    public static void main(String[] args) {
        int[] res = twoSum(new int[]{2,7,9,11,14}, 9);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }

    public static int[] twoSum(int[] numbers, int target) {
        if(numbers == null || numbers.length < 2) {
            return new int[2];
        }

        int[] res = new int[2];

        int i = 0;
        int j = numbers.length-1;
        int sum = 0;
        while (i < j) {
            sum = numbers[i] + numbers[j];
            if(target == sum) {
                res[0] = i+1;
                res[1] = j+1;
                return res;
            } else if (target < sum) {
                j--;
            } else {
                i++;
            }
        }
        return res;
    }
}
