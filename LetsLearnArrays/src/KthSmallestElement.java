import java.util.PriorityQueue;

/**
 * Created by tgulati on 4/17/16.
 */

/**
 *  Given an array of inte­gers. find the Kth Smallest/largest ele­ment in the array.
 *  Example:
 *  int[] A = { 1, 2, 10, 20, 40, 32, 44, 51, 6 };
 *  K=4. 4th smallest element in given array: 10
 */
public class KthSmallestElement {

    public static int find(int [] arr, int j){
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i = 0; i < arr.length ; i++){
            pq.offer(arr[i]);
        }
        int n = -1;
        while(j > 0){
            n = pq.poll();
            j--;
        }
        return n;
    }
    public static void main(String[] args) {
        int[] arr = { 1, 2, 10, 20, 40, 32, 44, 51, 6 };

        System.out.println("4th smallest element:" + find(arr, 6));

    }
}
