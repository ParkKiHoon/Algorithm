import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());
		int M = Integer.parseInt(in.readLine());
		int[][] board = new int[N][N];

		for(int i=0;i<N;i++) {
			Arrays.fill(board[i], 999999999);
		}
		for(int i=0;i<N;i++) {
			board[i][i]=0;
		}
		for (int i = 0; i < M; i++) {
			String[] tmp = in.readLine().split(" ");
			int from = Integer.parseInt(tmp[0]);
			int to = Integer.parseInt(tmp[1]);
			int cost = Integer.parseInt(tmp[2]);
			board[from - 1][to - 1] = Math.min(board[from-1][to-1], cost);
		}


		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {

					board[i][j] = Math.min(board[i][j], board[i][k] + board[k][j]);

				}
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(board[i][j]==999999999) {
					board[i][j]=0;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for(int j=0;j<N;j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}

	}
	
}