import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Node implements Comparable<Node> {

	int next, weight;

	public Node(int next, int weight) {
		this.next = next;
		this.weight = weight;
	}

	@Override
	public int compareTo(Node o) {

		return this.weight - o.weight;
	}
}

public class Main {

	static int v, e, k;
	static int[] dist;
	static List<Node>[] list;
	static int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");

		v = Integer.parseInt(split[0]);
		e = Integer.parseInt(split[1]);
		k = Integer.parseInt(in.readLine());

		dist = new int[v + 1];
		list = new ArrayList[v + 1];

		Arrays.fill(dist, INF);
		for (int i = 0; i <= v; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < e; i++) {
			split = in.readLine().split(" ");
			int start = Integer.parseInt(split[0]);
			int next = Integer.parseInt(split[1]);
			int weight = Integer.parseInt(split[2]);

			list[start].add(new Node(next, weight));
		}
		

		List<String> ans = new ArrayList<>();

		dijk(k);

		for (int i = 1; i <= v; i++) {
			if (dist[i] == INF) {
				ans.add("INF");
			} else {
				ans.add(dist[i] + "");
			}
		}

		for (String s : ans) {
			System.out.println(s);
		}

	}

	private static void dijk(int start) {

		PriorityQueue<Node> queue = new PriorityQueue<>();
		boolean[] check = new boolean[v + 1];
		queue.offer(new Node(start, 0));
		dist[start] = 0;

		while (!queue.isEmpty()) {

			Node curr = queue.poll();
			if (check[curr.next] == true) {
				continue;
			}
			check[curr.next] = true;

			for (Node node : list[curr.next]) {
				if (dist[node.next] > dist[curr.next] + node.weight) {
					dist[node.next] = dist[curr.next] + node.weight;
					queue.offer(new Node(node.next, dist[node.next]));
				}
			}
		}

	}

}