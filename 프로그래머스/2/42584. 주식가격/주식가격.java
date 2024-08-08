import java.io.IOException;
import java.util.Stack;
class Solution {
    public int[] solution(int[] prices) {
		Stack<int[]> stk=new Stack<int[]>();
		for(int i=0; i<prices.length;i++) {
			stk.add(new int[] {prices[i],i});
		}
		int[] ans=new int[prices.length];
		
		
		Stack<int[]> stk2=new Stack<int[]>();
		
		for(int i=0; i<stk.size();i++) {
			while(stk2.size()>0 && stk2.peek()[0]>prices[i] ) {
				ans[stk2.peek()[1]]=i-stk2.peek()[1];
				stk2.pop();
			}
			stk2.add(new int[] {prices[i],i});
		}
		

		for (int[] s : stk2) {
			ans[s[1]]=prices.length-s[1]-1;
		}
		
		return ans;
    }
}