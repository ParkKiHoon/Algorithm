import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] split = in.readLine().split(" ");
		N = Integer.parseInt(split[0]);
		M = Integer.parseInt(split[1]);

		board = new int[N][M];
		for (int i = 0; i < N; i++) {
			split = in.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(split[j]);
				if (board[i][j] == 1) {
					cnt++;
				}
			}
		}

		int ans = 0;
		while (cnt > 0) {
			getEdge(0, 0);
			ans++;
		}
		System.out.println(ans);
	}

	static int cnt;
	static int[][] board;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int N;
	static int M;

	private static void getEdge(int x2, int y2) {
		Deque<int[]> deque = new ArrayDeque<>();
		deque.offer(new int[] { x2, y2 });
		int[][] visited = new int[N][M];
		visited[x2][y2] = 1;
		HashMap<String, Integer> map = new HashMap<>();
		while (!deque.isEmpty()) {
			int[] q = deque.pollFirst();
			int x = q[0];
			int y = q[1];
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
					if (visited[nx][ny] == 0 && board[nx][ny]==0) {
						visited[nx][ny] = 1;
						deque.offer(new int[] { nx, ny });
					} else {
						if (board[nx][ny] == 1) {
							String str = nx + "," + ny;
							if (map.containsKey(str)) {
								map.replace(str, map.get(str) + 1);
							} else {
								map.put(str, 1);
							}
						}
					}
				}
			}
		}
		for (String str : map.keySet()) {
			if (map.get(str) >= 2) {

				String[] split = str.split(",");
				board[Integer.parseInt(split[0])][Integer.parseInt(split[1])] = 0;
				cnt--;
			}
		}

	}
}