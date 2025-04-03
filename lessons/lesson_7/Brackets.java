// https://app.codility.com/programmers/lessons/7-stacks_and_queues/brackets/
package lessons.lesson_7;

import java.util.Stack;

public class Brackets {
    public int solution(String S) {
        int N = S.length();
        if (N == 0) return 1;

        Stack<Character> stack = new Stack<>();

        for (char c: S.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return 0;

                char top = stack.pop();
                if (c == ')' && top != '(') return 0;
                if (c == ']' && top != '[') return 0;
                if (c == '}' && top != '{') return 0;
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
    
}
