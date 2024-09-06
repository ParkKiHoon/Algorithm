import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(in.readLine());
		String[] split = in.readLine().split(" ");
		int M = Integer.parseInt(split[0]);
		int N = Integer.parseInt(split[1]);

		int[][] board = new int[N][M];
		int[][][] visited = new int[N][M][K+1];
		for (int i = 0; i < N; i++) {
			String[] tmp = in.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(tmp[j]);
			}
		}

		Deque<int[]> deque = new ArrayDeque<>();
		deque.add(new int[] { 0, 0, 0, 0 });

		int[] dxMonkey = { 0, 0, 1, -1 };
		int[] dyMonkey = { 1, -1, 0, 0 };
		int[] dxHorse = { -1, -2, -2, -1, 1, 2, 2, 1 };
		int[] dyHorse = { -2, -1, 1, 2, 2, 1, -1, -2 };

		int ans=-1;
		while (!deque.isEmpty()) {
			int[] q = deque.pollFirst();
			int x = q[0];
			int y = q[1];
			int k = q[2];
			int cnt = q[3];
			if (x == N-1 && y == M-1) {
				ans=cnt;
				break;
			}

			// 말의 점프
			if (k < K) {
				for (int i = 0; i < 8; i++) {
					int nx = x + dxHorse[i];
					int ny = y + dyHorse[i];
					if (nx >= 0 && nx < N && ny >= 0 && ny < M ) {
						if (board[nx][ny] == 0 && visited[nx][ny][k+1]==0) {
							visited[nx][ny][k+1]=1;
							deque.add(new int[] { nx, ny, k + 1, cnt + 1 });
						}
					}
				}
			}

			// 원숭이 점프
			for (int i = 0; i < 4; i++) {
				int nx = x + dxMonkey[i];
				int ny = y + dyMonkey[i];
				if (nx >= 0 && nx < N && ny >= 0 && ny < M ) {
					if (board[nx][ny] == 0 && visited[nx][ny][k]==0) {
						visited[nx][ny][k]=1;
						deque.add(new int[] { nx, ny, k, cnt + 1 });
					}
				}
			}
		}
		
		System.out.println(ans);
	}

}