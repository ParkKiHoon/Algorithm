import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };
		int T = Integer.parseInt(in.readLine());
		for (int Time = 1; Time <= T; Time++) {
			String[] split = in.readLine().split(" ");
			int N = Integer.parseInt(split[0]);
			int M = Integer.parseInt(split[1]);
			board = new char[N + 2][M + 2];
			for (int i = 0; i < N + 2; i++) {
				Arrays.fill(board[i], '.');
			}
			for (int i = 0; i < N; i++) {
				String str = in.readLine();
				for (int j = 0; j < M; j++) {
					board[i + 1][j + 1] = str.charAt(j);
				}
			}
			Deque<int[]>[] door = new ArrayDeque[26];
			for (int i = 0; i < 26; i++) {
				door[i] = new ArrayDeque<int[]>();
			}

			int myKey = 0;
			String keys = in.readLine();
			if (!keys.equals("0")) {
				for (char key : keys.toCharArray()) {
					myKey |= (1 << (key - 'a'));
				}
			}
			int ans = 0;
			visited = new int[N + 2][M + 2];
			Deque<int[]> deque = new ArrayDeque<int[]>();
			deque.offer(new int[] { 0, 0 });
			visited[0][0] = 1;
			while (!deque.isEmpty()) {
				int[] q = deque.pollFirst();
				int x = q[0];
				int y = q[1];
				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					if (nx >= 0 && nx < N+2 && ny >= 0 && ny < M+2 && visited[nx][ny] == 0) {
						if (board[nx][ny] == '$') {
							ans++;
							deque.offer(new int[] { nx, ny });
							visited[nx][ny] = 1;
						} else if ('a' <= board[nx][ny] && board[nx][ny] <= 'z') {
							myKey |= (1 << (board[nx][ny] - 'a'));
							deque.offer(new int[] { nx, ny });
							visited[nx][ny] = 1;
							while (!door[board[nx][ny] - 'a'].isEmpty()) {
								deque.offerLast(door[board[nx][ny] - 'a'].pollFirst());
							}
						} else if ('A' <= board[nx][ny] && board[nx][ny] <= 'Z') {
							if ((myKey & (1 << (board[nx][ny] - 'A'))) > 0) {
								deque.offer(new int[] { nx, ny });
								visited[nx][ny] = 1;
							} else {
								door[board[nx][ny] - 'A'].add(new int[] { nx, ny });
							}
						} else if (board[nx][ny] == '.') {
							deque.offer(new int[] { nx, ny });
							visited[nx][ny] = 1;
						}
					}
				}
			}
			System.out.println(ans);
		}
	}

	static char[][] board;
	static int[][] visited;

	static int check(int i, int j) {
		return 1;
	}
}