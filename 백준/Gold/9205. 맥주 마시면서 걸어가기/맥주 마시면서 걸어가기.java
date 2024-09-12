import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Main {

	static class Node {
		int x = 0;
		int y = 0;

		// type 0집 ,1편의점, 2공연장
		int type = 0;

		int num = 0;

		public Node(int x, int y, int type, int num) {
			super();
			this.x = x;
			this.y = y;
			this.type = type;
			this.num = num;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T;
		T = Integer.parseInt(in.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {


			int N = Integer.parseInt(in.readLine());
			String[] split = in.readLine().split(" ");
			ArrayList<Node> nodes = new ArrayList<>();
			nodes.add(new Node(Integer.parseInt(split[0]), Integer.parseInt(split[1]), 0, 0));
			for (int i = 0; i < N; i++) {
				split = in.readLine().split(" ");
				nodes.add(new Node(Integer.parseInt(split[0]), Integer.parseInt(split[1]), 1, i + 1));
			}
			split = in.readLine().split(" ");
			nodes.add(new Node(Integer.parseInt(split[0]), Integer.parseInt(split[1]), 2, N + 1));

			ArrayList<Node>[] arr = new ArrayList[N + 2];
			for (int i = 0; i < N + 2; i++) {
				arr[i] = new ArrayList<>();
			}
			for (Node from : nodes) {
				for (Node to : nodes) {
					if (from.type == 2 || to.type == 0 || from.num==to.num) {
						continue;
					}
					if (Math.abs(from.x - to.x) + Math.abs(from.y - to.y) <= 1000) {
						arr[from.num].add(to);
					}
				}
			}
			
			int[] visited=new int[N+2];
			visited[0]=1;
			String ans="sad";
			Deque<Node> deque = new ArrayDeque<>();
			for(Node n : arr[0]) {
				deque.add(n);
				visited[n.num]=1;
			}
			
			while(!deque.isEmpty()) {
				Node node=deque.pollFirst();
				if(node.type==2) {
					ans="happy";
					break;
				}
				for(Node n: arr[node.num]) {
					if(visited[n.num]==0) {
						visited[n.num]=1;
						deque.add(n);
					}
				}
			}

			sb.append(ans);
			sb.append("\n");
		}

		System.out.println(sb);
	}

}