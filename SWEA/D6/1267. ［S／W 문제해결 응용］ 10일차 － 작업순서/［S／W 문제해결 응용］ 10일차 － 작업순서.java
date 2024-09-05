import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T;
		T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");

			String[] split=in.readLine().split(" ");
			int V=Integer.parseInt(split[0]);
			int E=Integer.parseInt(split[1]);
			ArrayList<Integer>[] arr=new ArrayList[V+1];
			
			for(int i=0;i<=V;i++) {
				arr[i]=new ArrayList<>();
			}
			
			int[] parentCnt=new int[V+1];
			split=in.readLine().split(" ");
			for(int i=0;i<E*2;i=i+2) {
				int from=Integer.parseInt(split[i]);
				int to=Integer.parseInt(split[i+1]);
				arr[from].add(to);
				parentCnt[to]++;
			}
			
			Deque<Integer> deque = new ArrayDeque<>();
			for(int i=1;i<=V;i++) {
				if(parentCnt[i]==0) {
					deque.offerLast(i);
				}
			}
			
			while(!deque.isEmpty()) {
				int q=deque.pollFirst();
				sb.append(q+" ");
				for(int i:arr[q]) {
					parentCnt[i]--;
					if(parentCnt[i]==0) {
						deque.offerLast(i);
					}
				}
			}
			
			sb.append("\n");
		}

		System.out.println(sb);
	}
}