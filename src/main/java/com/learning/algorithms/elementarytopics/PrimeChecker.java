package com.learning.algorithms.elementarytopics;

public class PrimeChecker {

    public static boolean isPrime(int n) {
        if (n <= 1)
            return false;
        int divisor = 2;
        while (divisor <= n / divisor) {
            if (n % divisor == 0)
                return false;
            divisor++;
        }
        return true;
    }

    public static boolean isPrimeOptimizedDiv(int n) {
        if (n <= 1)
            return false;
        if (n == 2 || n == 3)
            return true;
        if (n % 2 == 0 || n % 3 == 0)
            return false;
        for (int i = 5; i <= n / i; i += 6) { // division is slightly more expensive
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        }
        return true;
    }

    public static boolean isPrimeOptimizedMul(int n) {
        if (n <= 1)
            return false;
        if (n == 2 || n == 3)
            return true;
        if (n % 2 == 0 || n % 3 == 0)
            return false;
        /*
         * Can overflow for very large i and n (but not an issue under
         * √Integer.MAX_VALUE ≈ 46,340).
         * safe and fast for n <= 1,000,000 or even up to a few billion:
         */
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        }
        return true;
    }

}