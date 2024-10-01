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
		int T = Integer.parseInt(in.readLine());
		for (int test = 0; test < T; test++) {
			
			String[] split = in.readLine().split(" ");
			int N = Integer.parseInt(split[0]);
			int D = Integer.parseInt(split[1]);
			int C= Integer.parseInt(split[2]);

			ArrayList<int[]>[] arr = new ArrayList[N + 1];
			for (int i = 0; i < N + 1; i++) {
				arr[i] = new ArrayList<int[]>();
			}

			for (int i = 0; i < D; i++) {
				String[] tmp = in.readLine().split(" ");
				int to = Integer.parseInt(tmp[0]);
				int from = Integer.parseInt(tmp[1]);
				int cost = Integer.parseInt(tmp[2]);
				arr[from].add(new int[] { to, cost });
			}
			
			PriorityQueue<int[]> queue= new PriorityQueue<int[]>(new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[0]-o2[1];
				}
			});
			
			int[] dist=new int[N+1];
			Arrays.fill(dist, 999999999);
			dist[C]=0;
			queue.add(new int[] {C,0});
			
			while(!queue.isEmpty()) {
				int[] q=queue.poll();
				int curPos=q[0];
				int curCost=q[1];
				
				if(dist[curPos]<curCost) {
					continue;
				}
				
				for(int[] next:arr[curPos]) {
					int nextPos=next[0];
					int nextCost=next[1]+curCost;
					if(dist[nextPos]>nextCost) {
						dist[nextPos]=nextCost;
						queue.add(new int[] {nextPos,nextCost});
					}
				}
			}
			int max=0;
			int cnt=0;
			for(int i:dist) {
				if(i!=999999999) {
					cnt++;
					max=Math.max(max, i);
				}
			}
			System.out.println(cnt+" "+max);
		}
	}
}