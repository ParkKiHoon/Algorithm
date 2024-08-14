import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {	
	static int N;
	static int[] operations;
	static int[] operands;
	static int min;
	static int max;
	static void dfs(int depth,int total) {
		if(depth==N-1) {
			min=Math.min(min, total);
			max=Math.max(max, total);
		}
		for(int i=0;i<4;i++) {
			if(operations[i]>0) {
				operations[i]--;
				dfs(depth+1,cal(total,operands[depth+1],i));
				operations[i]++;
			}
		}
	}
	


	private static int cal(int a, int b, int operator) {
		if(operator==0) {
			return a+b;
		}else if(operator==1) {
			return a-b;
		}else if(operator==2) {
			return a*b;
		}else if(operator==3) {
			return a/b;
		}
		return 0;
	}



	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T;
		// T = 10;
		T = Integer.parseInt(in.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");
			min=Integer.MAX_VALUE;
			max=Integer.MIN_VALUE;
			N=Integer.parseInt(in.readLine());
			String[] operationsIn = in.readLine().split(" ");
			operations = new int[4];
			for(int i=0; i<4;i++) {
				operations[i]=Integer.parseInt(operationsIn[i]);
			}
			
			String[] operandsIn = in.readLine().split(" ");
			operands = new int[N];
			for(int i=0;i<N;i++) {
				operands[i]=Integer.parseInt(operandsIn[i]);
			}
			
			
			
			dfs(0,operands[0]);
			sb.append(Math.abs(max-min));
			
			sb.append('\n');

		}
		System.out.println(sb);
	}

}