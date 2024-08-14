import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	static int clear=0;
	static ArrayList<Integer>[] graph;
	static int[] visited=new int[2000];
	static int cnt=0;
	static void dfs(int start) {
		if(cnt==5) {
			clear=1;
			return;
		}
		for(int i : graph[start]) {
			if(visited[i]==0) {
				visited[i]=1;
				cnt++;
				dfs(i);
				visited[i]=0;
				cnt--;
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] split =in.readLine().split(" ");
		int n = Integer.parseInt(split[0]);
		int m = Integer.parseInt(split[1]);
		graph=new ArrayList[n];
		for(int i=0;i<n;i++) {
			graph[i]=new ArrayList<Integer>();
		}
		for(int i=0; i<m;i++) {
			String[] tmp= in.readLine().split(" ");
			int a=Integer.parseInt(tmp[0]);
			int b=Integer.parseInt(tmp[1]);
			graph[a].add(b);
			graph[b].add(a);
		}
		
		for(int i=0; i<m;i++) {
			if (clear==0) {
				visited[i]=1;
				cnt=1;
				dfs(i);
				visited[i]=0;
				cnt=0;
			}
			else {
				break;
			}
		}
		System.out.println(clear);
	}

}