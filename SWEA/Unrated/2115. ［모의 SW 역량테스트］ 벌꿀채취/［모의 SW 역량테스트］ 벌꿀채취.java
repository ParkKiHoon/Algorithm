import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T;
		T = Integer.parseInt(in.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");

			String[] split = in.readLine().split(" ");
			N = Integer.parseInt(split[0]);
			M = Integer.parseInt(split[1]);
			C = Integer.parseInt(split[2]);

			board = new int[N][N];
			int[][] dp = new int[N][N];
			for (int i = 0; i < N; i++) {
				String[] tmp = in.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(tmp[j]);
				}
			}

			PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					return o2[0] - o1[0];
				}
			});

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (j + M <= N) {
						queue.add(new int[] { knapsack(i, j), i, j });
					}
				}
			}

			int[] first = queue.poll();
			int firstVal = first[0];
			int firstX = first[1];
			int firstY = first[2];
			while (true) {
				int[] second = queue.poll();
				int secondVal = second[0];
				int secondX = second[1];
				int secondY = second[2];

				if (firstX != secondX) {
					sb.append(firstVal + secondVal);
					break;
				} else if (firstX == secondX && Math.abs(firstY-secondY)>=M) {
					sb.append(firstVal + secondVal);
					break;
				}
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

	static int N;
	static int M;
	static int C;
	static int[][] board;

	private static int knapsack(int x, int y) {

		int[] weights = new int[M + 1];
		int[] values = new int[M + 1];
		for (int i = 0; i < M; i++) {
			weights[i + 1] = board[x][y + i];
			values[i + 1] = board[x][y + i] * board[x][y + i];
		}
		int[][] dp = new int[M + 1][C + 1];
		for (int i = 1; i <= M; i++) {
			int weight = weights[i];
			int value = values[i];
			for (int j = 1; j <= C; j++) {
				if (weight <= j) {
					dp[i][j] = Math.max(dp[i - 1][j], value + dp[i - 1][j - weight]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[M][C];

	}

}