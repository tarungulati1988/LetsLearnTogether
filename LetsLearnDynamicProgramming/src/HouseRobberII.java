/**
 * Created by tgulati on 1/30/17.
 */
public class HouseRobberII {

    public static void main(String[] args) {
        int[] num = new int[]{1,2,4,5,2,7,9};
        int max1 = houseRobber2(num, 0, num.length-2);
        int max2 = houseRobber2(num, 1, num.length-1);

        System.out.println(Math.max(max1, max2));
    }


    public static int houseRobber2(int[] num, int start, int end) {
        if(start == end)
            return num[end];

        int[] dp = new int[num.length];
        dp[start] = num[start];
        dp[start + 1] = Math.max(dp[start], num[start+1]);

        for (int i = start + 2; i <= end; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + num[i]);
        }

        return dp[end];
    }
}
