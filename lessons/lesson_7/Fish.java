// https://app.codility.com/programmers/lessons/7-stacks_and_queues/fish/
package lessons.lesson_7;

import java.util.Stack;

public class Fish {
    public int solution(int[] A, int[] B) {
        int N = A.length;
        Stack<Integer> stack = new Stack<>();
        int aliveUpstreamFish = 0;

        for (int i = 0; i < N; i++) {
            if (B[i] == 1) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
                    stack.pop();
                }
                
                if (stack.isEmpty()) {
                    aliveUpstreamFish++;
                }
            }
        }

        return stack.size() + aliveUpstreamFish;
    }
}
