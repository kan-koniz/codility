package lessons.lesson_16;

public class TieRopes {
    public int solution(int K, int[] A) {
        int count = 0;
        int currentLength = 0;

        for (int length : A) {
            currentLength += length;
            if (currentLength >= K) {
                count++;
                currentLength = 0;
            }
        }

        return count;
    }
    
}
