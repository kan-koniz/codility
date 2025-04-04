// https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/count_factors/
package lessons.lesson_10;

public class CountFactors {
    public int solution(int N) {
        int factor = 0;
        long sqrtN = (long) Math.sqrt(N);

        for (int i = 1; i <= sqrtN; i++) {
            if (N % i == 0) {
                factor++;

                if (i != (N / i)) {
                    factor++;
                }
            }
        }
        
        return factor;
    }
}
