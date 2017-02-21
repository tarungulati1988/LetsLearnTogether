import java.util.Stack;

/**
 * Created by tgulati on 2/12/17.
 */
public class LargestAreaRectangle {

    public static void main (String[] args) {
        System.out.println(area(new int[]{2,1,5,6,4,3,2}));

    }


    public static int area(int[] h) {

        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int max = Integer.MIN_VALUE;
        while (i < h.length) {
            if(stack.isEmpty() || h[i] > h[stack.peek()]) {
                stack.push(i);
                i++;
            } else {
                int index = stack.pop();
                int height = h[index];
                int width = stack.empty()
                        ? i
                        : i - stack.peek() - 1;
                max = Math.max(max, height*width);
            }
        }

        while (!stack.isEmpty()) {
            int index = stack.pop();
            int height = h[index];
            int width = stack.empty()
                    ? i
                    : i - stack.peek() - 1;
            max = Math.max(max, height*width);
        }

        return max;
    }
}
