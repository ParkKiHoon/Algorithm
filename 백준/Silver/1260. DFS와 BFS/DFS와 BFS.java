import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;

public class Main {

	static int N;
	static int M;
	static int V;
	static ArrayList<Integer>[] graph;
	static int[] visited;
	
	static void DFS(int start) {
		System.out.print(start+" ");
		for(int i:graph[start]) {
			if(visited[i]==0) {
				visited[i]=1;
				DFS(i);
				//visited[i]=0;
			}
		}
	}
	
	static void BFS(int start) {
		Deque<Integer> deque= new ArrayDeque<>();
		for(int i: graph[start]) {
			deque.addLast(i);
		}
		System.out.print(start+" ");
		
		while(!deque.isEmpty()) {
			int q=deque.removeFirst();
			if(visited[q]==0) {
				System.out.print(q+" ");
				visited[q]=1;
				for(int i:graph[q]) {
					deque.addLast(i);
				}
			}
		}

	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split=in.readLine().split(" ");
		N=Integer.parseInt(split[0]);
		M=Integer.parseInt(split[1]);
		V=Integer.parseInt(split[2]);
		
		graph=new ArrayList[N+1];
		
		for(int i=1;i<=N;i++) {
			graph[i]=new ArrayList<>();
		}
		for(int i=0;i<M;i++) {
			String[] inputVal=in.readLine().split(" ");
			graph[Integer.parseInt(inputVal[0])].add(Integer.parseInt(inputVal[1]));
			graph[Integer.parseInt(inputVal[1])].add(Integer.parseInt(inputVal[0]));
		}
		
		for(int i=1;i<=N;i++) {
			Collections.sort(graph[i]);
		}
		
		visited=new int[N+1];
		
		
		for(int i=1;i<=N;i++) {
			visited[i]=0;
		}
		visited[V]=1;
		DFS(V);
		
		System.out.println();
		for(int i=1;i<=N;i++) {
			visited[i]=0;
		}
		visited[V]=1;
		BFS(V);
		
	}

}