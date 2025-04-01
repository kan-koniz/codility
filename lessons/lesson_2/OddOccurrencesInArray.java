// https://app.codility.com/programmers/lessons/2-arrays/odd_occurrences_in_array/
package lessons.lesson_2;

public class OddOccurrencesInArray {
    public int solution(int[] A) {
        int result = 0;

        for (int number : A) {
            result ^= number;
        }

        return result;
    }
}
