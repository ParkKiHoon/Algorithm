import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] split = in.readLine().split(" ");
		int N = Integer.parseInt(split[0]);
		int M = Integer.parseInt(split[1]);

		ArrayList<Integer>[] list=new ArrayList[N+1];
		for(int i=1;i<N+1;i++) {
			list[i]=new ArrayList<Integer>();
		}
		int[] arr = new int[N + 1];
		for(int i=0;i<M;i++) {
			split=in.readLine().split(" ");
			int from=Integer.parseInt(split[0]);
			int to=Integer.parseInt(split[1]);
			arr[to]++;
			list[from].add(to);
		}
		

		PriorityQueue<Integer> pq=new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1-o2;
			}
		});
		
		for(int i=1;i<N+1;i++) {
			if(arr[i]==0) {
				pq.offer(i);
			}
		}
		
		while(!pq.isEmpty()) {
			int q=pq.poll();
			System.out.println(q);
			for(int i:list[q]) {
				arr[i]--;
				if(arr[i]==0) {
					pq.offer(i);
				}
			}
		}
		//System.out.println(Arrays.toString(arr));
	}
}