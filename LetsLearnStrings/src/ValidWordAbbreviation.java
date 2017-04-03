/**
 * Created by tgulati on 3/7/17.
 */
public class ValidWordAbbreviation {
    // apple and a2le

    public boolean validWordAbbreviation(String word, String abbr) {
        if (word == null || abbr == null || word.length() == 0 || abbr.length() == 0) {
            return false;
        }
        if (abbr.length() > word.length()) {
            return false;
        }
        int j = 0;
        int i = 0;
        for (i = 0; i < word.length() && j < abbr.length(); i++) {
            if (word.charAt(i) == abbr.charAt(j)) {
                j++;
                continue;
            }

            if (abbr.charAt(j) <= '0' || abbr.charAt(j) > '9') {
                return false;
            }

            int start = j;
            while (j < abbr.length() && abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9') {
                ++j;
            }
            int num = Integer.valueOf(abbr.substring(start, j));
            i += num - 1;
        }
        return i == word.length() && j == abbr.length();
    }
}
