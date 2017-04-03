import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by tgulati on 2/26/17.
 */
public class GroupShiftedStrings {

    public static void main(String[] args) {
        GroupShiftedStrings object = new GroupShiftedStrings();
        List<List<String>> result = object.groupStrings(new String[]{"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"});


    }

    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result = new ArrayList<>();
        if (strings == null || strings.length == 0) {
            return result;
        }
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for (String s : strings) {
            String key = "";
            for (int i = 1; i < s.length(); i++) {
                key += Integer.toString((s.charAt(i) - s.charAt(i - 1) + 26) % 26) + ",";
// 			key += String.format("%2d", (s.charAt(i) - s.charAt(i-1) + 26) % 26);
            }
            if (key.length() > 0) {
                key = key.substring(0, key.length() - 1);
            }
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
