import java.util.PriorityQueue;

/**
 * Created by tgulati on 2/12/17.
 */
public class FindKthLargest {

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3, 2, 1, 5, 6, 4, 7, 8}, 2));
        System.out.println(findKthLargest2(new int[]{3, 2, 1, 5, 6, 4, 7, 8}, 2));
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i : nums) {
            q.offer(i);

            if (q.size() > k) {
                q.poll();
            }
        }

        return q.peek();
    }

    public static int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i : nums) {
            q.offer(i);
        }

        while (q.size() > k) {
            q.poll();
        }

        return q.peek();
    }
}
