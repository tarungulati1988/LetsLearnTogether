import java.util.ArrayList;
import java.util.List;

/**
 * Created by tgulati on 2/15/17.
 */
public class FindAllAnagrams {

    public static void main(String[] args) {
        FindAllAnagrams obj = new FindAllAnagrams();

        List<Integer> result = obj.findAnagrams("cbaedfcbaabccba", "abc");
        for (int i : result) {
            System.out.println(i);
        }
    }


    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (s == null || s.length() == 0 || p == null || p.length() == 0)
            return result;
        if (p.length() > s.length())
            return result;

        int[] map = new int[256];
        for (char c : p.toCharArray()) {
            map[c]++;
        }

        int start = 0;
        int end = 0;
        int size = s.length();
        int count = p.length();
        int pSize = p.length();

        while (end < size) {
            if (map[s.charAt(end)] > 0) {
                count--;
            }

            map[s.charAt(end)]--;
            end++;

            if (count == 0) {
                result.add(start);
            }

            if (end - start == pSize) {
                if(map[s.charAt(start)] >= 0) {
                    count++;
                }
                map[s.charAt(start)]++;
                start++;
            }
        }

        return result;
    }
}
