// https://app.codility.com/programmers/lessons/11-sieve_of_eratosthenes/count_semiprimes/
package lessons.lesson_11;

import java.util.Arrays;

public class CountSemiprimes {
    public int[] solution(int N, int[] P, int[] Q) {
        // Step 1: Generate all prime numbers up to N using the Sieve of Eratosthenes
        boolean[] isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        
        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Step 2: Count semiprimes
        int[] semiprimeCount = new int[N + 1];
        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i; j <= N / i; j++) {
                    if (isPrime[j]) {
                        semiprimeCount[i * j]++;
                    }
                }
            }
        }

        // Step 3: Create a prefix sum array for semiprimes
        int[] prefixSum = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            prefixSum[i] = prefixSum[i - 1] + semiprimeCount[i];
        }

        // Step 4: Answer the queries
        int M = P.length;
        int[] result = new int[M];
        for (int k = 0; k < M; k++) {
            result[k] = prefixSum[Q[k]] - prefixSum[P[k] - 1];
        }

        return result;
    }
    
}
