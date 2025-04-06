// https://app.codility.com/programmers/lessons/16-greedy_algorithms/max_nonoverlapping_segments/
// Algorithm: Greedy
package lessons.lesson_16;

public class MaxNonoverlappingSegments {
    public int solution(int[] A, int[] B) {
        int N = A.length;
        if (N == 0) return 0;

        int count = 0;
        int lastEnd = Integer.MIN_VALUE;

        for (int i = 0; i < A.length; i++) {
            if (A[i] > lastEnd) {
                count++;
                lastEnd = B[i];
            }
        }

        return count;
    }
    
}
