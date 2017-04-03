import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by tgulati on 2/26/17.
 */
public class SimplifyPath {

    public static void main(String[] args) {
        SimplifyPath object = new SimplifyPath();
        System.out.println(object.simplifyPath("/a/b/./.././c/d/././e/./home/"));
    }

    public String simplifyPath(String path) {
        if(path == null || path.length() == 0) {
            return "";
        }
        Set<String> set = new HashSet<>();
        set.add(".");
        set.add("..");
        set.add("");
        Stack<String> stack = new Stack<>();

        for(String s : path.split("/")) {
            if (s.equals("..") && !stack.isEmpty()) {
                stack.pop();
            } else if (!set.contains(s)) {
                stack.push(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(String s : stack) {
            sb.append("/").append(s);
        }
        return sb.toString().length() == 0 ? "/" : sb.toString();
    }
}
