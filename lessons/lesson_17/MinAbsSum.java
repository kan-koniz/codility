// https://app.codility.com/programmers/lessons/17-dynamic_programming/min_abs_sum/
package lessons.lesson_17;

import java.util.Arrays;

public class MinAbsSum {
    public int solution(int[] A) {
        int[] freq = new int[101];
        int totalSum = 0;
        for (int num : A) {
            int val = Math.abs(num);
            freq[val]++;
            totalSum += val;
        }
        if (totalSum == 0) {
            return 0;
        }

        int size = totalSum + 1;
        int len  = (size + 63) >>> 6;
        long[] dpBits = new long[len];
        dpBits[0] = 1L;

        for (int v = 1; v <= 100; v++) {
            int count = freq[v];
            if (count == 0) continue;
            int base = 1;
            while (count > 0) {
                int take = Math.min(base, count);
                int chunk = take * v;
                shiftOr(dpBits, chunk);
                count -= take;
                base <<= 1;
            }
        }

        int half = totalSum >>> 1;
        for (int i = half; i >= 0; i--) {
            if (getBit(dpBits, i)) {
                return totalSum - 2 * i;
            }
        }
        return totalSum;
    }

    private void shiftOr(long[] dp, int shift) {
        long[] temp = Arrays.copyOf(dp, dp.length);
        shiftLeft(temp, shift);
        for (int i = 0; i < dp.length; i++) {
            dp[i] |= temp[i];
        }
    }

    private void shiftLeft(long[] dp, int shift) {
        if (shift == 0) return;
        int wordShift = shift >>> 6;
        int bitShift  = shift & 63;

        if (bitShift == 0) {
            for (int i = dp.length - 1; i >= wordShift; i--) {
                dp[i] = dp[i - wordShift];
            }
            for (int i = wordShift - 1; i >= 0; i--) {
                dp[i] = 0L;
            }
        } else {
            for (int i = dp.length - 1; i >= 0; i--) {
                long low  = (i - wordShift    >= 0) ? dp[i - wordShift] : 0L;
                long high = (i - wordShift - 1 >= 0) ? dp[i - wordShift - 1] : 0L;
                dp[i] = (low << bitShift) | ((high & 0xFFFFFFFFFFFFFFFFL) >>> (64 - bitShift));
            }
            for (int i = 0; i < wordShift; i++) {
                dp[i] = 0L;
            }
        }
    }

    private boolean getBit(long[] dp, int pos) {
        int idx = pos >>> 6;
        int off = pos & 63;
        return (dp[idx] & (1L << off)) != 0;
    }
    
}
