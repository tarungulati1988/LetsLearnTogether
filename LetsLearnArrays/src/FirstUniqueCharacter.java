/**
 * Created by tgulati on 2/15/17.
 */
public class FirstUniqueCharacter {

    public static void main(String[] args) {
        System.out.println(firstUniqChar("loveleetcode"));
        System.out.println(firstUniqChar("leetcode"));
    }

    public static int firstUniqChar(String s) {
        if(s == null || s.length() == 0){
            return -1;
        }
        int[] ascii = new int[26];
        for(char c : s.toCharArray()) {
            ascii[c - 'a']++;
        }

        for(char c : s.toCharArray()) {
            if(ascii[c - 'a'] == 1) {
                return s.indexOf(c);
            }
        }

        return -1;
    }
}
