// https://app.codility.com/programmers/lessons/3-time_complexity/tape_equilibrium/
package lessons.lesson_3;

public class TapeEquilibrium {
    public int solution(int[] A) {
        int N = A.length;
        if (N < 2) {
            return 0;
        }

        int totalSum = 0;
        for (int number : A) {
            totalSum += number;
        }

        int leftSum = 0;
        int minDifference = Integer.MAX_VALUE;

        for (int P = 0; P < N - 1; P++) {
            leftSum += A[P];
            int rightSum = totalSum - leftSum;
            int difference = Math.abs(leftSum - rightSum);
            minDifference = Math.min(minDifference, difference);
        }

        return minDifference;
    }
    
}
