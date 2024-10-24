import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int times=Integer.parseInt(in.readLine());
		for(int time=0;time<times;time++) {
			
			
			String[] split=in.readLine().split(" ");
			int N=Integer.parseInt(split[0]);
			int K=Integer.parseInt(split[1]);
			
			int[] cost=new int[N];
			split=in.readLine().split(" ");
			for(int i=0;i<N;i++) {
				cost[i]=Integer.parseInt(split[i]);
			}
			
			int[] arr=new int[N];
			ArrayList<Integer>[] list=new ArrayList[N];
			for(int i=0;i<N;i++) {
				list[i]=new ArrayList<Integer>();
			}
			for(int i=0;i<K;i++) {
				split=in.readLine().split(" ");
				int from=Integer.parseInt(split[0])-1;
				int to=Integer.parseInt(split[1])-1;
				arr[to]++;
				list[from].add(to);
			}
			
			int target=Integer.parseInt(in.readLine());
			
			Deque<Integer> deque=new ArrayDeque<>();
			for(int i=0;i<N;i++) {
				if(arr[i]==0) {
					deque.offerLast(i);
				}
			}
			
			int[] record=new int[N];
			for(int i=0;i<N;i++) {
				record[i]=cost[i];
			}
			while(!deque.isEmpty()) {
				int q=deque.pollFirst();
				int dist=record[q];
				if(q==target-1) {
					System.out.println(dist);
					break;
				}
				for(int a:list[q]) {
					arr[a]--;
					if(arr[a]==0) {
						deque.offerLast(a);
					}
					record[a]=Math.max(record[a], dist+cost[a]);
				}
				
			}
		}
		
	}
}