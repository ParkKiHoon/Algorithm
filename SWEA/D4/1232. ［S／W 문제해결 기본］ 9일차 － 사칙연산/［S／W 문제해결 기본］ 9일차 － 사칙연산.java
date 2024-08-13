import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {

	static int[][] tree;
	static String[] value;
	static StringBuilder sb;
	static Stack<Double> stack;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T;
		T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");
			
			int N=Integer.parseInt(in.readLine());
			tree=new int[N+1][2];
			value=new String[N+1];
			for(int i=1;i<=N;i++) {
				String[] arr=in.readLine().split(" ");
				value[i]=arr[1];
				stack=new Stack<>();
				
				if(arr.length==4) {
					int a=Integer.parseInt(arr[0]);
					int b = Integer.parseInt(arr[2]);
					int c = Integer.parseInt(arr[3]);
					tree[a][0]=b;
					tree[a][1]=c;
				}
			}
			postOrder(1);
			sb.append(stack.pop().intValue());
			sb.append('\n');

		}

		System.out.println(sb);
	}

	private static void postOrder(int x) {
		if(tree[x][0]==0 &&tree[x][1]==0) {
			operation(value[x]);
			
		}else {
			if(tree[x][0] !=0) {
				postOrder(tree[x][0]);
			}
			if(tree[x][1] !=0) {
				postOrder(tree[x][1]);
			}
			operation(value[x]);
		}
	}

	static void operation(String v) {
		// 숫자일 경우 
		if(!v.equals("+") && !v.equals("-") && !v.equals("*") && !v.equals("/")) {
			stack.push(Double.parseDouble(v));
			return;
		}
		
		// 연산자일 경우 
		Double b = stack.pop();
		Double a = stack.pop();
		
		if(v.equals("+")) {
			stack.push(a + b);
		} else if(v.equals("-")) {
			stack.push(a - b);
		} else if(v.equals("*")) {
			stack.push(a * b);
		} else if(v.equals("/")) {
			stack.push(a / b);
		}
	}
}