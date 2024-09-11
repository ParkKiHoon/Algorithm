import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Solution {

	static int[] dx = { 0, -1, 0, 1, 0 };
	static int[] dy = { 0, 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T;
		T = Integer.parseInt(in.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");
			String[] split = in.readLine().split(" ");
			int N=Integer.parseInt(split[0]);
			int L=Integer.parseInt(split[1]);
			int[] weights=new int[N+1];
			int[] profits=new int[N+1];
			for(int i=1;i<=N;i++) {
				String[] tmp=in.readLine().split(" ");
				weights[i]=Integer.parseInt(tmp[1]);
				profits[i]=Integer.parseInt(tmp[0]);
			}
			
			int[][] dp=new int[N+1][L+1];
			for(int i=1;i<=N;i++) {
				int weight=weights[i];
				int profit=profits[i];
				for(int j=1;j<=L;j++) {
					if(weight<=j) {
						dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-weight]+profit);
					}else {
						dp[i][j]=dp[i-1][j];
					}
				}
			}
			
			sb.append(dp[N][L]);
			sb.append("\n");
		}

		System.out.println(sb);
	}

}