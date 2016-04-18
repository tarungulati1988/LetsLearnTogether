/**
 * Created by tgulati on 4/17/16.
 */
public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibonacciDP(8));
        System.out.println(fibonacciRecursive(8));
    }

    public static int fibonacciDP(int n) {
        int fib[] = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
            System.out.println(fib[i]);
        }
        return fib[n];
    }

    public static int fibonacciRecursive(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        else {
            int fib = fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
            return fib;
        }

    }
}
