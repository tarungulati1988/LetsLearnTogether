/**
 * Created by tgulati on 1/31/17.
 */
public class BuyAndSellStocksI {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{2,3,1,1,4}));
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;

        int min = prices[0];
        int res = 0;

        for (int i : prices) {
            res = Math.max(res, i - min);
            min = Math.min(i, min);
        }

        return res;
    }
}
