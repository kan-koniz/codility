// https://app.codility.com/programmers/lessons/4-counting_elements/perm_check/
package lessons.lesson_4;

public class PermCheck {
    public int solution(int[] A) {
        int N = A.length;
        boolean[] seen = new boolean[N + 1];
        
        for (int i = 0; i < N; i++) {
            if (A[i] < 1 || A[i] > N || seen[A[i]]) {
                return 0; // Not a permutation
            }
            seen[A[i]] = true;
        }
        
        return 1; // Is a permutation
    }
    
}
