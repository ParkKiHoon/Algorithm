import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;class Solution
{
    public int solution(String s)
    {
		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()) {
			if (stack.size() > 0 && stack.peek()==c) {
				stack.pop();
			} else {
				stack.push(c);
			}
		}
		if(stack.isEmpty()) {
			return 1;
		}
		else {
			return 0;
		}
    }
}