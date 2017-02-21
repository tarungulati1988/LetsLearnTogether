/**
 * Created by tgulati on 2/18/17.
 */
public class SearchForARange {

    public static void main(String[] args) {
        SearchForARange object = new SearchForARange();

        int[] res = object.searchRange(new int[]{5, 6, 7, 7, 7, 7, 8, 8, 8, 9}, 8);
        System.out.println(res[0] + ", " + res[1]);

        int[] res2 = object.searchRange2(new int[]{5, 6, 7, 7, 7, 7, 8, 8, 8, 9}, 8);
        System.out.println(res2[0] + ", " + res2[1]);
    }


    public int[] searchRange2(int[] nums, int target) {
        int[] arr = new int[2];
        arr[0] = -1;
        arr[1] = -1;
        if (nums == null || nums.length == 0) {
            return arr;
        }

        binarySearch(nums, 0, nums.length - 1, target, arr);

        return arr;
    }

    public void binarySearch(int[] nums, int left, int right, int target, int[] arr) {
        if (right < left)
            return;

        if (nums[left] == nums[right] && nums[left] == target) {
            arr[0] = left;
            arr[1] = right;
            return;
        }

        int mid = left + (right - left) / 2;


        if (nums[mid] < target) {
            binarySearch(nums, mid + 1, right, target, arr);
        } else if (nums[mid] > target) {
            binarySearch(nums, left, mid - 1, target, arr);
        } else {
            arr[0] = mid;
            arr[1] = mid;

            //handle duplicates - left
            int t1 = mid;
            while (t1 > left && nums[t1] == nums[t1 - 1]) {
                t1--;
                arr[0] = t1;
            }

            //handle duplicates - right
            int t2 = mid;
            while (t2 < right && nums[t2] == nums[t2 + 1]) {
                t2++;
                arr[1] = t2;
            }
            return;
        }

    }

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        if (nums == null || nums.length == 0) {
            return res;
        }

        if (nums.length == 1 && nums[0] == target) {
            res[0] = 0;
            return res;
        }

        int n = nums.length - 1;
        int start = 0;
        int end = n;

        // binary search till first occurence found
        // once found then expand on right and left
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                start = mid;
                while (start >= 0 && nums[start] == nums[start - 1]) {
                    start--;
                }
                end = mid;
                while (end <= n && nums[end] == nums[end + 1]) {
                    end++;
                }
                res[0] = start;
                res[1] = end;
                return res;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return res;
    }

}
