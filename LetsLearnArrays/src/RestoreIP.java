import java.util.ArrayList;
import java.util.List;

/**
 * Created by tgulati on 2/21/17.
 */
public class RestoreIP {

    public static void main(String[] args) {
        RestoreIP obj = new RestoreIP();
        List<String> result = obj.restoreIpAddresses("0000");
        for (String str : result) {
            System.out.println(str);
        }
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        backtrack(result, s, 0, new String(), 1);
        return result;
    }

    public void backtrack(List<String> result, String s, int index, String str, int count) {
        if (index >= s.length() & str.length() == s.length()) {
            result.add(str);
            str = new String();
            return;
        }
        for (int i = index; i < s.length(); i++) {
            // if(count > 3) {
            //     count =0;
            // }
            // count++;
            // if(count == 2 || count == 3) {
            //     str = str + ".";
            // } else {
            str = str + s.charAt(i);
            // }
            backtrack(result, s, i + 1, str, count);
            str = str.substring(0, str.length() - 1);
        }
    }
}
