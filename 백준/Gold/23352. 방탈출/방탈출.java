import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split=in.readLine().split(" ");
		N=Integer.parseInt(split[0]);
		M=Integer.parseInt(split[1]);
		
		board=new int[N][M];
		ArrayList<int[]> arr=new ArrayList<>();
		for(int i=0;i<N;i++) {
			String[] tmp=in.readLine().split(" ");
			for(int j=0;j<M;j++) {
				board[i][j]=Integer.parseInt(tmp[j]);
				if(board[i][j]>0) {
					arr.add(new int[] {i,j,1});
				}
			}
		}
		
		queue=new PriorityQueue<int[]>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o2[0]==o1[0]) {
					return o2[1]-o1[1];
				}else {
					return o2[0]-o1[0];
				}
			}
		});
		for(int[] a:arr){
			bfs(a);
		}
		System.out.println(queue.poll()[1]);

	}

	static int[] dx= {0,0,1,-1};
	static int[] dy= {1,-1,0,0};
	static int[][] board;
	static PriorityQueue<int[]> queue;
	static int N;
	static int M;
	private static void bfs(int[] a) {
		Deque<int[]> deque=new ArrayDeque<>();
		deque.add(a);
		
		int[][] visited=new int[N][M];
		visited[a[0]][a[1]]=1;
		while(!deque.isEmpty()) {
			int[] q=deque.poll();
			int x=q[0];
			int y=q[1];
			int cur=q[2];
			int cnt=0;
			for(int i=0;i<4;i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				if(nx>=0 && nx<N && ny>=0 && ny<M && visited[nx][ny]==0 && board[nx][ny]!=0) {
					visited[nx][ny]=1;
					deque.add(new int[] {nx,ny,cur+1});
					cnt++;
				}
			}
			if(cnt==0) {
				queue.add(new int[] {cur-a[2],board[x][y]+board[a[0]][a[1]]});
			}
		}
	}

}