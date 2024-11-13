import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static int N, M;
	private static char[][] map;
	private static boolean[][][] visited;

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		visited = new boolean[N][M][64];

		int sx = -1, sy = -1;
		for (int i = 0; i < N; i++) {
			String split = in.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = split.charAt(j);
				if (map[i][j] == '0') { // 시작 위치
					sx = i;
					sy = j;
				}
			}
		}

		int ans = maze(sx, sy);
		System.out.println(ans);

	}

	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };

	private static int maze(int x, int y) {

		Queue<int[]> queue = new ArrayDeque<int[]>();
		queue.offer(new int[] { x, y, 0, 0 });
		visited[x][y][0] = true;

		while (!queue.isEmpty()) {

			int[] curr = queue.poll();
			x = curr[0];
			y = curr[1];
			int steps = curr[2];
			int keys = curr[3];

			if (map[x][y] == '1') {
				return steps;
			}

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny][keys]) {
					continue;
				}

				if (map[nx][ny] == '#')
					continue;

				// 열쇠인 경우
				else if (map[nx][ny] >= 'a' && map[nx][ny] <= 'z') {
					int newKey = keys | 1 << (map[nx][ny] - 'a');
					if (!visited[nx][ny][newKey]) {
						visited[nx][ny][newKey] = true;
						queue.offer(new int[] { nx, ny, steps + 1, newKey });
					}

				}

				// 문인 경우
				else if (map[nx][ny] >= 'A' && map[nx][ny] <= 'Z') {
					int requireKeys = 1 << (map[nx][ny] - 'A');
					if ((requireKeys & keys) != 0) { // 1이면 해당 키가 있음
						visited[nx][ny][keys] = true;
						queue.offer(new int[] { nx, ny, steps + 1, keys });
					}
					
				} else {
					visited[nx][ny][keys] = true;
					queue.offer(new int[] { nx, ny, steps + 1, keys });
				}

			}

		}

		return -1;

	}

}