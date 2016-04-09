import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by tgulati on 4/9/16.
 */

/**
 * You are given two strings, AA and BB. Find if there is a substring that appears in both AA and BB
 *
 * Sample input:
 * 2
 * hello
 * world
 * hi
 * world
 *
 * Sample output:
 * YES
 * NO
 */
public class TwoStrings {

    public static void main(String[] args) throws IOException, IOException {

        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //For each test case
        for(byte T = Byte.parseByte(br.readLine()); T > 0; --T){

            //Get strings
            final char[] A = br.readLine().toCharArray();
            final char[] B = br.readLine().toCharArray();

            //Check if both strings share a common substring
            sb.append(hasSubstring(A, B) ? "YES\n" : "NO\n");
        }
        System.out.print(sb);
    }

    private static boolean hasSubstring(final char[] A, final char[] B){

        //Get presence of letters in string A
        int bitsA = 0;
        for(int i = 0, n = A.length; i < n; bitsA |= 1 << (A[i++] - 'a')){}

        //Get presence of letters in string B
        int bitsB = 0;
        for(int i = 0, n = B.length; i < n; bitsB |= 1 << (B[i++] - 'a')){}

        //Check if both strings have any letters in common
        return (bitsA & bitsB) != 0;
    }
}
