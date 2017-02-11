/**
 * Created by tgulati on 1/29/17.
 */
public class HouseRobberI {

    public static void main(String[] args) {
        int[] num = new int[]{1,2,4,5,2,7,9};
        System.out.println(houseRobber(num));
    }


    public static int houseRobber(int[] num) {
        if (num == null || num.length == 0)
            return 0;
        if (num.length == 1)
            return num[0];

        int[] dp = new int[num.length];
        dp[0] = num[0];
        dp[1] = Math.max(dp[0], num[1]);

        for (int i = 2; i < num.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + num[i]);
        }

        return dp[num.length - 1];


    }
}
