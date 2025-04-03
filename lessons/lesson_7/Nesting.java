// https://app.codility.com/programmers/lessons/7-stacks_and_queues/nesting/
package lessons.lesson_7;

public class Nesting {
    public int solution(String S) {
        int openBrackets = 0;

        for (char c : S.toCharArray()) {
            if (c == '(') {
                openBrackets++;
            } else {
                if (openBrackets == 0) return 0;
                openBrackets--;
            }
        }

        return openBrackets == 0 ? 1: 0;
    }
    
}
