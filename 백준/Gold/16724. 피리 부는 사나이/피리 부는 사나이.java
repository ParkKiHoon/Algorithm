import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] split = in.readLine().split(" ");
		int N = Integer.parseInt(split[0]);
		int M = Integer.parseInt(split[1]);

		map = new HashMap<>();
		map.put('U', 0);
		map.put('D', 1);
		map.put('L', 2);
		map.put('R', 3);

		int cnt = 0;

		visited = new int[N][M];
		board = new char[N][M];
		for (int i = 0; i < N; i++) {
			String str = in.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = str.charAt(j);

			}
		}

		int ind = 2;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int nx = i + dx[map.get(board[i][j])];
				int ny = j + dy[map.get(board[i][j])];
				if (visited[nx][ny] == 0) {
					sig = 0;
					visited[i][j] = ind;
					visited[nx][ny] = ind;
					dfs(nx, ny, ind);
					if (sig == 0) {
						cnt++;
					}
					ind++;
				}
			}
		}

		System.out.println(cnt);
	}

	static HashMap<Character, Integer> map;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static char[][] board;
	static int[][] visited;
	static int sig;

	private static void dfs(int i, int j, int ind) {
		int nx = i + dx[map.get(board[i][j])];
		int ny = j + dy[map.get(board[i][j])];
		if (visited[nx][ny] == 0) {
			visited[nx][ny] = ind;
			dfs(nx, ny, ind);
		} else {
			if (visited[nx][ny] != ind) {
				sig = 1;
			}
		}
	}

}