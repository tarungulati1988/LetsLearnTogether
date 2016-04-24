import java.util.ArrayList;
import java.util.List;

/**
 * Created by tgulati on 4/17/16.
 */
public class PowerSet {

    public static void main(String[] args) {
        String[] arr = new String[]{"a", "b", "c"};
        List<String> powerSet = generatePowerSets(arr);
        System.out.println(powerSet);
    }

    private static List<String> generatePowerSets(String[] arr) {
        int size = (int) (Math.floor(Math.pow(2, arr.length)));
        List<String> result = new ArrayList<String>();
        // iterate from 000.. till 111..1
        for (int i = 0; i < size; i++) {
            String temp = "";
            for (int j = 0; j < arr.length; j++) {
                // check if the jth bit in i is set, eg: 001 = c
                // if set then append it to the temp string
                if ((i & (1 << j)) != 0) {
                    temp += arr[j];
                }
            }
            result.add(temp);
        }

        return result;
    }
}
