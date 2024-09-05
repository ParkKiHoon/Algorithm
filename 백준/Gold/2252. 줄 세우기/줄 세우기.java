import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] split = in.readLine().split(" ");
		int N=Integer.parseInt(split[0]);
		int M=Integer.parseInt(split[1]);
		
		
		
		int[] parentCnt=new int[N+1];
		ArrayList<Integer>[] arr=new ArrayList[N+1];
		for(int i=1;i<N+1;i++) {
			arr[i]=new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			String[] tmp=in.readLine().split(" ");
			int from=Integer.parseInt(tmp[0]);
			int to =Integer.parseInt(tmp[1]);
			parentCnt[to]++;
			arr[from].add(to);
		}
		

		Deque<Integer> deque = new ArrayDeque<>();
		for(int i=1 ; i<N+1;i++) {
			if(parentCnt[i]==0) {
				deque.addLast(i);
			}
		}
		
		while(!deque.isEmpty()) {
			int q=deque.removeFirst();
			System.out.print(q+" ");
			for(int i: arr[q]) {
				parentCnt[i]--;
				if(parentCnt[i]==0) {
					deque.addLast(i);
				}
			}
			
		}
		
	}
}