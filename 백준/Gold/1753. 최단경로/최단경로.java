import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int INF = Integer.MAX_VALUE;
	static int V;
	static int E;
	static int start;
	static int[] visited;
	static int[] distance;

	private static class Vertex {
		int no;
		int weight;
		Vertex next;

		public Vertex(int no, int weight, Vertex next) {
			this.no = no;
			this.weight = weight;
			this.next = next;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] ve = in.readLine().split(" ");
		V = Integer.parseInt(ve[0]);
		E = Integer.parseInt(ve[1]);

		start = Integer.parseInt(in.readLine());
		visited = new int[V + 1];
		distance = new int[V + 1];
		distance[start] = 0;

		Arrays.fill(distance, INF);

		Vertex[] adj = new Vertex[V + 1];
		for (int i = 0; i < E; i++) {
			String[] split = in.readLine().split(" ");
			int from = Integer.parseInt(split[0]);
			int to = Integer.parseInt(split[1]);
			int w = Integer.parseInt(split[2]);

			adj[from] = new Vertex(to, w, adj[from]);
		}
		distance[start]=0;
		for (int i = 1; i <= V; i++) {
			int min = INF;
			int current = 0;
			for (int j = 1; j <= V; j++) {
				if (visited[j] == 0 && distance[j] < min) {
					current = j;
					min = distance[j];
				}
			}

			if (current == 0) {
				break;
			}

			visited[current] = 1;

			for(Vertex tmp=adj[current]; tmp!=null ; tmp=tmp.next) {
				if(visited[tmp.no]==0 &&
						distance[tmp.no]>distance[current]+tmp.weight) {
					distance[tmp.no]=distance[current]+tmp.weight;
				}
			}
		}
		for (int i = 1; i <= V; i++) {
			if (distance[i] == INF) {
				System.out.println("INF");
			} else {
				System.out.println(distance[i]);
			}
		}
	}
}