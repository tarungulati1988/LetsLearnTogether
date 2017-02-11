/**
 * Created by tgulati on 1/28/17.
 */
public class CountPrimes {

    public static void main(String[] args) {
        System.out.println(countPrimes(10));
    }

    public static int countPrimes(int n) {
        if (n <= 2)
            return 0;

        // init an array to track prime numbers
        boolean[] primes = new boolean[n];
        for (int i = 2; i < n; i++)
            primes[i] = true;

//        for (int i = 2; i <= Math.sqrt(n - 1); i++) {
            // or for (int i = 2; i <= n-1; i++) {
        for (int i = 2; i <= n-1; i++) {
            if (primes[i]) {
                for (int j = 2*i; j < n; j += i)
                    primes[j] = false;
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (primes[i])
                count++;
        }

        return count;
    }
}
