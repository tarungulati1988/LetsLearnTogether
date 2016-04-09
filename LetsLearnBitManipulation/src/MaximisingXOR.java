import java.util.Scanner;

/**
 * Created by tgulati on 4/9/16.
 */

/**
 * Given two integers, LL and RR, find the maximal value of AA xor BB,
 * where AA and BB satisfy the following condition:
 * L≤A≤B≤RL≤A≤B≤R
 *
 * Input Format
 * The input contains two lines; LL is present in the first line and RR in the second line.
 * Constraints
 * 1≤L≤R≤101≤L≤R≤103
 *
 * Output Format
 * The maximal value as mentioned in the problem statement.
 *
 * Sample input:
 * 10
 * 15
 *
 * Sample output:
 * 7
 */
public class MaximisingXOR {

    private static int maxXor(int l, int r) {
        int max = 0;
        if(l != r) {
            for(int i = l; i <= r; i++) {
                for (int j = i;  j <= r; j++) {
                    if(max < (i ^ j))
                        max = i ^ j;
                }
            }
        }


        return max;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;
        int _l;
        _l = Integer.parseInt(in.nextLine());

        int _r;
        _r = Integer.parseInt(in.nextLine());

        res = maxXor(_l, _r);
        System.out.println(res);

    }
}
