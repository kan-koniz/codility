// https://app.codility.com/programmers/lessons/15-caterpillar_method/count_triangles/
package lessons.lesson_15;

import java.util.Arrays;

public class CountTriangles {
    public int solution(int[] A) {
        int N = A.length;
        int count = 0;

        // Sort the array
        Arrays.sort(A);

        for (int i = 0; i < N - 2; i++) {
            int k = i + 2; // Initialize k to the third element after i

            for (int j = i + 1; j < N; j++) {
                // Move k to the right while the triangle inequality holds
                while (k < N && A[i] + A[j] > A[k]) {
                    k++;
                }
                // Count the number of valid triangles formed with A[i] and A[j]
                count += k - j - 1;
            }
        }

        return count;
    }
    
}
