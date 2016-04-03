/**
 * Created by tgulati on 4/3/16.
 */

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters
 * and ignoring cases.
 * For example, "Red rum, sir, is murder" is a palindrome, while "Programcreek is
 * awesome" is not.
 * Remove all " " and the have two pointers and iterate over
 */
public class ValidPalindrome {

    public static void main(String[] args) {
        System.out.println(isValidPalindrome("Red rum, sir, is murder"));
        System.out.println(isValidPalindrome("Programming is awesome"));
    }

    public static boolean isValidPalindrome(String s){
        if(s == null || s.length() == 0)
            return false;
        // regex to replace all special characters other than alphabets and numbers
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        // System.out.println(s);

        for(int i = 0; i < s.length() ; i++) {
            if(s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

}
