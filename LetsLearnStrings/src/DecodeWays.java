/**
 * Created by tgulati on 2/26/17.
 */
public class DecodeWays {

    public static void main(String[] args) {
        DecodeWays object = new DecodeWays();
        System.out.println(object.numDecodings("123"));
    }


    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s == "0") {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        int len = s.length();
        dp[len] = 1;
        dp[len - 1] = s.charAt(len - 1) != '0' ? 1 : 0;

        for (int i = len - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                continue;
            }
            dp[i] = Integer.parseInt(s.substring(i, i + 2)) <= 26 ? dp[i + 1] + dp[i + 2] : dp[i + 1];
        }
        return dp[0];
    }
}
