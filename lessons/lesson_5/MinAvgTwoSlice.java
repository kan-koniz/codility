package lessons.lesson_5;

public class MinAvgTwoSlice {
    public int solution(int[] A) {
        int N = A.length;
        if (N < 2) return 0;

        double minAvg = Double.MAX_VALUE;
        int minIndex = 0;

        for (int i = 0; i < N - 1; i++) {
            double avg2 = (A[i] + A[i + 1]) / 2.0;
            if (avg2 < minAvg) {
                minAvg = avg2;
                minIndex = i;
            }

            if (i < N - 2) {
                double avg3 = (A[i] + A[i + 1] + A[i + 2]) / 3.0;
                if (avg3 < minAvg) {
                    minAvg = avg3;
                    minIndex = i;
                }
            }
        }

        return minIndex;
    }
    
}
