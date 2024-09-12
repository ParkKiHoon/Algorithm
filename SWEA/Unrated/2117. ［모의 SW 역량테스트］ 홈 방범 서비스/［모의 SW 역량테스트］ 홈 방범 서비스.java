import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T;
		T = Integer.parseInt(in.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");

			ans = 0;
			cnt = 0;
			finish=0;
			String[] split = in.readLine().split(" ");
			N = Integer.parseInt(split[0]);
			M = Integer.parseInt(split[1]);
			board = new int[N][N];
			for (int i = 0; i < N; i++) {
				String[] tmp = in.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(tmp[j]);
					if (board[i][j] == 1) {
						cnt++;
					}
				}
			}

			if (N % 2 == 0) {
				for (int i = N + 1; i > 0; i--) {
					sol(i);
					if(finish==1) {
						break;
					}
				}
			} else {
				for (int i = N; i > 0; i--) {
					sol(i);
					if(finish==1) {
						break;
					}
				}
			}
			sb.append(ans);
			sb.append("\n");
		}

		System.out.println(sb);
	}

	static int N;
	static int M;
	static int ans = 0;
	static int cnt = 0;
	static int finish;
	static int[][] board;
	private static void sol(int n) {
		if (n > N) {
			if (n * n + (n - 1) * (n - 1) <= cnt * M) {
				ans=cnt;
				finish=1;
				return;
			}
		}
		//System.out.println(n + "AAAAAAAAA");
		int gap = (n - 1) / 2;
		for (int i = gap; i + gap < N; i++) {
			for (int j = gap; j + gap < N; j++) {
				//System.out.println(i + " " + j);
				getCnt(i,j,n);
			}
		}
	}
	
	private static void getCnt(int x,int y,int n) {
		int home=0;
		for(int i=-(n-1);i<=(n-1);i++) {
			for(int j=-(n-1);j<=(n-1);j++) {
				if(Math.abs(i)+Math.abs(j)>=n) {
					continue;
				}
				int nx=i+x;
				int ny=j+y;
				if(nx>=0 && nx<N && ny>=0 && ny<N) {
					if(board[nx][ny]==1) {
						home++;
					}
				}
			}
		}
		if(n*n+(n-1)*(n-1)<=home*M) {
			ans=Math.max(ans, home);
		}
	}

}