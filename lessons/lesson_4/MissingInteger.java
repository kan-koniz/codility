// https://app.codility.com/programmers/lessons/4-counting_elements/missing_integer/
package lessons.lesson_4;

public class MissingInteger {
    public int solution(int[] A) {
        int N = A.length;
        boolean[] seen = new boolean[N + 1];
        
        for (int i = 0; i < N; i++) {
            if (A[i] > 0 && A[i] <= N) {
                seen[A[i]] = true;
            }
        }
        for (int i = 1; i <= N; i++) {
            if (!seen[i]) {
                return i;
            }
        }
        return N + 1;
    }
    
}
