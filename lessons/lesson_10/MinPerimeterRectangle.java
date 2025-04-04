// https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/min_perimeter_rectangle/
package lessons.lesson_10;

public class MinPerimeterRectangle {
    public int solution(int N) {
        int minPerimeter = Integer.MAX_VALUE;
        long sqrtN = (long) Math.sqrt(N);

        for (int i = 1; i <= sqrtN; i++) {
            if (N % i == 0) {
                int a = i;
                int b = N / i;
                int perimeter = 2 * (a + b);
                minPerimeter = Math.min(minPerimeter, perimeter);
            }
        }

        return minPerimeter;
    }
    
}
