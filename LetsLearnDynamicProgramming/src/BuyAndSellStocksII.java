/**
 * Created by tgulati on 1/31/17.
 */
public class BuyAndSellStocksII {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{5,1,2,3,4}));
    }

    public static int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }

        int diff = 0;
        int profit = 0;

        for(int i = 1; i < prices.length; i++) {
            diff = prices[i] - prices[i-1];
            if(diff > 0)
                profit += diff;

            diff = 0;
        }

        return profit;
    }
}
