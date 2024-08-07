import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
class Solution {
    boolean solution(String order) {
        Stack<Character> stack = new Stack<>();

        for (char ch : order.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }
}