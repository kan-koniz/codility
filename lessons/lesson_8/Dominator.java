// https://app.codility.com/programmers/lessons/8-leader/dominator/
package lessons.lesson_8;

public class Dominator {
    public int solution(int[] A) {
        int N = A.length;
        if (N == 0) return -1;

        int candidate = -1;
        int count = 0;

        for (int num : A) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        int dominatorCount = 0;
        int dominatorIndex = -1;
        for (int i = 0; i < N; i++) {
            if (A[i] == candidate) {
                dominatorCount++;

                if (dominatorIndex == -1) {
                    dominatorIndex = i;
                }
            }
        }

        return dominatorCount > (N / 2) ? dominatorIndex : -1;
    }
    
}
