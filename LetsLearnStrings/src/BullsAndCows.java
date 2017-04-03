import java.util.List;

/**
 * Created by tgulati on 2/21/17.
 */
public class BullsAndCows {

    public static void main(String[] args) {
        BullsAndCows obj = new BullsAndCows();
        String result = obj.getHint("1234", "0111");
        System.out.println(result);
    }

    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] numbers = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) bulls++;
            else {
                if (numbers[secret.charAt(i) - '0']++ < 0) {
                    cows++;
                }
                if (numbers[guess.charAt(i) - '0']-- > 0) {
                    cows++;

                }
            }
        }
        return bulls + "A" + cows + "B";
    }
}
