import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by tgulati on 4/9/16.
 */

/**
 * Sid is obsessed with reading short stories. Being a CS student,
 * he is doing some interesting frequency analysis with the books.
 * He chooses strings S1S1 and S2S2 in such a way that |len(S1)−len(S2)|≤1|len(S1)−len(S2)|≤1.
 * Your task is to help him find the minimum number of characters of the
 * first string he needs to change to enable him to make it an anagram of the second string.
 * Note: A word x is an anagram of another word y if we can produce y by rearranging the letters of x.
 *
 * Input Format
 * The first line will contain an integer, TT, representing the number of test cases.
 * Each test case will contain a string having length len(S1)+len(S2)len(S1)+len(S2),
 * which will be concatenation of both the strings described above in the problem.
 * The given string will contain only characters from aa to zz.
 *
 * Output Format
 * An integer corresponding to each test case is printed in a different line, i.e.
 * the number of changes required for each test case. Print −1−1 if it is not possible.
 *
 * Sample input:
 * 6
 * aaabbb
 * ab
 * abc
 * mnop
 * xyyx
 * xaxbbbxx
 *
 * Sample output:
 * 3
 * 1
 * -1
 * 2
 * 0
 * 1
 *
 */
public class Anagram {

    private static final byte ALPHABET_LENGTH = 26;
    private static final byte ASCII_ALPHABET_OFFSET = 97;

    public static void main(String[] args) throws IOException {

        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(byte T = Byte.parseByte(br.readLine()); T > 0; --T){
            short numChanges = -1;
            char[] ab = br.readLine().toCharArray();
            short max = (short)ab.length;
            if((max & 1) == 0){
                numChanges = 0;
                short mid = (short)(max >> 1);
                short[] map = new short[ALPHABET_LENGTH];
                for(short i = mid; i < max; map[ab[i++] - ASCII_ALPHABET_OFFSET]++){}
                for(short i = 0; i < mid; numChanges += (map[ab[i++] - ASCII_ALPHABET_OFFSET]-- > 0) ? 0 : 1){}
            }
            sb.append(numChanges + "\n");
        }
        System.out.print(sb);
    }
}
