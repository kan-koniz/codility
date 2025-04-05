// https://app.codility.com/programmers/lessons/12-euclidean_algorithm/chocolates_by_numbers/
package lessons.lesson_12;

public class ChocolatesByNumbers {
    public int solution(int N, int M) {
        return N / gcd(N, M);
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
