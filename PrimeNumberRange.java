//package forTesting;
import java.util.Arrays;
import java.util.Scanner;

public class PrimeNumberRange {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the range (start and end): ");
        int start = scan.nextInt();
        int end = scan.nextInt();
        scan.close();
        long startTime = System.currentTimeMillis();

        boolean[] primes = isPrime(end);
        for (int i = start; i <= end; i++) {
            if (primes[i]) {
                System.out.println(i + " ");
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time elapsed in ms: "+(endTime-startTime));
    }

    public static boolean[] isPrime(int n) {
        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (primes[i]) {
                for (int j = i * i; j <= n; j += i) {
                    primes[j] = false;
                }
            }
        }

        return primes;
    }
}
