import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

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
			int N = Integer.parseInt(split[0]);
			int[][] board = new int[N][N];
			int[] order = new int[N * N];
			for (int i = 1; i < split.length; i++) {
				order[i - 1] = Integer.parseInt(split[i]);
			}


			int ind = 0;
			for (int i = 0; i < N * N; i += N) {
				for (int j = 0; j < N; j++) {
					if (order[i + j] == 0) {
						board[ind][j] = 99999999;
					} else {
						board[ind][j] = order[i + j];
					}
				}
				ind++;
			}
			for (int i = 0; i < N; i++) {
				board[i][i]=0;
			}
			

			

			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (i != j) {
							board[i][j] = Math.min(board[i][j], board[i][k] + board[k][j]);
						}
					}
				}
			}

			
			int ans=Integer.MAX_VALUE;
			for(int i=0;i<N;i++) {
				ans=Math.min(ans, Arrays.stream(board[i]).sum());
			}
			sb.append(ans);
			sb.append("\n");
		}

		System.out.println(sb);
	}

}