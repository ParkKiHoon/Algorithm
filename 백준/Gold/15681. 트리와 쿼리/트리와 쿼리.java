import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] split=in.readLine().split(" ");
		int N=Integer.parseInt(split[0]);
		int R=Integer.parseInt(split[1]);
		int Q=Integer.parseInt(split[2]);
		
		arr= new ArrayList[N+1];
		for(int i=1;i<N+1;i++) {
			arr[i]=new ArrayList<Integer>();
		}
		
		for(int i=0;i<N-1;i++) {
			split=in.readLine().split(" ");
			int start=Integer.parseInt(split[0]);
			int end=Integer.parseInt(split[1]);
			arr[start].add(end);
			arr[end].add(start);
		}
		
		int[] parent=new int[N+1];
		visited=new int[N+1];
		Deque<Integer> deque=new ArrayDeque<>();
		deque.offerLast(R);
		parent[R]=-1;
		visited[R]=1;
		while(!deque.isEmpty()) {
			int q=deque.pollFirst();
			for(int ar:arr[q]) {
				if(visited[ar]==0) {
					visited[ar]=1;
					deque.offerLast(ar);
					parent[ar]=q;
				}
			}
		}
		
		visited=new int[N+1];
		ans=new int[N+1];
		Arrays.fill(ans, 1);

		visited[R]=1;
		dfs(R,1);
		for(int i=0;i<Q;i++) {
			int q=Integer.parseInt(in.readLine());
			System.out.println(ans[q]);
		}
	}
	static ArrayList<Integer>[] arr;
	static int[] ans;
	static int[] visited;
	private static int dfs(int cur,int sum) {
		for(int ar: arr[cur]) {
			if(visited[ar]==0) {
				visited[ar]=1;
				ans[cur]+=dfs(ar,0);
			}
		}
		
		return ans[cur];
	}
}