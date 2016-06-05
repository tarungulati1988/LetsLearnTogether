import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by tgulati on 6/1/16.
 */
public class LargestNumber {


    public static void main(String[] args) {

        System.out.println(getLargestNumber(new int[]{30, 31, 12, 9, 5}));

    }

    private static String getLargestNumber(int[] arr) {

        if(arr == null || arr.length == 0)
            return null;

        String[] str = new String[arr.length];

        int c = 0;

        for(int i : arr) {
            str[c] = String.valueOf(i);
            c++;
        }

        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String l2r = o1.concat(o2);
                String r2l = o2.concat(o1);

                return r2l.compareTo(l2r);
            }
        });

        StringBuilder stringBuilder = new StringBuilder();
        for(String s : str) {
            stringBuilder.append(s);
        }


        return stringBuilder.toString();
    }
}
