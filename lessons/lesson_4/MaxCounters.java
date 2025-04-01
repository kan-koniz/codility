package lessons.lesson_4;

public class MaxCounters {
    public int[] solution(int N, int[] A) {
        int[] counters = new int[N];
        int maxCounter = 0;
        int currentBase = 0;

        for (int K = 0; K < A.length; K++) {
            if (A[K] >= 1 && A[K] <= N) {
                int index = A[K] - 1;

                if (counters[index] < currentBase) {
                    counters[index] = currentBase;
                }

                counters[index]++;
                maxCounter = Math.max(maxCounter, counters[index]);
            } else if (A[K] == N + 1) {
                currentBase = maxCounter;
            }
        }

        for (int i = 0; i < N; i++) {
            if (counters[i] < currentBase) {
                counters[i] = currentBase;
            }
        }

        return counters;
    }
    
}
