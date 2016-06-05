/**
 * Created by tgulati on 5/8/16.
 */
public class IsValidGirl {

    public static void main(String[] args) {

        int[] matchArr = new int[]{3,7,9,11};
        System.out.println(isMatch(7, matchArr));

    }

    public static boolean isMatch(int id, int[] matchArr) {
        if(matchArr.length == 0)
            return true;

        return search(id, matchArr, matchArr.length-1);
//        int mid = matchArr.length/2;
//
//        int left = search(id, matchArr, 0, )
//
//        return true;
    }

    private static boolean search(int id, int[] matchArr, int i1) {

        int low = 0;
        int high = matchArr.length - 1;

        while(high >= low) {
            int middle = (low + high) / 2;
            if(matchArr[middle] == id) {
                return false;
                }
            if(matchArr[middle] < id) {
                low = middle + 1;
                }
            if(matchArr[middle] > id) {
                high = middle - 1;
                }
            }
        return true;

    }
}
