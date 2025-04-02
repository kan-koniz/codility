// https://app.codility.com/programmers/lessons/5-prefix_sums/passing_cars/
package lessons.lesson_5;

public class PassingCars {
    public int solution(int[] A) {
        long passingCount = 0;
        int eastCarCount = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == 1) {
                passingCount += eastCarCount;
            } else {
                eastCarCount++;
            }
        }

        return passingCount > 1000000000 ? -1 : (int) passingCount;
    }
}