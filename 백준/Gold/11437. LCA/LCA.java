import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(in.readLine());
		ArrayList<Integer>[] arr=new ArrayList[N+1];
		for(int i=1;i<N+1;i++) {
			arr[i]=new ArrayList<Integer>();
		}
		
		for(int i=0;i<N-1;i++) {
			String[] split=in.readLine().split(" ");
			int start= Integer.parseInt(split[0]);
			int end=Integer.parseInt(split[1]);
			
			arr[start].add(end);
			arr[end].add(start);
		}
		
		int[] parent=new int[N+1];
		int[] level=new int[N+1];
		int[] visited=new int[N+1];
		visited[1]=1;
		parent[1]=1;
		level[1]=1;
		
		Deque<Integer> deque=new ArrayDeque<>();
		deque.offer(1);
		while(!deque.isEmpty()) {
			int cur=deque.pollFirst();
			
			for(int i:arr[cur]) {
				if(visited[i]==0) {
					visited[i]=1;
					deque.offer(i);
					parent[i]=cur;
					level[i]=level[cur]+1;
				}
			}
		}

		
		int M=Integer.parseInt(in.readLine());
		for(int i=0;i<M;i++) {
			String[] split=in.readLine().split(" ");
			int a=Integer.parseInt(split[0]);
			int b=Integer.parseInt(split[1]);
			while(true) {
				if(level[a]>level[b]) {
					a=parent[a];
				}else if(level[b]>level[a]) {
					b=parent[b];
				}else {
					if(a==b) {
						System.out.println(a);
						break;
					}else {
						a=parent[a];
						b=parent[b];
					}
				}
			}
		}
		
	}
}