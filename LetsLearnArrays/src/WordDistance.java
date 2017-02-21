import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tgulati on 2/18/17.
 */
public class WordDistance {

    private Map<String, List<Integer>> map;

    public static void main(String[] args) {

        String[] words = new String[]{"practice", "makes", "makes", "perfect", "coding", "better"};
        String word1 = "makes";
        String word2 = "coding";
        WordDistance o = new WordDistance(words);

        System.out.println(o.shortest(word1, word2));

    }

    public WordDistance(String[] words) {
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            if (map.containsKey(w)) {
                map.get(w).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(w, list);
            }
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int ret = Integer.MAX_VALUE;
        for (int i = 0, j = 0; i < list1.size() && j < list2.size(); ) {
            int index1 = list1.get(i), index2 = list2.get(j);
            if (Math.abs(index1 - index2) == 1) {
                return 1;
            }
            if (index1 < index2) {
                ret = Math.min(ret, index2 - index1);
                i++;
            } else {
                ret = Math.min(ret, index1 - index2);
                j++;
            }
        }
        return ret;
    }
}