/**
 * Created by tgulati on 6/1/16.
 */
public class FindMin1 {

    public static void main(String[] a) {

        System.out.println(finMinRecursive(new int[]{4,5,6,-1,0,1,2,3}));
        System.out.println(finMinIterative(new int[]{4,5,6,-3,-2,-1,0,1,2,3}));

    }

    private static int finMinIterative(int[] arr) {

        if(arr == null || arr.length == 0)
            return 0;


        return findMinIter(arr, 0, arr.length-1);
    }

    private static int findMinIter(int[] arr, int left, int right) {

        if(left == right)
            return arr[left];

        if(right-left == 1)
            return Math.min(arr[left], arr[right]);

        if(arr[left] < arr[right])
            return arr[left];


        while(left < right) {

            if(right-left == 1)
                return Math.min(arr[left], arr[right]);

            int mid = left + (right-left)/2;
            if(arr[mid] > arr[left]) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return 0;
    }

    private static int finMinRecursive(int[] arr) {

        if(arr == null || arr.length == 0)
            return 0;

        return findMin(arr, 0, arr.length-1);
    }

    private static int findMin(int[] arr, int left, int right) {

        if(left == right)
            return arr[left];

        if(right-left == 1)
            return Math.min(arr[left], arr[right]);

        if(arr[left] < arr[right])
            return arr[left];

        int mid = left + (right-left)/2;


        if(arr[mid] > arr[left])
            return findMin(arr, mid, right);
        else
            return findMin(arr, left, mid);


    }

}
