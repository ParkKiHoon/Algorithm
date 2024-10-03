import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] split = in.readLine().split(" ");
		N = Integer.parseInt(split[0]);
		M = Integer.parseInt(split[1]);
		board = new int[N][M];
		visited = new int[N][M];
		ans = 0;
		for (int i = 0; i < N; i++) {
			String[] tmp = in.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(tmp[j]);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j] = 1;
				dfs(i, j, 1, board[i][j]);
				visited[i][j] = 0;
			}
		}
		System.out.println(ans);
	}

	static int[][] board;
	static int[][] visited;
	static int[] dx = { 0, 0, 1, -1, -1, -1, 1, 1 };
	static int[] dy = { 1, -1, 0, 0, -1, 1, 1, -1 };
	static int ans;
	static int N;
	static int M;

	private static void dfs(int x, int y, int cnt, int sum) {
		if (cnt == 4) {
			ans = Math.max(ans, sum);
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && nx < N && ny >= 0 && ny < M && visited[nx][ny] == 0) {
				visited[nx][ny] = 1;
				dfs(nx, ny, cnt + 1, sum + board[nx][ny]);
				visited[nx][ny] = 0;
			}
		}
		if (cnt == 3) {
			for (int i = 4; i < 8; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx >= 0 && nx < N && ny >= 0 && ny < M && visited[nx][ny] == 0) {
					if ((nx - 1 >= 0 && visited[nx - 1][ny] == 1) || (nx + 1 < N && visited[nx + 1][ny] == 1)
							|| (ny - 1 >= 0 && visited[nx][ny - 1] == 1) || (ny + 1 < M && visited[nx][ny + 1] == 1)) {
						visited[nx][ny] = 1;
						dfs(nx, ny, cnt + 1, sum + board[nx][ny]);
						visited[nx][ny] = 0;
					}
				}
			}
		}
	}
}