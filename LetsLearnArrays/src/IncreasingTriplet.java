/**
 * Created by tgulati on 2/13/17.
 */
public class IncreasingTriplet {

    public static void main(String[] args) {
        System.out.println(isItIncreasing(new int[]{1,2,3,4,5}));
        System.out.println(isItIncreasing(new int[]{5,4,3,2,1}));
        System.out.println(isItIncreasing(new int[]{1,2,5,4,6}));

    }

    public static boolean isItIncreasing(int[] nums) {
        int x = Integer.MAX_VALUE;
        int y = Integer.MAX_VALUE;
        for (int i : nums) {
            int z = i;
            if (x >= z ) {
                x = z;
            } else if(y >= z) {
                y = z;
            } else {
                return true;
            }
        }
        return false;
    }
}
