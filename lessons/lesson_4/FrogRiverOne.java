// https://app.codility.com/programmers/lessons/4-counting_elements/frog_river_one/
package lessons.lesson_4;

public class FrogRiverOne {
    public int solution(int X, int[] A) {
        boolean[] leaves = new boolean[X + 1];
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (!leaves[A[i]]) {
                leaves[A[i]] = true;
                count++;
            }
            if (count == X) {
                return i;
            }
        }
        return -1;
    }
    
}
