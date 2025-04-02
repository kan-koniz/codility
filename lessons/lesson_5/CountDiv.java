// https://app.codility.com/programmers/lessons/5-prefix_sums/count_div/
package lessons.lesson_5;

public class CountDiv {
    public int solution(int A, int B, int K) {
        if (A == 0) {
            return (B / K) + 1;
        } else {
            return (B / K) - ((A - 1) / K);
        }
    }
    
}
