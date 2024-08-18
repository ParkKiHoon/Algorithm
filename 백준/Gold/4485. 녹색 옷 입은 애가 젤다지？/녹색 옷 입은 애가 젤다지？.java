
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	static int N;
	static int[][] map;
	static int[][] distance;
	static int[][] visited;
	static int INF = Integer.MAX_VALUE;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int cnt=0;
		while (true) {
			cnt++;
			N = Integer.parseInt(in.readLine());
			if(N==0) {
				break;
			}
			map = new int[N][N];
			distance = new int[N][N];
			visited = new int[N][N];
			int x = 0;
			int y = 0;

			for (int i = 0; i < N; i++) {
				String[] tmp = in.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(tmp[j]);
					distance[i][j] = INF;
					visited[i][j] = 0;
				}
			}
			distance[0][0] = map[0][0];
			visited[0][0] = 1;

			PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[2] - o2[2];
				}
			});
			queue.add(new int[] { 0, 0, 0 });
			while (!queue.isEmpty()) {
				int[] q = queue.poll();
				x = q[0];
				y = q[1];
				for (int i = 0; i < 4; i++) {
					int nx = q[0] + dx[i];
					int ny = q[1] + dy[i];
					// int w=q[2];
					if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
						if (distance[nx][ny] > distance[x][y] + map[nx][ny]) {
							distance[nx][ny] = distance[x][y] + map[nx][ny];
							queue.add(new int[] { nx, ny, distance[nx][ny] });
						}
					}

				}
			}
			System.out.println("Problem "+cnt+": "+distance[N-1][N-1]);
		}

	}
}
