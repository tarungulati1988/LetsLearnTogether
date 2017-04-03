/**
 * Created by tgulati on 3/6/17.
 */
public class PaintFences {

    public int numWays(int n, int k) {
        if(n == 0 || k == 0) {
            return 0;
        }
        if(n == 1) {
            return k;
        }

        // first two posts
        int sameColor = k;
        int differentColor = (k)*(k-1);
        for(int i = 2; i < n; i++) {
            int temp = differentColor;
            differentColor = (differentColor + sameColor) * (k-1);
            sameColor = temp;
        }

        return sameColor+differentColor;
    }
}
