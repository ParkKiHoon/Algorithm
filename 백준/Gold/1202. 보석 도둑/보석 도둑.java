import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] split=in.readLine().split(" ");
		int N=Integer.parseInt(split[0]);
		int M=Integer.parseInt(split[1]);
		
		PriorityQueue<int[]> jewel= new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0]-o2[0];
			}
		});
		
		for(int i=0;i<N;i++) {
			split=in.readLine().split(" ");
			jewel.offer(new int[] {Integer.parseInt(split[0]), Integer.parseInt(split[1])});
		}
		
		PriorityQueue<Integer> bag=new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1-o2;
			}
		});
		
		for(int i=0;i<M;i++) {
			bag.offer(Integer.parseInt(in.readLine()));
		}
		
		PriorityQueue<int[]> pq=new PriorityQueue<int[]>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
//				if(o1[0]==o2[0]) {
//					return o2[1]-o1[1];
//				}else {
//					return o1[0]-o2[0];
//				}
				return o2[1]-o1[1];
			}
		});
		
		long sum=0;
		while(!bag.isEmpty()) {
			int cur=bag.poll();
			
			while(!jewel.isEmpty() && jewel.peek()[0]<=cur) {
				pq.offer(jewel.poll());
			}
			
			if(pq.size()==0) {
				continue;
			}
			sum+=pq.poll()[1];
			
		}
		System.out.println(sum);
		
	}
}