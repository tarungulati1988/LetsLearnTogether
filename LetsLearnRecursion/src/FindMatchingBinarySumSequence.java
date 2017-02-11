/**
 * Created by tgulati on 8/13/16.
 */
public class FindMatchingBinarySumSequence {
    public static void main(String args[]) {
        // input number
        int n = 2;

        // allocate string contaning 2*n characters
        int size = 2 * n + 1;
        char[] out = new char[size];

        findAllSequences(0, out, 0, 2*n - 1);

    }

    private static void findAllSequences(int diff, char[] out, int start, int end) {

        if (Math.abs(diff) > (end - start + 1) / 2)
            return;

        // if all bits are filled
        if (start > end)
        {
            // if sum of first n bits and last n bits are same
            if (diff == 0)
                print(out);
            return;
        }

        // fill first bit as 0 and last bit as 1
        out[start] = '0'; out[end] = '1';
        findAllSequences(diff + 1, out, start + 1, end - 1);

        // fill first and last bits as 1
        out[start] = out[end] = '1';
        findAllSequences(diff, out, start + 1, end - 1);

        // fill first and last bits as 0
        out[start] = out[end] = '0';
        findAllSequences(diff, out, start + 1, end - 1);

        // fill first bit as 1 and last bit as 0
        out[start] = '1'; out[end] = '0';
        findAllSequences(diff - 1, out, start + 1, end - 1);
    }

    private static void print(char[] out) {
        for(char c : out) {
            System.out.print(c);
        }
        System.out.println("----------");
    }

}
