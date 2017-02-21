import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tgulati on 2/16/17.
 */
public class LetterCombinations {


    public static HashMap<Character, char[]> map = new HashMap<Character, char[]>();

    static {
        map.put('2', new char[]{'a','b','c'});
        map.put('3', new char[]{'d','e','f'});
        map.put('4', new char[]{'g','h','i'});
        map.put('5', new char[]{'j','k','l'});
        map.put('6', new char[]{'m','n','o'});
        map.put('7', new char[]{'p','q','r','s'});
        map.put('8', new char[]{'t','u','v'});
        map.put('9', new char[]{'w','x','y','z'});
    }


    public static void main(String[] args) {
        LetterCombinations obj = new LetterCombinations();
        List<String> res = new ArrayList<>();
        res = obj.letterCombinations("23");
        for(String str : res) {
            System.out.println(str);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits == null || digits.length() == 0) {
            return result;
        }
        StringBuilder sb = new StringBuilder();
        getCombinations(result, sb, 0, digits);
        return result;
    }

    public void getCombinations(List<String> res, StringBuilder sb, int index, String num) {
        // break case/base case
        if(index >= num.length()) {
            res.add(sb.toString());
            return;
        }
        // 1. pick the integer at index position, get corresponding array of characters for it
        char c = num.charAt(index);
        char[] arr = map.get(c);

        // 2. loop over the characters and append the char at ith position,
        // recursively call the same method but pass index of the next integer in the number
        // 3. finally remove the last character added or else the appends will contain all the combinations
        for(int i=0; i< arr.length;i++) {
            sb.append(arr[i]);
            getCombinations(res, sb, index+1, num);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
