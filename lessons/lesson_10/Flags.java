// https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/flags/
package lessons.lesson_10;

import java.util.ArrayList;
import java.util.List;

public class Flags {
    public int solution(int[] A) {
        // Implement your solution here
        int N = A.length;
        if (N < 3) return 0;
        
        List<Integer> peaks = new ArrayList<>();
        for (int i = 1; i < N - 1; i++) {
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
                peaks.add(i);
            }
        }

        int peakCount = peaks.size();
        if (peakCount == 0) return 0;
        if (peakCount == 1) return 1;

        int left = 1, right = peakCount, maxFlags = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (canPlaceFlags(peaks, mid)) {
                maxFlags = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return maxFlags;
    }

    private boolean canPlaceFlags(List<Integer> peaks, int flags) {
        int usedFlags = 1;
        int lastFlagPosition = peaks.get(0);

        for (int i = 1; i < peaks.size(); i++) {
            if (peaks.get(i) - lastFlagPosition >= flags) {
                usedFlags++;
                lastFlagPosition = peaks.get(i);
            }
        }

        return usedFlags >= flags;
    }
    
}
