import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by tgulati on 4/9/16.
 */

/**
 * Roy wanted to increase his typing speed for programming contests.
 * So, his friend advised him to type the sentence "The quick brown fox jumps over the lazy dog" repeatedly,
 * because it is a pangram. (Pangrams are sentences constructed by using every letter of the alphabet at least once.)
 * After typing the sentence several times, Roy became bored with it. So he started to look for other pangrams.
 * Given a sentence ss, tell Roy if it is a pangram or not.
 * Input Format
 * Input consists of a string ss.
 * Constraints
 * Length of ss can be at most 103103 (1≤|s|≤103)(1≤|s|≤103) and it may contain spaces,
 * lower case and upper case letters. Lower-case and upper-case instances of a letter are considered the same.
 * Output Format
 * Output a line containing pangram if ss is a pangram, otherwise output not pangram.
 *
 * From hackerrank profile
 */
public class Panagram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String stringToCheck = scanner.nextLine();
        Set<Character> lettersRemaining = new HashSet<Character>();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            lettersRemaining.add(ch);
        }
        stringToCheck = stringToCheck.toLowerCase();
        for(int i = 0; i < stringToCheck.length(); i++) {
            if(stringToCheck.charAt(i) != ' ')
                lettersRemaining.remove(stringToCheck.charAt(i));
        }
        if(lettersRemaining.size() == 0)
            System.out.println("pangram");
        else
            System.out.println("not pangram");
    }
}
