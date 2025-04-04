package lessons.lesson_10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Peaks {
    public int solution(int[] A) {
        int N = A.length;
        if (N < 3) return 0;

        List<Integer> peaks = new ArrayList<>();
        for (int i = 1; i < N - 1; i++) {
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
                peaks.add(i);
            }
        }

        int M = peaks.size();
        if (M == 0) return 0;

        List<Integer> divisors = getDivisors(N);
        for (int K : divisors) {
            if (K > M) continue;
            int blockSize = N / K;
            if (checkPeakInBlocks(peaks, K, blockSize)) {
                return K;
            }
        }

        return 0;
    }

    private List<Integer> getDivisors(int n) {
        Set<Integer> divisors = new HashSet<>();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                divisors.add(i);
                divisors.add(n / i);
            }
        }
        List<Integer> sortedDivisors = new ArrayList<>(divisors);
        Collections.sort(sortedDivisors, Collections.reverseOrder());
        return sortedDivisors;
    }

    private boolean checkPeakInBlocks(List<Integer> peaks, int K, int blockSize) {
        boolean[] hasPeak = new boolean[K];
        int count = 0;

        for (int peak : peaks) {
            int blockIndex = peak / blockSize;
            if (blockIndex < K && !hasPeak[blockIndex]) {
                hasPeak[blockIndex] = true;
                count++;
                if (count == K) {
                    return true;
                }
            }
        }

        return count == K;
    }
    
}
