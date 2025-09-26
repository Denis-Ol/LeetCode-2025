package others;

import java.util.Arrays;

public class OraclePrimes {
    private static boolean isPrime(int num) {

        for (int i = 2; i < num; i++) { // 2 < 1 - false, 2 < 2 - false, num = 3, 2 < 3 ; 3 < 3 - false
            if (num % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] primes = new int[100];
        int j = 1;
        for (int i = 0; i < 100; ) {

            while (!isPrime(j)) {
                j++;
            }

            primes[i] = j;
            i++;
            j++;

        }
        System.out.println("primes = " + Arrays.toString(primes));
    }
}
