/**
 * Created by tgulati on 1/11/17.
 */
public class IsomorphicStrings {

    public static void main(String[] a) {
        System.out.println(isIsomorphic("egg", "abd"));
    }


    public static boolean isIsomorphic(String a, String b) {
        if (a == null || b == null || a.length() != b.length())
            return false;

        char[] arr = new char[26];


        for (int i = 0; i < a.length(); i++) {
            char c1 = a.charAt(i);
            char c2 = b.charAt(i);
            int index = c1 - 'a';

            if (arr[index] == c2 ) {
                continue;
            } else if (arr[index] != c2 && arr[index] != '\u0000'){
                return false;
            } else {
                arr[index] = c2;
            }

        }

        return true;
    }
}
