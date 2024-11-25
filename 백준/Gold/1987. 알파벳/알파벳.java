import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] split=in.readLine().split(" ");
		N=Integer.parseInt(split[0]);
		M=Integer.parseInt(split[1]);
		board=new char[N][M];
		for(int i=0;i<N;i++) {
			String str=in.readLine();
			for(int j=0;j<M;j++) {
				board[i][j]=str.charAt(j);
			}
		}
		
		ans=0;
		int[] visited=new int[91];
		char start=board[0][0];
		visited[start-0]=1;
		dfs(0,0,visited,1);
		System.out.println(ans);
	}

	static int N;
	static int M;
	static char[][] board;
	static int[] dx= {1,-1,0,0};
	static int[] dy= {0,0,1,-1};
	static int ans;
	private static void dfs(int x,int y, int[] visited,int sum) {
		
		ans=Math.max(ans, sum);
		
		for(int i=0;i<4;i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			if(nx>=0 && nx<N && ny>=0 && ny<M) {
				int next=board[nx][ny]-0;
				if(visited[next]==0) {
					visited[next]=1;
					dfs(nx,ny,visited,sum+1);
					visited[next]=0;
				}
			}
		}
	}
}