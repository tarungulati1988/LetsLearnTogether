/**
 * Created by tgulati on 4/3/16.
 */

import java.util.HashMap;
import java.util.Stack;

/**
 * Given a string containing just the characters ’(’, ’)’, ’’, ’’, ’[’ and ’]’, determine if the
 * input string is valid. The brackets must close in the correct order, "()" and "()[]" are all
 * valid but "(]" and "([)]" are not.
 */
public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(isValid("(())"));
        System.out.println(isValid("())]]"));
        System.out.println(isValid("(({}{{))}}"));
        System.out.println(isValid("{[()]}"));
    }

    public static boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (map.containsKey(curr)) {
                stack.push(curr);
            } else if (map.containsValue(curr)) {
                if (!stack.empty() && map.get(stack.peek()) == curr) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
