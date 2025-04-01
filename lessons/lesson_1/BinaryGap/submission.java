package lessons.lesson_1.BinaryGap;

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int N) {
        // Implement your solution here
        String binaryString = Integer.toBinaryString(N);

        int maxGap = 0;
        int currentGap = 0;
        boolean foundOne = false;

        for (int i = 0; i < binaryString.length(); i++) {
            char bit = binaryString.charAt(i);

            if (bit == '1') {
                if (foundOne) {
                    maxGap = Math.max(maxGap, currentGap);
                }
                currentGap = 0;
                foundOne = true;
            } else if (foundOne) {
                currentGap++;
            }
        }

        return maxGap;
    }
}