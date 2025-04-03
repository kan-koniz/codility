// https://app.codility.com/programmers/lessons/8-leader/equi_leader/
package lessons.lesson_8;

public class EquiLeader {
    public int solution(int[] A) {
        int N = A.length;
        if (N == 0) return 0;

        int candidate = -1;
        int candidateCount = 0;

        for (int num : A) {
            if (candidateCount == 0) {
                candidate = num;
                candidateCount = 1;
            } else if (num == candidate) {
                candidateCount++;
            } else {
                candidateCount--;
            }
        }

        int leader = -1;
        int leaderCount = 0;

        for (int i = 0; i < N; i++) {
            if (A[i] == candidate) {
                leaderCount++;
            }
        }

        if (leaderCount > 2) {
            leader = candidate;
        } else {
            return 0;
        }
        
        int equiLeaders = 0;
        int leftCount = 0;
        
        for (int i = 0; i < N; i++) {
            if (A[i] == leader) leftCount++;

            int leftSide = i + 1;
            int rightSide = N - leftSide;
            int rightCount = leaderCount - leftCount;

            if (leftCount > leftSide / 2 && rightCount > rightSide / 2) {
                equiLeaders++;
            }
        }

        return equiLeaders;
    }
    
}
