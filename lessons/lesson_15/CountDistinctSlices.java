// https://app.codility.com/programmers/lessons/15-caterpillar_method/count_distinct_slices/
// Algorithm: Caterpillar Method
package lessons.lesson_15;

public class CountDistinctSlices {
    public int solution(int M, int[] A) {
        int N = A.length;
        int[] lastSeen = new int[M + 1];
        int start = 0;
        int distinctSlices = 0;

        for (int end = 0; end < N; end++) {
            start = Math.max(start, lastSeen[A[end]]);

            distinctSlices += (end - start + 1);

            if (distinctSlices > 1000000000) return 1000000000;

            lastSeen[A[end]] = end + 1;
        }

        return distinctSlices;
    }
    
}
