// https://app.codility.com/programmers/lessons/7-stacks_and_queues/stone_wall/
package lessons.lesson_7;

public class StoneWall {
    public int solution(int[] H) {
        int N = H.length;
        int blocks = 0;
        int[] stack = new int[N];
        int top = -1;

        for (int i = 0; i < N; i++) {
            while (top >= 0 && stack[top] > H[i]) {
                top--;
            }
            if (top < 0 || stack[top] < H[i]) {
                blocks++;
                stack[++top] = H[i];
            }
        }

        return blocks;
    }
    
}
