import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());
		
		int[][] board=new int[N][3];
		int[][] dp=new int[N][3];
		int[][] dp2=new int[N][3];
		for(int i=0;i<N;i++) {
			String[] split=in.readLine().split(" ");
			board[i][0]=Integer.parseInt(split[0]);
			board[i][1]=Integer.parseInt(split[1]);
			board[i][2]=Integer.parseInt(split[2]);
		}
		
		dp[0][0]=board[0][0];
		dp[0][1]=board[0][1];
		dp[0][2]=board[0][2];
		
		dp2[0][0]=board[0][0];
		dp2[0][1]=board[0][1];
		dp2[0][2]=board[0][2];
		for(int i=1;i<N;i++) {
			dp[i][0]=Math.max(dp[i-1][0], dp[i-1][1])+board[i][0];
			dp[i][1]=Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2]))+board[i][1];
			dp[i][2]=Math.max(dp[i-1][1], dp[i-1][2])+board[i][2];
			
			dp2[i][0]=Math.min(dp2[i-1][0], dp2[i-1][1])+board[i][0];
			dp2[i][1]=Math.min(dp2[i-1][0], Math.min(dp2[i-1][1], dp2[i-1][2]))+board[i][1];
			dp2[i][2]=Math.min(dp2[i-1][1], dp2[i-1][2])+board[i][2];
		}
		System.out.println(Math.max(dp[N-1][0], Math.max(dp[N-1][1], dp[N-1][2])));
		System.out.println(Math.min(dp2[N-1][0], Math.min(dp2[N-1][1], dp2[N-1][2])));
	}
}