import java.util.HashMap;
import java.util.Map;

/**
 * Created by tgulati on 6/1/16.
 */
public class Isomorphic {

    public static void main(String[] args) {

        System.out.println(areIsomorphic("egg", "foo"));

    }

    private static boolean areIsomorphic(String s1, String s2) {

        if(s1 == null && s2 == null)
            return true;

        if(s1.isEmpty() && s2.isEmpty())
            return true;

        if(s1.length() != s2.length())
            return false;

        Map<Character, Character> map = new HashMap<>();

        for(int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            if(map.containsKey(c1)) {
                if(map.get(c1) != c2)
                    return false;
            } else {
                if (map.containsValue(c2))
                    return false;

                map.put(c1,c2);
            }
        }

        return true;
    }
}
