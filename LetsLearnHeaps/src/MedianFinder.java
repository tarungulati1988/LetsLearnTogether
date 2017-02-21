import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by tgulati on 2/12/17.
 */
public class MedianFinder {

    public static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    public static PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public static void main(String[] args) {
        addNum(6);
        addNum(10);
        addNum(12);
        addNum(7);
        addNum(8);
        addNum(9);
        addNum(13);
        addNum(16);
        addNum(14);
        addNum(5);
        System.out.println(findMedian());

    }


    public static void addNum(int num) {

        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());

        if(maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }

    }

    public static int findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek())/2;
        } else {
            return maxHeap.peek();
        }
    }

}
