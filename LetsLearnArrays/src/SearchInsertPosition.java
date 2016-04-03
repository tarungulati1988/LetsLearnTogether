/**
 * Created by tgulati on 4/3/16.
 */

/**
 * Given a sorted array and a target value, return the index if the target is found. If
 * not, return the index where it would be if it were inserted in order. You may assume
 * no duplicates in the array.
 *
 * eg:
 * [1,3,5,6], 5 -> 2
 * [1,3,5,6], 2 -> 1
 * [1,3,5,6], 7 -> 4
 * [1,3,5,6], 0 -> 0
 * O(log n)
 */
public class SearchInsertPosition {

    public static void main(String[] args) {
        System.out.println(searchInsertPosition(new int[]{1, 3, 5, 6}, 5));
        System.out.println(searchInsertPosition(new int[]{1, 3, 5, 6}, 2));
        System.out.println(searchInsertPosition(new int[]{1, 3, 5, 6}, 7));
        System.out.println(searchInsertPosition(new int[]{1, 3, 5, 6}, 0));
        System.out.println(searchInsertPosition(new int[]{1, 3, 5, 6}, 11));
        System.out.println(searchInsertPosition(new int[]{1, 3, 5, 6}, -1));
    }

    public static int searchInsertPosition(int[] A, int target) {
        if(A == null || A.length == 0)
            return 0;
        return searchInsertPosition(A, target, 0, A.length-1);
    }
    public static int searchInsertPosition(int[] A, int target, int start, int end){
        int mid = (start+end)/2;
        if(target == A[mid])
            return mid;
        else if(target < A[mid])
            return start < mid ? searchInsertPosition(A,target,start,mid-1) : start;
        else
            return end > mid ? searchInsertPosition(A,target,mid+1,end) : (end+1);
    }



}
