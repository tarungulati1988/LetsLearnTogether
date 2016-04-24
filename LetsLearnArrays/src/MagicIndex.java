/**
 * Created by tgulati on 4/24/16.
 */
public class MagicIndex {

    public static void main(String[] args) {
        MagicIndex magicIndex = new MagicIndex();
        int[] num = new int[]{-10, -5, 0, 2, 2, 3, 4, 7, 9, 12, 13};
        System.out.println(magicIndex.magicNumber(num, 0, num.length-1));
    }

    private int magicNumber(int[] arr, int start, int end) {

        if( end < start || start < 0 || end > arr.length )
            return -1;

        int midIndex = (start + end)/2;
        int mid = arr[midIndex];

        if(mid == midIndex)
            return mid;

        int leftIndex = Math.min(midIndex - 1, mid);
        int left = magicNumber(arr, start, leftIndex);
        if(left >= 0)
            return left;

        int rightIndex = Math.max(midIndex + 1, mid);
        int right = magicNumber(arr, rightIndex, end);

        return right;
    }
}
