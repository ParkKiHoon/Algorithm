import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Main {

	static class Node {
		int pos;
		int cost;

		Node(int pos, int cost) {
			this.pos = pos;
			this.cost = cost;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split=in.readLine().split(" ");
		int N = Integer.parseInt(split[0]);
		int D = Integer.parseInt(split[1]);
		
		ArrayList<Node>[] arr = new ArrayList[D + 1];
		for (int i = 0; i < D + 1; i++) {
			arr[i] = new ArrayList<Node>();
		}

		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			String[] tmp = in.readLine().split(" ");
			int from = Integer.parseInt(tmp[0]);
			int to = Integer.parseInt(tmp[1]);
			int cost = Integer.parseInt(tmp[2]);
			if (to <= D && cost < to - from) {
				arr[from].add(new Node(to, cost));
			}
		}

		PriorityQueue<Node> queue=new PriorityQueue<Node>(new Comparator<Node>() {
			
			@Override
			public int compare(Node o1, Node o2) {
				return o1.cost-o2.cost;
			}
			
		});
		
		
		queue.add(new Node(0,0));
		
		int[] dist=new int[D+1];
		Arrays.fill(dist, 999999999);
		dist[0]=0;
		
		while(!queue.isEmpty()) {
			Node node=queue.poll();
			int curPos=node.pos;
			int curCost=node.cost;
			
			if(curPos==D) {
				System.out.println(dist[D]);
				break;
			}
			
			if(curPos+1<=D && curCost+1<dist[curPos+1]) {
				dist[curPos+1]=curCost+1;
				queue.add(new Node(curPos+1,dist[curPos+1]));
			}
			
			for(Node next:arr[curPos]) {
				int nextPos=next.pos;
				int nextCost=next.cost;
				if(dist[nextPos]>dist[curPos]+nextCost) {
					dist[nextPos]=dist[curPos]+nextCost;
					queue.add(new Node(nextPos,dist[nextPos]));
				}
			}
			
		}
	}
}