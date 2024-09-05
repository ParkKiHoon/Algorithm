import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		arr1 = new int[N][N];
		arr2 = new int[N][N];
		visited1 = new int[N][N];
		visited2 = new int[N][N];

		for (int i = 0; i < N; i++) {
			String[] tmp = in.readLine().split("");
			for (int j = 0; j < N; j++) {
				//system.out.println(tmp[j]);
				if (tmp[j].equals("R")) {
					arr1[i][j] = 1;
				} else if (tmp[j].equals("G")) {
					arr1[i][j] = 2;
				} else if (tmp[j].equals("B")){
					arr1[i][j] = 3;
				}
			}

			for (int j = 0; j < N; j++) {
				if (tmp[j].equals("R") || tmp[j].equals("G")) {
					arr2[i][j] = 1;
				} else if (tmp[j].equals("B")) {
					arr2[i][j] = 3;
				}
			}
		}

		int cnt1=0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited1[i][j] == 0) {
					bfs1(i, j);
					cnt1++;
				}
			}
		}
		
		int cnt2=0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited2[i][j] == 0) {
					bfs2(i, j);
					cnt2++;
				}
			}
		}
		System.out.println(cnt1+" " +cnt2);
	}

	static int N;
	static int[][] arr1;
	static int[][] arr2;
	static int[][] visited1;
	static int[][] visited2;
	static int[] dx= {1,-1,0,0};
	static int[] dy= {0,0,1,-1};
	private static void bfs1(int i, int j) {
		Deque<int[]> deque = new ArrayDeque<>();
		deque.addLast(new int[] { i, j });
		visited1[i][j] = 1;
		int sig = arr1[i][j];
		while (!deque.isEmpty()) {
			int[] q=deque.pollFirst();
			int cx=q[0];
			int cy=q[1];
			for(int i2=0;i2<4;i2++) {
				int nx=cx+dx[i2];
				int ny=cy+dy[i2];
				if(nx>=0 && nx<N && ny>=0 && ny<N && visited1[nx][ny]==0 && arr1[nx][ny]==sig) {
					visited1[nx][ny]=1;
					deque.offerLast(new int[] {nx,ny});
				}
			}
		}
	}
	
	private static void bfs2(int i, int j) {
		Deque<int[]> deque = new ArrayDeque<>();
		deque.addLast(new int[] { i, j });
		visited2[i][j] = 1;
		int sig = arr2[i][j];
		while (!deque.isEmpty()) {
			int[] q=deque.pollFirst();
			int cx=q[0];
			int cy=q[1];
			for(int i2=0;i2<4;i2++) {
				int nx=cx+dx[i2];
				int ny=cy+dy[i2];
				if(nx>=0 && nx<N && ny>=0 && ny<N && visited2[nx][ny]==0 && arr2[nx][ny]==sig) {
					visited2[nx][ny]=1;
					deque.offerLast(new int[] {nx,ny});
				}
			}
		}
	}
}