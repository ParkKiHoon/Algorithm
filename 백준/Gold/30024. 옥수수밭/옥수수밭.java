import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[0] - o1[0];
			}
		});

		String[] split = in.readLine().split(" ");
		int N = Integer.parseInt(split[0]);
		int M = Integer.parseInt(split[1]);
		int[][] board = new int[N][M];
		int[][] visited = new int[N][M];
		for (int i = 0; i < N; i++) {
			split = in.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(split[j]);
				if (i == 0 || j == 0 || i == N - 1 || j == M - 1) {
					pq.offer(new int[] { board[i][j], i, j });
					visited[i][j] = 1;
				}
			}
		}
		int K = Integer.parseInt(in.readLine());

		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };
		for (int i = 0; i < K; i++) {
			int[] cur = pq.poll();
			System.out.println((cur[1]+1) + " " + (cur[2]+1));
			for (int n = 0; n < 4; n++) {
				int nx = cur[1] + dx[n];
				int ny = cur[2] + dy[n];
				if (nx >= 0 && nx < N && ny >= 0 && ny < M && visited[nx][ny] == 0) {
					visited[nx][ny] = 1;
					pq.offer(new int[] { board[nx][ny], nx, ny });
				}
			}
		}

	}
}