// https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_double_slice_sum/
// Algorithm: Dynamic Programming
// Time complexity: O(N)
package lessons.lesson_9;

public class MaxDoubleSliceSum {
    public int solution(int[] A) {
        int N = A.length;
        if (N < 4) return 0;

        int[] maxLeft = new int[N];
        for (int i = 1; i < N - 1; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1] + A[i], 0);
        }

        int[] maxRight = new int[N];
        for (int i = N - 2; i > 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1] + A[i], 0);
        }

        int maxDoubleSliceSum = 0;
        for (int Y = 1; Y < N - 1; Y++) {
            maxDoubleSliceSum = Math.max(maxDoubleSliceSum, maxLeft[Y - 1] + maxRight[Y + 1]);
        }

        return maxDoubleSliceSum;
    }
    
}
