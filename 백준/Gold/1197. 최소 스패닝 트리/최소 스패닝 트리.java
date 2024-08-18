import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	
	private static class Edge implements Comparable<Edge>{

		int from;
		int to;
		int w;
		Edge(int from,int to, int w){
			this.from=from;
			this.to=to;
			this.w=w;
		}
		
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.w-o.w;
		}
		
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split=in.readLine().split(" ");
		int V=Integer.parseInt(split[0]);
		int E=Integer.parseInt(split[1]);
		PriorityQueue<Edge> queue=new PriorityQueue<>();
		for(int i=0;i<E;i++) {
			String[] tmp=in.readLine().split(" ");
			queue.offer(new Edge(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]), Integer.parseInt(tmp[2])));
		}
		
		int ans=0;
		parent=new int[V+1];
		for(int i=1;i<=V;i++) {
			parent[i]=i;
		}
		int cnt=0;
		while(!queue.isEmpty()) {
			Edge cur=queue.poll();
			if(find(cur.from)!=find(cur.to)) {
				ans+=cur.w;
				union(cur.from,cur.to);
				cnt++;
				if(cnt==V-1) {
					System.out.println(ans);
					break;
				}
			}
		}
	}
	static int[] parent;
	
	private static void union(int from, int to) {
		int a=find(from);
		int b=find(to);
		parent[a]=b;
		
	}

	private static int find(int n) {
		if(parent[n]==n) {
			return n;
		}
		return parent[n]=find(parent[n]);
		
	}

}