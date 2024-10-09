import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		int N = Integer.parseInt(split[0]);
		PriorityQueue<Integer> pq =new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1-o2;
			}
		});
		
		for(int i=0;i<N;i++) {
			pq.offer(Integer.parseInt(in.readLine()));
		}
		int ans=0;
		while(pq.size()!=1) {
			int tmp=pq.poll()+pq.poll();
			ans+=tmp;
			pq.offer(tmp);
		}
		System.out.println(ans);
	}
}