/**
 * Created by tgulati on 4/9/16.
 */

import java.util.Stack;

/**
 * Given n non-negative integers representing the histogram’s bar height where the
 * width of each bar is 1, find the area of largest rectangle in the histogram.
 */
public class LargestRectangleHistogram {

    public static void main(String[] args) {
        System.out.println(largestHistogram(new int[]{2, 1, 5, 7, 6, 2, 3}));
    }

    private static int largestHistogram(int[] height) {
        if(height.length == 0)
            return 0;

        Stack<Integer> stack = new Stack<Integer>();
        int max = 0,
                i = 0;

        // iterate over the complete stack
        while(i < height.length) {

            // now push the "index" of each histogram
            // when the height is greater than the pervious
            if(stack.isEmpty() || height[i] > height[stack.peek()]) {
                stack.push(i);
                i++;
            } else {
                // if the height of the current histogram isn't
                // greater than the pervious one, then calculate
                // the maximum using the formula:
                // height = height of top of stack
                // width = if empty stack then "i", else
                // i - stack.peek()+1
                // max = max of Height*width or max

                int heightValue = height[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(heightValue * width, max);
            }
        }

        while(!stack.isEmpty()) {
            int heightValue = height[stack.pop()];
            int width = stack.isEmpty() ? i : i - stack.peek() - 1;
            max = Math.max(heightValue * width, max);
        }

        return max;
    }
}
