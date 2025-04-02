package lessons.lesson_5;

public class GenomicRangeQuery {
    public int[] solution(String S, int[] P, int[] Q) {
        int N = S.length();
        int M = P.length;
        int[] result = new int[M];

        int[][] prefix = new int[3][N + 1];

        for (int i = 0; i < N; i++) {
            char c = S.charAt(i);
            for (int j = 0; j < 3; j++) {
                prefix[j][i + 1] = prefix[j][i];
            }

            if (c == 'A') prefix[0][i + 1]++;
            else if (c == 'C') prefix[1][i + 1]++;
            else if (c == 'G') prefix[2][i + 1]++;
        }

        for (int i = 0; i < M; i++) {
            int start = P[i], end = Q[i] + 1;

            if (prefix[0][end] - prefix[0][start] > 0) result[i] = 1;
            else if (prefix[1][end] - prefix[1][start] > 0) result[i] = 2;
            else if (prefix[2][end] - prefix[2][start] > 0) result[i] = 3;
            else result[i] = 4;
        }

        return result;
    }
    
}
