import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());
		int[][] board = new int[N][N];
		for (int i = 0; i < N; i++) {
			String[] tmp = in.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(tmp[j]);
				if (board[i][j] == 1) {
					board[i][j] = -1;
				}
			}
		}

		int[][][] dp = new int[N][N][3];
		dp[0][1][0] = 1;
		for (int i = 2; i < N; i++) {
			if (board[0][i] != -1) {
				dp[0][i][0] = dp[0][i - 1][0];
			}
		}
		for (int i = 1; i < N; i++) {
			for (int j = 2; j < N; j++) {
				if (board[i][j] == -1) {
					continue;
				}

				if (board[i][j] != -1) {
					dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][1];
				}

				if (board[i][j] != -1 && board[i][j - 1] != -1 && board[i - 1][j] != -1) {
					dp[i][j][1] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
				}

				if (board[i][j] != -1) {
					dp[i][j][2] = dp[i - 1][j][1] + dp[i - 1][j][2];
				}
			}

		}
		System.out.println(dp[N - 1][N - 1][0] + dp[N - 1][N - 1][1] + dp[N - 1][N - 1][2]);
	}
}