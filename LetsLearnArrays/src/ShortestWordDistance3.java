/**
 * Created by tgulati on 2/18/17.
 */
public class ShortestWordDistance3 {

    public static void main(String[] args) {

        String[] words = new String[]{"practice", "makes", "makes", "perfect", "coding", "better"};
        String[] words2 = new String[]{"a", "c", "b", "d", "c"};
        String word1 = "makes";
        String word2 = "coding";
        String w1 = "c";
        String w2 = "c";
        ShortestWordDistance3 o = new ShortestWordDistance3();

        System.out.println(o.shortestWordDistance(words2, w1, w2));

    }


    public int shortestWordDistance(String[] words, String word1, String word2) {
        if (words == null || words.length == 0) {
            return -1;
        }

        int w1, w2, min;
        w1 = w2 = -1;
        min = Integer.MAX_VALUE;
        boolean isEquals = false;
        if (word1.equals(word2)) {
            isEquals = true;
        }
        for (int i = 0; i < words.length; i++) {
            if (isEquals && word1.equals(words[i])) {
                // check for equal but treat as different words
                min = getMin(i, words, word1, word2);
                return min;
            } else {
                if (word1.equals(words[i])) {
                    w1 = i;
                }
                if (word2.equals(words[i])) {
                    w2 = i;
                }
                if (w1 != -1 && w2 != -1) {
                    min = Math.min(min, Math.abs(w2 - w1));
                }
            }
        }
        return min;
    }

    public int getMin(int index, String[] words, String word1, String word2) {
        int x1, x2;
        x2 = -1;
        x1 = index;
        int min = Integer.MAX_VALUE;
        for (int i = index + 1; i < words.length; i++) {
            if (word1.equals(words[i]) && x1 != x2) {
                x2 = i;
                if (x2 - x1 < min) {
                    min = x2 - x1;
                }
                if (min == 1) {
                    return 1;
                }
                x1 = x2;
                x2 = -1;
            }
        }
        return min;
    }
}
