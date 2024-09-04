import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(in.readLine());
		int M=Integer.parseInt(in.readLine());
		
		ArrayList<int[]>[] arr=new ArrayList[N+1];
		for(int i=0;i<N+1;i++) {
			arr[i]=new ArrayList<int[]>();
		}
		for(int i=0;i<M;i++) {
			String[] split=in.readLine().split(" ");
			int from=Integer.parseInt(split[0]);
			int to=Integer.parseInt(split[1]);
			int w=Integer.parseInt(split[2]);
			arr[from].add(new int[] {to,w});
			arr[to].add(new int[] {from,w});
		}
		
		PriorityQueue<int[]> pq= new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]-o2[1];
			}
		});
		
		int total=0;
		pq.offer(new int[] {1,0});
		int[] visited=new int[N+1];
		while(!pq.isEmpty()) {
			int[] tmp=pq.poll();
			int v=tmp[0];
			int w=tmp[1];
			if(visited[v]==1) {
				continue;
			}
			
			visited[v]=1;
			total+=w;
			for(int[] i:arr[v]) {
				if(visited[i[0]]==0) {
					pq.offer(i);
				}
			}
		}
		System.out.println(total);
	}

}