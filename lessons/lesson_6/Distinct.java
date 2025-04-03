// https://app.codility.com/programmers/lessons/6-sorting/distinct/
package lessons.lesson_6;

import java.util.*;

public class Distinct {
    public int solution(int[] A) {
        HashSet<Integer> uniqueNumbers = new HashSet<>();
        for (int num : A) {
            uniqueNumbers.add(num);
        }

        return uniqueNumbers.size();
    }

}
