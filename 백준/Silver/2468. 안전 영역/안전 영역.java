import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[][] board = new int[N][N];
		int min = 99999999;
		int max = 0;
		for (int i = 0; i < N; i++) {
			String[] split = in.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(split[j]);
				min = Math.min(board[i][j], min);
				max = Math.max(board[i][j], max);

			}
		}

		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };
		int ans=0;
		for (int h = min - 1; h < max + 1; h++) {
			int[][] visited = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (board[i][j] <= h) {
						visited[i][j] = 1;
					}
				}
			}


			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visited[i][j] == 1) {
						continue;
					}
					Deque<int[]> deque = new ArrayDeque<>();
					deque.offerLast(new int[] { i, j });
					cnt++;
					while(!deque.isEmpty()) {
						int[] q = deque.pollFirst();
						if(visited[q[0]][q[1]]==1) {
							continue;
						}
						visited[q[0]][q[1]]=1;
						for(int n=0;n<4;n++) {
							int nx=q[0]+dx[n];
							int ny=q[1]+dy[n];
							if(nx>=0 && nx <N && ny>=0 && ny<N) {
								if(visited[nx][ny]==0) {
									deque.offer(new int[] {nx,ny});
								}
							}
						}
					}
				}
			}
			ans=Math.max(ans, cnt);
		}
		System.out.println(ans);
	}
}