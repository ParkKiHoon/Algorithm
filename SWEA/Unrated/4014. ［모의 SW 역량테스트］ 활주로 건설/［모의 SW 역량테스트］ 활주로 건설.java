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

			String[] split = in.readLine().split(" ");
			N = Integer.parseInt(split[0]);
			X = Integer.parseInt(split[1]);
			int[][] board = new int[N][N];
			for (int i = 0; i < N; i++) {
				String[] tmp = in.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(tmp[j]);
				}
			}

			int ans = 0;
			for (int i = 0; i < N; i++) {
				int[] garo = new int[N];
				int[] sero = new int[N];

				for (int j = 0; j < N; j++) {
					garo[j] = board[i][j];
					sero[j] = board[j][i];
				}
				ans += sol(garo);
				ans += sol(sero);
			}

			sb.append(ans);
			sb.append("\n");
		}

		System.out.println(sb);
	}

	static int N;
	static int X;

	private static int sol(int[] arr) {
		int[] visited=new int[N];
		int[] construct=new int[N];
		for (int i = 0; i < N-1; i++) {
			if(visited[i]==1) {
				continue;
			}
			// 올라갈때
			if (arr[i + 1] == arr[i] + 1) {
				if(i-X+1<0) {
					return 0;
				}else {
					for(int j=0;j<X;j++) {
						if(arr[i-j]!=arr[i] || visited[i-j]==1 || construct[i-j]==1) {
							return 0;
						}
					}
				}
			}
			// 내려갈때
			else if (arr[i + 1] == arr[i] - 1) {
				if(i+X>=N) {
					return 0;
				}else {
					for(int j=1;j<=X;j++) {
						if(arr[i+j]!=arr[i]-1) {
							return 0;
						}
						arr[i+j]=arr[i];
						visited[i+j]=1;
					}
					arr[i+X]=arr[i]-1;
					visited[i+X]=0;
					visited[i]=1;
					construct[i+X]=1;
				}
			}else if(Math.abs(arr[i+1]-arr[i])>1) {
				return 0;
			}
		}
		return 1;
	}

}