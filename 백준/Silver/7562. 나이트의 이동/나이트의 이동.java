import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in= new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int T=Integer.parseInt(in.readLine());
		
		int[] dx= {-2,-2,-1,1,2,2,1,-1};
		int[] dy= {-1,1,2,2,1,-1,-2,-2};
		
		for(int tc=1;tc<=T;tc++) {
			int N=Integer.parseInt(in.readLine());
			int[][] board=new int[N][N];
			int[][] visited=new int[N][N];
			String[] split=in.readLine().split(" ");
			int x=Integer.parseInt(split[0]);
			int y=Integer.parseInt(split[1]);
			split=in.readLine().split(" ");
			int tx=Integer.parseInt(split[0]);
			int ty=Integer.parseInt(split[1]);
			
			PriorityQueue<int[]> queue=new PriorityQueue<>(new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					// TODO Auto-generated method stub
					return o1[2]-o2[2];
				}
			});
			
			
			queue.add(new int[] {x,y,0});
			
			while(!queue.isEmpty()) {
				int[] q=queue.poll();
				int curX=q[0];
				int curY=q[1];
				int curCnt=q[2];
				
				if(curX==tx && curY==ty) {
					sb.append(curCnt);
					sb.append("\n");
					break;
				}
			
				for(int i=0;i<8;i++) {
					int nx=curX+dx[i];
					int ny=curY+dy[i];
					if(nx>=0 && nx<N && ny>=0 && ny<N && visited[nx][ny]==0) {
						visited[nx][ny]=1;
						queue.add(new int[] {nx,ny,curCnt+1});
					}
				}
			}
			
		}
		System.out.println(sb);
	}	
}