// https://app.codility.com/programmers/lessons/13-fibonacci_numbers/fib_frog/
// Algorithm: Fibonacci + BFS (Breadth-First Search)
package lessons.lesson_13;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FibFrog {
    public int solution(int[] A) {
        int N = A.length;
        
        // Handle empty array case
        if (N == 0) {
            return 1; // can jump directly with F(1)=1
        }

        List<Integer> fibs = new ArrayList<>();
        fibs.add(1); // F(1)
        fibs.add(2); // F(2)
        int i = 2;
        while(true) {
            int nextFib = fibs.get(i - 1) + fibs.get(i - 2);
            if (nextFib > N + 1) break; // N+1 because we can jump over entire array
            fibs.add(nextFib);
            i++;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(-1); // starting position before first leaf
        
        boolean[] visited = new boolean[N];
        int jumps = 0;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            
            for (int j = 0; j < size; j++) {
                int currentPos = queue.poll();
                
                for (int fib : fibs) {
                    int nextPos = currentPos + fib;
                    
                    // Check if we can reach the other side directly
                    if (nextPos == N) {
                        return jumps + 1;
                    }
                    
                    // Check if we can jump beyond the other side
                    if (nextPos > N) {
                        continue;
                    }
                    
                    // For positions within array
                    if (nextPos >= 0) {
                        // Special case: all zeros, can jump over entire array
                        if (nextPos == N && currentPos == -1) {
                            return 1;
                        }
                        
                        if (nextPos < N && A[nextPos] == 1 && !visited[nextPos]) {
                            visited[nextPos] = true;
                            queue.add(nextPos);
                        }
                    }
                }
            }
            jumps++;
        }
        
        return -1;
    }
    
}
