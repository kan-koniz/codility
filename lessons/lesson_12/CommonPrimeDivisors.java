// https://app.codility.com/programmers/lessons/12-euclidean_algorithm/common_prime_divisors/
package lessons.lesson_12;

public class CommonPrimeDivisors {
    public int solution(int[] A, int[] B) {
        // Implement your solution here
        int count = 0;

        for (int i = 0; i < A.length; i++) {
            if (hasSamePrimeDivisors(A[i], B[i])) {
                count++;
            }
        }

        return count;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    private int removePrimeDivisors(int x, int commonGcd) {
        int d;
        while((d = gcd(x, commonGcd)) != 1) {
            x /= d;
        }

        return x;
    }

    private boolean hasSamePrimeDivisors(int a, int b) {
        int gcd = gcd(a, b);
        return removePrimeDivisors(a, gcd) == 1 && removePrimeDivisors(b, gcd) == 1;
    }
    
}
