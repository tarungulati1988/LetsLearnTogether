import java.util.HashMap;
import java.util.Map;

/**
 * Created by tgulati on 5/31/16.
 */

/**
 * Given a string, find the longest substring that contains only
 * k unique characters. For example, given "abcbbbbcccbdddadacb",
 * the longest substring that containing k(k=2) unique character is "bcbbbbcccb".
 */
public class LengthOfLongestSubstringDistinct {

    public static void main (String[] args) {

        System.out.println(longestSubstringKDistinct("abcadcacacaca", 2));

    }

    public static int longestSubstringKDistinct(String str, int k) {
        if(str == null || str.isEmpty())
            return 0;

        Map<Character, Integer> map = new HashMap<>();

        int start = 0;
        int max = 0;

        for (int i = 0 ; i < str.length(); i++) {
            char c = str.charAt(i);

            if(map.containsKey(c)) {
                map.put(c, map.get(c)+1);
            } else {
                map.put(c, 1);
            }

            if(map.size() > k) {

                max = Math.max(max, i - start);
                while(map.size() > k) {
                    char temp = str.charAt(start);
                    int count = map.get(temp);

                    if(count > 1) {
                        map.put(temp, count - 1);
                    } else {
                        map.remove(temp);
                    }

                    start++;
                }
            }
        }

        max = Math.max(max, str.length() - start);

        return max;

    }
}
