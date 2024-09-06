import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split=in.readLine().split(" ");
		N=Integer.parseInt(split[0]);
		M=Integer.parseInt(split[1]);
		int X=Integer.parseInt(split[2]);
		arr=new ArrayList[N+1];
		for(int i=1;i<N+1;i++) {
			arr[i]=new ArrayList<int[]>();
		}
		
		for(int i=0;i<M;i++) {
			String[] tmp=in.readLine().split(" ");
			int from=Integer.parseInt(tmp[0]);
			int to=Integer.parseInt(tmp[1]);
			int cost=Integer.parseInt(tmp[2]);
			arr[from].add(new int[] {to,cost});
		}
		
		int ans=0;
		int[] dist_to=sol(X);
		for(int i=1;i<=N;i++) {
			if(N!=X) {
				int[] tmp=sol(i);
				ans=Math.max(ans, tmp[X]+dist_to[i]);
			}
		}

		System.out.println(ans);
	}
	
	static int N;
	static int M;
	static ArrayList<int[]>[] arr;
	
	public static int[] sol(int X) {
		PriorityQueue<int[]> queue=new PriorityQueue<int[]>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[1]-o2[1];
			}
		});
		
		int[] distance=new int[N+1];
		for(int i=0;i<N+1;i++) {
			distance[i]=Integer.MAX_VALUE;
		}
		distance[X]=0;
		queue.add(new int[] {X,0});
		int[] visited=new int[N+1];
		
		while(!queue.isEmpty()) {
			int[] q=queue.poll();
			int from=q[0];
			int from_cost=q[1];
			
			if(visited[from]==1) {
				continue;
			}
			visited[from]=1;
			
			for(int[] i:arr[from]) {
				int to=i[0];
				int to_cost=i[1];
				if(distance[to]>from_cost+to_cost) {
					distance[to]=from_cost+to_cost;
					queue.offer(new int[] {to,to_cost+from_cost});
				}
			}
		}
		return distance;
	}
}