import java.util.Collections;

/**
 * Created by tgulati on 6/1/16.
 */
public class ReverseArray {

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,7};
        rotate(arr, 2);

        for(int i : arr) {
            System.out.print(i + "  ");
        }

    }

    private static void rotate(int[] arr, int order) {
        if(arr == null || arr.length == 0 || order < 0)
            return;

        if(order > arr.length)
            return;

        int pos = arr.length - order;

        reverse(arr, 0, pos-1);
        reverse(arr, pos, arr.length-1);
        reverse(arr, 0, arr.length-1);

    }


    private static void reverse(int[] arr, int left, int right) {

        if(arr == null || arr.length == 1)
            return;

        while(left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }

    }
}
