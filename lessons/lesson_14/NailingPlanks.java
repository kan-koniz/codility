// https://app.codility.com/programmers/lessons/14-binary_search_algorithm/nailing_planks/
// Algorithm: Binary Search + Prefix Sum
package lessons.lesson_14;

public class NailingPlanks {
    public int solution(int[] A, int[] B, int[] C) {
        int M = C.length;
        int result = -1;
        int low = 1;
        int high = M;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (canNailAll(A, B, C, mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }

    private boolean canNailAll(int[] A, int[] B, int[] C, int nailsUsed) {
        int max = 2 * C.length + 2;
        int[] prefix = new int[max];
        for (int i = 0; i < nailsUsed; i++) {
            prefix[C[i]] = 1;
        }
        for (int i = 1; i < max; i++) {
            prefix[i] += prefix[i - 1];
        }

        for (int i = 0; i < A.length; i++) {
            if (prefix[B[i]] - prefix[A[i] - 1] == 0) {
                return false;
            }
        }
        return true;
    }
    
}
