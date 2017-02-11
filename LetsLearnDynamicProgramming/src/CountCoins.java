/**
 * Created by tgulati on 2/4/17.
 */
public class CountCoins {

    public static void main(String[] args) {
        int[] n = new int[]{2,4,1,6,8,12,7,5,3};
        int amt = 25;
        System.out.println(count(amt, n));

    }

    public static int count(int amount, int[] coins) {


        // error cases here

        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 0 ; i <= amount; i++)
            dp[i] = Integer.MAX_VALUE;

        for(int i = 0; i <=amount; i++) {
            for(int coin : coins) {
                if(i+coin <= amount){
                    if(dp[i] == Integer.MAX_VALUE)
                        dp[i] = dp[i+coin];
                    else
                        dp[i+coin] = Math.min(dp[i+coin], dp[i] + 1);
                }
            }
        }

        if(dp[amount] == Integer.MAX_VALUE)
            return -1;
        return dp[amount];
    }
}
