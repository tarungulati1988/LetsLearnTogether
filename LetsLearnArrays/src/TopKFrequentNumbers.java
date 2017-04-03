import java.util.*;

/**
 * Created by tgulati on 2/21/17.
 */
public class TopKFrequentNumbers {


    public class Node {
        int key;
        int freq;

        public Node(int key, int freq) {
            this.key = key;
            this.freq = freq;
        }
    }


    public static void main(String[] args) {
        TopKFrequentNumbers obj = new TopKFrequentNumbers();
        List<Integer> result = obj.topKFrequent(new int[]{1,1,1,1,4,5,6,6,6,7,8,7,7}, 3);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        Map<Integer, Node> map = new HashMap<>();
        PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> a.freq - b.freq);


        for (int n : nums) {
            Node temp;
            if (map.containsKey(n)) {
                temp = map.get(n);
                temp.freq = temp.freq + 1;
                map.put(n, temp);
            } else {
                temp = new Node(n, 1);
                map.put(n, temp);
            }
        }

        for (Map.Entry<Integer, Node> entry : map.entrySet()) {
            queue.offer(entry.getValue());
            if (queue.size() > k) {
                queue.poll();
            }
        }

        while (!queue.isEmpty()) {
            Node x = queue.poll();
            result.add(0, x.key);
        }

        return result;
    }
}
