import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
class Solution {
    public int solution(String s) {
		Deque<Character> deque = new ArrayDeque<>();
		for (char c : s.toCharArray()) {
			deque.add(c);
		}
		int cnt = 0;

		for (int i = 0; i<deque.size(); i++) {
			char tmp=deque.removeFirst();
			deque.addLast(tmp);
			
			Stack<Character> stack = new Stack<Character>();
			for (char c : deque) {
				if (stack.size() > 0 && stack.peek() == '(' && c == ')') {
					stack.pop();
				} else if (stack.size() > 0 && stack.peek() == '[' && c == ']') {
					stack.pop();
				} else if (stack.size() > 0 && stack.peek() == '{' && c == '}') {
					stack.pop();
				} else {
					stack.push(c);
				}
			}
			if(stack.isEmpty()) {
				cnt++;
			}
		}
		return cnt;
    }
}