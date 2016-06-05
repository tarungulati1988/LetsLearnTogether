import java.util.Stack;

/**
 * Created by tgulati on 6/1/16.
 */
public class LargestRectangleHistogram {

    public static void main(String[] args) {

        System.out.println(largestHistogramArea(new int[]{2,1,5,6,2,3}));

    }

    private static int largestHistogramArea(int[] heights) {

        if(heights == null || heights.length == 0)
            return 0;

        int max = 0;
        int i = 0;

        Stack<Integer> stack = new Stack<>();

        while(i < heights.length) {
            if(stack.isEmpty() || heights[i] >= heights[stack.peek()]) {
                stack.push(i);
                i++;
            } else {
                int h = heights[stack.pop()];
                int w = stack.isEmpty()
                        ? i
                        : i - stack.peek() - 1;

                max = Math.max(h * w, max);
            }

        }


        while(!stack.empty()) {
            int h = heights[stack.pop()];
            int w = stack.isEmpty()
                    ? i
                    : i - stack.peek() - 1;

            max = Math.max(h * w, max);
        }
        return max;
    }
}
