import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by tgulati on 4/25/16.
 */

public class BalancedParantheses {

    public static void main(String args[]) {

//        System.out.println(balancedParenthensies("{()}"));
//        System.out.println(balancedParenthensies("{(})"));
//        System.out.println(balancedParenthensies("{)(}"));
//        System.out.println(balancedParenthensies("{[}]}"));
        String[] result = Braces(new String[]{"{()}", "{(})", "{)(}", "{[}]}"});
        for (String str : result)
            System.out.println(str);
    }

    public static boolean balancedParenthensies(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[' || c == '(' || c == '{') {
                stack.push(c);
            } else if (c == ']') {
                if (stack.isEmpty())
                    return false;
                if (stack.pop() != '[')
                    return false;

            } else if (c == ')') {
                if (stack.isEmpty())
                    return false;
                if (stack.pop() != '(')
                    return false;

            } else if (c == '}') {
                if (stack.isEmpty())
                    return false;
                if (stack.pop() != '{')
                    return false;
            }
        }
        return stack.isEmpty();
    }

    static String[] Braces(String[] values) {
        String[] result = new String[values.length];
        Stack<Character> stack = new Stack<>();

        System.out.println(values.length);

        for (int j = 0; j < values.length; j++) {
            if (isValidExpression(values[j]))
                result[j] = "YES";
            else
                result[j] = "NO";
        }

//            for (int i = 0; i < values[i].length(); i++) {
//                String s = values[i];
//                char c = s.charAt(i);
//                if (c == '[' || c == '(' || c == '{') {
//                    stack.push(c);
//                } else if (c == ']') {
//                    if (stack.isEmpty()) {
//                        result[j] = "NO";
//                        break;
//                    }
//                    if (stack.pop() != '[') {
//                        result[j] = "NO";
//                        break;
//                    }
//
//                } else if (c == ')') {
//                    if (stack.isEmpty()) {
//                        result[j] = "NO";
//                        break;
//                    }
//                    if (stack.pop() != '(') {
//                        result[j] = "NO";
//                        break;
//                    }
//
//                } else if (c == '}') {
//                    if (stack.isEmpty()) {
//                        result[j] = "NO";
//                        break;
//                    }
//                    if (stack.pop() != '{') {
//                        result[j] = "NO";
//                        break;
//                    }
//                }
//
//            }

        return result;

    }

    private static final char L_PAREN = '(';
    private static final char R_PAREN = ')';
    private static final char L_BRACE = '{';
    private static final char R_BRACE = '}';
    private static final char L_BRACKET = '[';
    private static final char R_BRACKET = ']';


    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(')
                stack.push('(');

            else if (s.charAt(i) == '{')
                stack.push('{');

            else if (s.charAt(i) == '[')
                stack.push('[');

            else if (s.charAt(i) == ')') {
                if (stack.isEmpty())
                    return false;
                if (stack.pop() != '(')
                    return false;
            } else if (s.charAt(i) == '}') {
                if (stack.isEmpty())
                    return false;
                if (stack.pop() != '{')
                    return false;
            } else if (s.charAt(i) == '[') {
                if (stack.isEmpty())
                    return false;
                if (stack.pop() != ']')
                    return false;
            }

        }
        return stack.isEmpty();
    }


    public static boolean isParenthesisMatch(String str) {
        if (str.charAt(0) == '{')
            return false;

        Stack<Character> stack = new Stack<Character>();

        char c;
        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);

            if (c == '(')
                stack.push(c);
            else if (c == '{')
                stack.push(c);
            else if (c == ')')
                if (stack.empty())
                    return false;
                else if (stack.peek() == '(')
                    stack.pop();
                else
                    return false;
            else if (c == '}')
                if (stack.empty())
                    return false;
                else if (stack.peek() == '{')
                    stack.pop();
                else
                    return false;
        }
        return stack.empty();
    }


    public static boolean isValidExpression(String expression) {
        Map<Character, Character> openClosePair = new HashMap<Character, Character>();
        openClosePair.put(')', '(');
        openClosePair.put('}', '{');
        openClosePair.put('[', ']');
        Stack<Character> stack = new Stack<Character>();
        for(char ch : expression.toCharArray()) {
            if(openClosePair.containsKey(ch)) {
                if(stack.pop() != openClosePair.get(ch)) {
                    return false;
                }
            } else if(openClosePair.values().contains(ch)) {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
