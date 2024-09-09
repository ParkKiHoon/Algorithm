import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[][][] arr = { 
			
			{ { 0, 0 }, { 0, 1 }, { 0, 2 }, { 0, 3 } },
			{ { 0, 0 }, { 0, -1 }, { 0, -2 }, { 0, -3 } },
			{ { 0, 0 }, { 1, 0 }, { 2, 0 }, { 3, 0 } },
			{ { 0, 0 }, { -1, 0 }, { -2, 0 }, { -3, 0 } },
			
			{ { 0, 0 }, { 0, 1 }, { 1, 1 }, { 1, 2 } },
			{ { 0, 0 }, { 1, 0 }, { 1, -1 }, { 2, -1 } },
			{ { 0, 0 }, { 0, -1 }, { -1, -1 }, { -1, -2 } },
			{ { 0, 0 }, { -1, 0 }, { -1, 1 }, { -2, 1 } },
			
			{ { 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 2 } },
			{ { 0, 0 }, { 1, 0 }, { 2, 0 }, { 2, -1 } },
			{ { 0, 0 }, { 0, -1 }, { 0, -2 }, { -1, -2 } },
			{ { 0, 0 }, { -1, 0 }, { -2, 0 }, { -2, 1 } },
			
			{ { 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 1 } },
			{ { 0, 0 }, { 1, 0 }, { 2, 0 }, { 1, -1 } },
			{ { 0, 0 }, { 0, -1 }, { 0, -2 }, { -1, -1 } },
			{ { 0, 0 }, { -1, 0 }, { -2, 0 }, { -1, 1 } },
			
			{ { 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 2 } },
			{ { 0, 0 }, { 1, 0 }, { 2, 0 }, { 2, -1 } },
			{ { 0, 0 }, { 0, -1 }, { 0, -2 }, { -1, -2 } },
			{ { 0, 0 }, { -1, 0 }, { -2, 0 }, { -2, 1 } },

			{ { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, 1 } },
			{ { 0, 0 }, { 1, 0 }, { 0, -1 }, { 1, -1 } },
			{ { 0, 0 }, { 0, -1 }, { -1, 0 }, { -1, -1} },
			{ { 0, 0 }, { 0, 1 }, { -1, 0 }, { -1, 1 } },
		
	};
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int cycle=1;
		while(true) {
			int N = Integer.parseInt(in.readLine().trim());
			if(N==0) {
				break;
			}
			int[][] board = new int[N][N];
			for (int i = 0; i < N; i++) {
				String[] split = in.readLine().split("\\s+");
				if (split.length > N) {
					for (int j = 0; j < N; j++) {
						board[i][j] = Integer.parseInt(split[j + 1]);
					}
				} else {
					for (int j = 0; j < N; j++) {
						board[i][j] = Integer.parseInt(split[j]);
					}
				}
			}

		
			int ans=Integer.MIN_VALUE;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					for(int[][] a : arr) {

						int sum=0;
						int cnt=0;
						for(int x=0;x<4;x++) {
							int cx=i+a[x][0];
							int cy=j+a[x][1];
							if(cx>=0 && cx<N && cy>=0 && cy<N) {
								sum+=board[cx][cy];
								cnt++;
							}
						}
						if(cnt==4) {
							ans=Math.max(ans, sum);
						}
					}
				}
			}
			System.out.println(cycle+". "+ans);
			cycle++;
		}
	}

}