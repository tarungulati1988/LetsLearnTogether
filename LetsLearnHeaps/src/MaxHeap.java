/**
 * Created by tgulati on 4/17/16.
 */

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Implementation of max heap using priority queues
 */
public class MaxHeap {

    PriorityQueue<Integer> pq;

    public MaxHeap() {
        pq = new PriorityQueue<Integer>(10, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
    }

    public void insert(int[] x) {
        for (int i = 0; i < x.length; i++) {
            pq.offer(x[i]);
        }
    }

    public int extractMax() {
        return pq.poll();
    }

    public int getSize() {
        return pq.size();
    }

    public void print() {
        System.out.println(pq);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 6, 2, 9, 4, 3, 8 };
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.insert(arr);
        maxHeap.print();
        System.out.println("Max: " + maxHeap.extractMax());
        maxHeap.print();
        System.out.println("Max: " + maxHeap.extractMax());
        maxHeap.print();
        System.out.println("Max: " + maxHeap.extractMax());
        System.out.println("Priority Queue Size: " + maxHeap.getSize());
    }
}
