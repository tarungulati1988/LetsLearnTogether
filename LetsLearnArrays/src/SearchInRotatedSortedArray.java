/**
 * Created by tgulati on 2/18/17.
 */
public class SearchInRotatedSortedArray {

    public static void main(String[] args) {

        SearchInRotatedSortedArray obj = new SearchInRotatedSortedArray();
        System.out.println(obj.search(new int[]{6,7,8,9,0,1,2,3,4}, 3));
    }


    public int search(int[] nums, int target) {
        // O(N) iterate and find
        // O(NLOGN) sort and binary search
        // O(logN) binary search
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid])
                return mid;

            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
