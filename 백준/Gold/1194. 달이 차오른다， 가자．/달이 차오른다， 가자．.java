import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		int N = Integer.parseInt(split[0]);
		int M = Integer.parseInt(split[1]);
		char[][] board = new char[N][M];

		int startX = 0;
		int startY = 0;
		for (int i = 0; i < N; i++) {
			String[] tmp = in.readLine().split("");
			for (int j = 0; j < M; j++) {
				board[i][j] = tmp[j].charAt(0);
				if (board[i][j] == '0') {
					startX = i;
					startY = j;
				}
			}
		}

		int ans=-1;
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };
		Deque<int[]> deque = new ArrayDeque<>();
		deque.add(new int[] { startX, startY, 0, 0 });
		int[][][] visited = new int[N][M][1 << (6+1)];
		while (!deque.isEmpty()) {
			int[] q = deque.pollFirst();
			int x = q[0];
			int y = q[1];
			int key = q[2];
			int cnt = q[3];

			if (board[x][y] == '1') {
				ans=cnt;
				break;
			}

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx >= 0 && nx < N && ny >= 0 && ny < M && visited[nx][ny][key] == 0) {
					if (65 <= board[nx][ny] && board[nx][ny] <= 70 && (key & (1 << board[nx][ny] - 64)) > 0) {
						visited[nx][ny][key] = 1;
						deque.add(new int[] { nx, ny, key, cnt + 1 });
					} else if (97 <= board[nx][ny] && board[nx][ny] <= 102) {
						visited[nx][ny][key] = 1;
						deque.add(new int[] { nx, ny, key | (1 << (board[nx][ny] - 96)), cnt + 1 });
					} else if (board[nx][ny] == '.' || board[nx][ny] == '0'|| board[nx][ny] == '1') {
						visited[nx][ny][key] = 1;
						deque.add(new int[] { nx, ny, key, cnt + 1 });
					}
				}
			}
		}
		System.out.println(ans);
	}
}