// https://app.codility.com/programmers/lessons/14-binary_search_algorithm/min_max_division/
// Algorithm: Binary Search + Greedy
package lessons.lesson_14;

public class MinMaxDivision {
    public int solution(int K, int M, int[] A) {
        int max = 0;
        int sum = 0;
        for (int num : A) {
            max = Math.max(num, max);
            sum += num;
        }

        int low = max;
        int high = sum;

        int result = sum;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (canDivide(A, K, mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }

    private boolean canDivide(int[] A, int K, int maxBlockSum) {
        int blockCount = 1;
        int currentSum = 0;

        for (int num : A) {
            currentSum += num;
            if (currentSum > maxBlockSum) {
                blockCount++;
                currentSum = num;

                if (blockCount > K) return false;
            }
        }

        return true;
    }
    
}
