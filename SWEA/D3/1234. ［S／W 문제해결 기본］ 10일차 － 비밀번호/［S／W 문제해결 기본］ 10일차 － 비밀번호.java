import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T;
		T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");

			// 여러분의 알고리즘 코드 작성하기
			String[] str = in.readLine().split(" ");
			Stack<Integer> stk = new Stack<>();
			for (String s : str[1].split("")) {
				int tmp=Integer.parseInt(s);
				if(stk.size()>0 && stk.peek()==tmp) {
					stk.pop();
				}
				else {
					stk.push(tmp);
				}
			}
			
			for(int num: stk) {
				sb.append(num);
			}
			sb.append('\n');

		}

		System.out.println(sb);
	}
}