// https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_slice_sum/
// Algorithm: Kadane's Algorithm
// Time Complexity: O(N)
package lessons.lesson_9;

public class MaxSliceSum {
    public int solution(int[] A) {
        int currentSliceSum = 0;
        int maxSliceSum = Integer.MIN_VALUE;

        for (int num : A) {
            currentSliceSum = Math.max(num, currentSliceSum + num);
            maxSliceSum = Math.max(maxSliceSum, currentSliceSum);
        }

        return maxSliceSum;
    }
    
}
