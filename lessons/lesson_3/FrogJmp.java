// https://app.codility.com/programmers/lessons/3-time_complexity/frog_jmp/
package lessons.lesson_3;

public class FrogJmp {
    public int solution(int X, int Y, int D) {
        return (Y - X + D - 1) / D;
    }
}
