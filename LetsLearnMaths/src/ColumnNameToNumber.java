/**
 * Created by tgulati on 1/29/17.
 */
public class ColumnNameToNumber {


    public static void main(String[] args){
        System.out.println(columnNameToInt("AA"));
    }

    public static int columnNameToInt(String str) {
        if(str == null || str.length() == 0)
            throw new IllegalArgumentException("blah blah blah!!");

        int res = 0;
        int i = str.length() - 1
                , t = 0;

        while(i >= 0) {
            char c = str.charAt(i);
            res += Math.pow(26, t) * (c - 'A' + 1);
            t++;
            i--;
        }

        return res;
    }
}
