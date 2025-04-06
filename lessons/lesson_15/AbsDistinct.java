// https://app.codility.com/programmers/lessons/15-caterpillar_method/abs_distinct/
package lessons.lesson_15;

import java.util.HashSet;
import java.util.Set;

public class AbsDistinct {
    public int solution(int[] A) {
        Set<Integer> set = new HashSet<>();

        for (int num: A) {
            set.add(Math.abs(num));
        }

        return set.size();
    }
    
}
