package lessons.lesson_15;

import java.util.Arrays;

public class MinAbsSumOfTwo {
    public int solution(int[] A) {
        int N = A.length;
        int result = Integer.MAX_VALUE;

        Arrays.sort(A);

        for (int  i = 0; i < N; i++) {
            result = Math.min(result, Math.abs(A[i] + A[i]));

            int left = 0, right = N -1;
            while (left <= right) {
                int mid = (left + right) / 2;
                int sum = A[i] + A[mid];
                
                if (sum < 0) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }

                result = Math.min(result, Math.abs(sum));
            }
        }

        return result;
    }
    
}
