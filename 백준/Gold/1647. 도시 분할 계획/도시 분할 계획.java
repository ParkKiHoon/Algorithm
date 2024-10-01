import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split=in.readLine().split(" ");
		int N=Integer.parseInt(split[0]);
		int M=Integer.parseInt(split[1]);
		
		ArrayList<int[]>[] arr =new ArrayList[N+1];
		for(int i=0;i<N+1;i++) {
			arr[i]=new ArrayList<int[]>();
		}
		
		for(int i=0;i<M;i++) {
			String[] tmp=in.readLine().split(" ");
			int from=Integer.parseInt(tmp[0]);
			int to=Integer.parseInt(tmp[1]);
			int cost=Integer.parseInt(tmp[2]);
			arr[from].add(new int[] {to,cost});
            arr[to].add(new int[]{from,cost});
		}
		
		PriorityQueue<int[]> queue=new PriorityQueue<int[]>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]-o2[1];
			}
			
		});
		
		queue.add(new int[] {1,0});
		int[] visited=new int[N+1];
		int sum=0;
		int max=0;
		while(!queue.isEmpty()) {
			int[] q=queue.poll();
			int pos=q[0];
			int cost=q[1];
			
			if(visited[pos]==1) {
				continue;
			}
			visited[pos]=1;
			sum+=cost;
			max=Math.max(max, cost);
			for(int[] next:arr[pos]) {
				int posNext=next[0];
				int costNext=next[1];
				if(visited[posNext]==0) {
					queue.offer(new int[] {posNext,costNext});
				}
			}
		}
		System.out.println(sum-max);
	}
}