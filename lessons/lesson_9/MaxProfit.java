// https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_profit/
package lessons.lesson_9;

public class MaxProfit {
    public int solution(int[] A) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int i = 0; i < A.length; i++) {
            int currentProfit = A[i] - minPrice;
            maxProfit = Math.max(maxProfit, currentProfit);
            minPrice = Math.min(minPrice, A[i]);
        }

        return maxProfit;
    }
    
}
