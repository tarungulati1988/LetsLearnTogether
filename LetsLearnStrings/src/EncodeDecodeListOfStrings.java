import java.util.ArrayList;
import java.util.List;

/**
 * Created by tgulati on 2/25/17.
 */
public class EncodeDecodeListOfStrings {

    public String encode(List<String> strs) {
        if (strs == null || strs.size() == 0) {
            return "";
        }
        StringBuilder str = new StringBuilder();

        for (String s : strs) {
            str.append(s.length()).append("|").append(s);
        }

        return str.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> strs = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int delimiter = s.indexOf('|', i);
            int length = Integer.valueOf(s.substring(i, delimiter));
            strs.add(s.substring(delimiter + 1, delimiter + length + 1));
            i = delimiter + length + 1;
        }
        return strs;
    }
}
