import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T;
		T = Integer.parseInt(in.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");

			N = Integer.parseInt(in.readLine());
			board = new int[N][N];
			visited = new int[N][N];
			ans = 0;
			for (int i = 0; i < N; i++) {
				String[] split = in.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(split[j]);
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dfs(i, j, 1, board[i][j], board[i][j]);
				}
			}
			sb.append(roomNum);
			sb.append(' ');
			sb.append(ans);
			sb.append('\n');

		}

		System.out.println(sb);
	}

	static int N;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int[][] board;
	static int[][] visited;
	static int ans;
	static int roomNum = Integer.MAX_VALUE;

	private static void dfs(int x, int y, int sum, int before, int start) {
		if (sum == ans) {
			if (start < roomNum) {
				roomNum = start;
			}
		} else if (sum > ans) {
			roomNum = start;
		}
		ans = Math.max(ans, sum);

		for (int i = 0; i < 4; i++) {
			int cx = x + dx[i];
			int cy = y + dy[i];
			if (cx >= 0 && cx < N && cy >= 0 && cy < N && visited[cx][cy] == 0 && board[cx][cy] == before + 1) {
				visited[cx][cy] = 1;
				dfs(cx, cy, sum + 1, board[cx][cy], start);
				visited[cx][cy] = 0;
			}
		}
	}

}