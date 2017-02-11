/**
 * Created by tgulati on 1/29/17.
 */
public class DistinctSubsequences {

    public static void main(String[] args) {
        System.out.println(numDistincts("rabbbit", "rabbit"));
    }


    public static int numDistincts(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];

        for (int i = 0; i < s.length(); i++)
            dp[i][0] = 1;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] += dp[i - 1][j] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] += dp[i - 1][j];
                }
            }
        }

        return dp[s.length()][t.length()];
    }
}
