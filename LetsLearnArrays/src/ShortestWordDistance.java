/**
 * Created by tgulati on 2/18/17.
 */
public class ShortestWordDistance {

    public static void main(String[] args) {

    }

    public int shortestDistance(String[] words, String word1, String word2) {
        if (words == null || words.length < 2) {
            return 0;
        }
        int p1 = -1, p2 = -1, min = Integer.MAX_VALUE;

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1))
                p1 = i;

            if (words[i].equals(word2))
                p2 = i;

            if (p1 != -1 && p2 != -1)
                min = Math.min(min, Math.abs(p1 - p2));
        }

        return min;
    }
}
