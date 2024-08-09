import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    static int[] dx= {0,1,0,-1};
    static int[] dy= {1,0,-1,0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T;
		T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");
			String fil_yo_up_neunn_gap=in.readLine();
			int[][] arr= new int[16][16];
			int[][] visited=new int[16][16];
			int startX = 0;
			int startY=0;
			int endX=0;
			int endY=0;
			
			for(int i=0; i<16;i++) {
				String[] split=in.readLine().split("");
				for(int j=0;j<16;j++) {
					arr[i][j]=Integer.parseInt(split[j]);
					if(arr[i][j]==1) {
						visited[i][j]=1;
					}
					if(Integer.parseInt(split[j])==2) {
						startX=i;
						startY=j;
					}else if(Integer.parseInt(split[j])==3){
						endX=i;
						endY=j;
					}
				}
			}
			
			Deque<int[]> queue=new ArrayDeque<>();
			queue.push(new int[] {startX,startY});
			int success=0;
			while(!queue.isEmpty()) {
				int[] tmp=queue.removeFirst();
				int cx=tmp[0];
				int cy=tmp[1];
				if(arr[cx][cy]==3) {
					success=1;
				}
				for(int i=0; i<4;i++) {
					int nx=cx+dx[i];
					int ny=cy+dy[i];
					if(visited[nx][ny]==0) {
						visited[nx][ny]=1;
						queue.push(new int[] {nx,ny});
					}
				}
			}
			
			sb.append(success);
			sb.append('\n');
		}

		System.out.println(sb);
	}

}