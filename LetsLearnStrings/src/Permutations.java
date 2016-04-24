import java.util.ArrayList;

/**
 * Created by tgulati on 4/24/16.
 */
public class Permutations {

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        System.out.println(permutations.getPermutations("abcdef"));
    }

    private ArrayList<String> getPermutations(String str) {
        // base case, null string
        if(str == null)
            return null;

        ArrayList<String> permutations = new ArrayList<>();

        // base case, empty string
        if(str.length() == 0) {
            permutations.add("");
            return permutations;
        }

        // other cases
        char first = str.charAt(0);
        String remainingWord = str.substring(1);
        ArrayList<String> words = getPermutations(remainingWord);

        for(String word : words) {
            for(int i  = 0; i < word.length(); i++) {
                permutations.add(insertChar(word, first, i));
            }
        }

        return permutations;
    }

    private String insertChar(String word, char first, int i) {
        String start = word.substring(0, i);
        String end = word.substring(i);
        return start + first + end;
    }
}
