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
	
	static int[] parent;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] split=in.readLine().split(" ");
		int N=Integer.parseInt(split[0]);
		int M=Integer.parseInt(split[1]);
		
		ArrayList<int[]>[] arr=new ArrayList[N+1];
		for(int i=1;i<N+1;i++) {
			arr[i]=new ArrayList<int[]>();
		}
		
		for(int i=0;i<M;i++) {
			split=in.readLine().split(" ");
			
			int from=Integer.parseInt(split[0]);
			int to=Integer.parseInt(split[1]);
			int cost=Integer.parseInt(split[2]);
			
			arr[from].add(new int[] {to,cost});
			arr[to].add(new int[] {from,cost});
			
			
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]-o2[1];
			}
			
		});
		
		int[] dist=new int[N+1];
		Arrays.fill(dist, 999999999);
		dist[0]=0;
		
		pq.offer(new int[] {1,0});
		
		while(!pq.isEmpty()) {
			int[] q=pq.poll();
			int cur=q[0];
			int cost=q[1];
			
			if(dist[cur]<cost) {
				continue;
			}
			
			for(int[] ar:arr[cur]) {
				int next=ar[0];
				int nextCost=ar[1]+cost;
				if(dist[next]>nextCost) {
					dist[next]=nextCost;
					pq.offer(new int[] {next,nextCost});
				}
			}
			
		}
		System.out.println(dist[N]);
		
	}
}