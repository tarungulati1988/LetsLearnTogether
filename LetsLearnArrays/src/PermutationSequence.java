import java.util.ArrayList;
import java.util.List;

/**
 * Created by tgulati on 2/20/17.
 */
public class PermutationSequence {

    public static void main(String[] args){
        PermutationSequence perm = new PermutationSequence();
        System.out.println(perm.getPermutation(4, 14));
    }

    public String getPermutation(int n, int k) {
        List<Integer> num = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            num.add(i);
        }
        StringBuilder sb = new StringBuilder();
        int[] fact = new int[n + 1];
        int sum = 1;
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
            fact[i] = sum;
        }
        k--; //as the indices as from 0 and not 1
        for (int i = 1; i <= n; i++) {
            int index = k / fact[n - i];
            sb.append(num.get(index));
            num.remove(index);
            k = k - index * fact[n - i];
        }
        return sb.toString();
    }
}
