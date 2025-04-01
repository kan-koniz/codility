// https://app.codility.com/programmers/lessons/3-time_complexity/perm_missing_elem/
package lessons.lesson_3;

public class PermMissingElem {
    public int solution(int[] A) {
        int N = A.length;
        int result = 0;

        for (int i = 0; i <= N + 1; i++) {
            result ^= i;
        }

        for (int number : A) {
            result ^= number;
        }

        return result;
    }
}
