package lessons.lesson_2;

public class CyclicRotation {
    public int[] solution(int[] A, int K) {
        int N = A.length;
        if (N == 0 || K % N == 0) {
            return A;
        }

        K = K % N;
        int[] rotatedArray = new int[N];

        for (int i = 0; i < N; i++) {
            int newIndex = (i + K) % N;
            rotatedArray[newIndex] = A[i];
        }

        return rotatedArray;
    }
}
