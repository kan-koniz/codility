// https://app.codility.com/programmers/lessons/17-dynamic_programming/number_solitaire/
package lessons.lesson_17;

public class NumberSolitaire {
    public int solution(int[] A) {
        int N = A.length;
        int[] dp = new int[N];

        dp[0] = A[0];
        for (int i = 1; i < N; i++) {
            dp[i] = Integer.MIN_VALUE;

            for (int k = 1; k <= 6; k++) {
                if (i - k >= 0) {
                    dp[i] = Math.max(dp[i], dp[i - k] + A[i]);
                }
            }
        }

        return dp[N - 1];
    }
    
}
