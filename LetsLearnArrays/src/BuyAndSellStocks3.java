/**
 * Created by tgulati on 2/28/17.
 */
public class BuyAndSellStocks3 {


    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int[] leftProfit = new int[prices.length];
        int[] rightProfit = new int[prices.length];

        // calculate left profit
        int min = prices[0];
        leftProfit[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            leftProfit[i] = Math.max(leftProfit[i - 1], prices[i] - min);
        }

        // caculate right profit
        int max = prices[prices.length - 1];
        rightProfit[prices.length - 1] = 0;
        for (int i = prices.length - 2; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            rightProfit[i] = Math.max(rightProfit[i + 1], max - prices[i]);
        }
        // now calculate the maximum profit buy adding at ith element
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, leftProfit[i] + rightProfit[i]);
        }

        return maxProfit;
    }
}
