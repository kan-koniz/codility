// https://app.codility.com/programmers/lessons/11-sieve_of_eratosthenes/count_non_divisible/
package lessons.lesson_11;

public class CountNonDivisible {
    public int[] solution(int[] A) {
        int n = A.length;
        int[] result = new int[n];
        int maxElement = 0;

        // Find the maximum element in A
        for (int i = 0; i < n; i++) {
            if (A[i] > maxElement) {
                maxElement = A[i];
            }
        }

        // Create a frequency array to count occurrences of each number in A
        int[] frequency = new int[maxElement + 1];
        for (int i = 0; i < n; i++) {
            frequency[A[i]]++;
        }

        // Calculate the number of non-divisible integers for each element in A
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 1; j <= Math.sqrt(A[i]); j++) {
                if (A[i] % j == 0) {
                    // Count the divisor and its complement if they are within bounds
                    if (j <= maxElement) {
                        count += frequency[j];
                    }
                    if (A[i] / j != j && A[i] / j <= maxElement) {
                        count += frequency[A[i] / j];
                    }
                }
            }
            result[i] = n - count; // Total elements minus the count of divisible elements
        }

        return result;
    }
    
}
