/**
 * Created by tgulati on 1/26/17.
 */
public class AddIntegers {

    public static void main(String[] args) {
        System.out.println(integerBreak(111));
    }

    public static int integerBreak(int n) {
        int[] dp = new int[n + 1];

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < i + 1; j++) {
                if (i + j <= n) {
                    dp[i + j] = Math.max(Math.max(dp[i], i) * Math.max(dp[j], j), dp[i + j]);
                }
            }
        }

        return dp[n];
    }
}
