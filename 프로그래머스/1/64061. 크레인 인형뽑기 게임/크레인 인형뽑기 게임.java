import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;
class Solution {
    public int solution(int[][] board, int[] moves) {
		ArrayList<Stack<Integer>> stkList = new ArrayList<>();

		for (int i = 0; i < board[0].length; i++) {
			Stack<Integer> newStk = new Stack<>();
			for (int j = board.length-1; j>=0; j--) {
				if(board[j][i]!=0) {
					newStk.push(board[j][i]);
				}
			}
			stkList.add(newStk);
		}

		int ans = 0;
		Stack<Integer> stk = new Stack<>();
		for (int i : moves) {
			if(stkList.get(i-1).size()>0) {
				int tmp = stkList.get(i - 1).pop();
				if (stk.size() > 0 && stk.peek() == tmp) {
					stk.pop();
					ans++;
				} else {
					stk.push(tmp);
				}
			}
		}

		return ans*2;
    }
    
}