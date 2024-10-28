import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] split=in.readLine().split(" ");
		int N=Integer.parseInt(split[0]);
		int M=Integer.parseInt(split[1]);
		int R=Integer.parseInt(split[2]);
		
		int[] value=new int[N+1];
		split=in.readLine().split(" ");
		for(int i=1;i<N+1;i++) {
			value[i]=Integer.parseInt(split[i-1]);
		}
		
		int[][] board=new int[N+1][N+1];
		for(int i=0;i<N+1;i++) {
			Arrays.fill(board[i], 999999999);
		}
		for(int i=0;i<N+1;i++) {
			board[i][i]=0;
		}
		
		for(int i=0;i<R;i++) {
			split=in.readLine().split(" ");
			int start=Integer.parseInt(split[0]);
			int end=Integer.parseInt(split[1]);
			int cost=Integer.parseInt(split[2]);
			board[start][end]=cost;
			board[end][start]=cost;
		}
		

		
		for(int k=1;k<=N;k++) {
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					if(board[i][k]+board[k][j]<board[i][j]) {
						board[i][j]=board[i][k]+board[k][j];
					}
				}
			}
		}

		
		
		int ans=0;
		for(int i=1;i<=N;i++) {
			int tmp=0;
			for(int j=1;j<=N;j++) {
				if(board[i][j]<=M) {
					tmp+=value[j];
				}
			}
			ans=Math.max(ans, tmp);
		}
		System.out.println(ans);
	}
}