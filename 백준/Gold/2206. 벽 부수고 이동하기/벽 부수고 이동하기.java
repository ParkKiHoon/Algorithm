import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] split = in.readLine().split(" ");
		int N = Integer.parseInt(split[0]);
		int M = Integer.parseInt(split[1]);

		int[][] board = new int[N][M];
		for (int i = 0; i < N; i++) {
			split = in.readLine().split("");
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(split[j]);
			}
		}

		int[][][] visited = new int[N][M][2];

		Deque<int[]> deque = new ArrayDeque<>();
		deque.offer(new int[] { 0, 0, 1, 0 });
		visited[0][0][0] = 1;

		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };

		while (!deque.isEmpty()) {
			int[] q = deque.pollFirst();
			int x = q[0];
			int y = q[1];
			int cost = q[2];
			int sign = q[3];

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
					if (board[nx][ny] == 1 && sign == 0) {
						if (visited[nx][ny][1] == 0) {
							visited[nx][ny][1] = cost+1;
							deque.offerLast(new int[] { nx, ny, cost + 1, 1 });
						}
					} else if (board[nx][ny] == 0) {
						if (visited[nx][ny][sign] == 0) {
							visited[nx][ny][sign] = cost+1;
							deque.offerLast(new int[] { nx, ny, cost + 1, sign });
						}
					}

				}
			}

		}

		int tmp=Math.min(visited[N - 1][M - 1][0]==0?999999999:visited[N - 1][M - 1][0],
				visited[N - 1][M - 1][1]==0?999999999:visited[N - 1][M - 1][1]);
		
		System.out.println(tmp==999999999?-1 :tmp);
	}
}