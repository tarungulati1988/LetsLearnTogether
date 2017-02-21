import java.util.HashMap;

/**
 * Created by tgulati on 2/16/17.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcdccbb"));
        System.out.println(lengthOfLongestSubstring("abcacbcbbc"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.length()==0) {
            return 0;
        }
        int max = 0;
        int j = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i =0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                j = Math.max(j, map.get(c) + 1);
            }

            map.put(c, i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }
}
