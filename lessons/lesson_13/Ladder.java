// https://app.codility.com/programmers/lessons/13-fibonacci_numbers/ladder/
// Algorithm: Fibonacci + Modulo
package lessons.lesson_13;

public class Ladder {
    public int[] solution(int[] A, int[] B) {
        int L = A.length;

        int maxA = 0;
        for (int n : A) {
            if (n > maxA) maxA = n;
        }

        int maxFib = maxA + 1;
        int[] fibonacci = new int[maxFib];
        fibonacci[0] = 1;
        fibonacci[1] = 1;
        for (int i = 2; i < maxFib; i++) {
            fibonacci[i] = (fibonacci[i - 1] + fibonacci[i - 2]) & 0x7FFFFFFF;
        }

        int[] result = new int[L];
        for(int j = 0; j < L; j++) {
            int n = A[j];
            int mod = 1 << B[j];
            result[j] = fibonacci[n] % mod;
        }

        return result;
    }
    
}
