import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;

class Edge implements Comparable<Edge> {

	int to;
	int cost;

	Edge(int to, int cost) {
		this.to = to;
		this.cost = cost;
	}

	@Override
	public int compareTo(Edge o) {
		return this.cost - o.cost;
	}
}

class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		N = Integer.parseInt(split[0]);
		M = Integer.parseInt(split[1]);

		board = new int[N][M];
		visited = new int[N][M];
		island = new ArrayList<ArrayList<int[]>>();

		for (int i = 0; i < N; i++) {
			String[] tmp = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(tmp[j]);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 1 && visited[i][j] == 0) {
					bfs(i, j);
				}
			}
		}

		graph = new ArrayList[island.size()];
		for (int i = 0; i < island.size(); i++) {
			graph[i] = new ArrayList<Edge>();
		}
		for (int i = 0; i < island.size(); i++) {
			for (int j = 0; j < island.size(); j++) {
				if (i != j) {
					int val = distance(island.get(i), island.get(j));
					if (val != Integer.MAX_VALUE) {
						graph[i].add(new Edge(j, val - 1));
					}
				}
			}
		}

		prim();

	}

	static int N;
	static int M;
	static int[][] board;
	static int[][] visited;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static ArrayList<ArrayList<int[]>> island;
	static ArrayList<Edge>[] graph;

	private static void prim() {
		for (ArrayList<int[]> a : island) {
			if (a.size() == 0) {
				System.out.println(-1);
				return;
			}
		}
		int[] visited = new int[island.size()];
		PriorityQueue<Edge> queue = new PriorityQueue<Edge>();
		queue.add(new Edge(0, 0));

		int total = 0;
		while (!queue.isEmpty()) {
			Edge edge = queue.poll();
			int to = edge.to;
			int cost = edge.cost;
			if (visited[to] == 0) {
				visited[to] = 1;
				total += cost;
				for (Edge e : graph[to]) {
					if (visited[e.to] == 0) {
						queue.add(e);
					}
				}
			}
		}
		int signal = 0;
		for (int i : visited) {
			if (i == 0) {
				signal = 1;
				break;
			}
		}
		if (signal == 1) {
			System.out.println(-1);
		} else {
			System.out.println(total);
		}
	}

	private static int distance(ArrayList<int[]> arr1, ArrayList<int[]> arr2) {
		int minLen = Integer.MAX_VALUE;
		for (int[] a1 : arr1) {
			for (int[] a2 : arr2) {
				if (a1[0] == a2[0]) {
					int cnt = 0;
					int tmp1 = a1[1];
					int tmp2 = a2[1];
					if (a1[1] > a2[1]) {
						tmp1 = a2[1];
						tmp2 = a1[1];
					}
					for (int i = tmp1 + 1; i < tmp2; i++) {
						if (board[a1[0]][i] == 1) {
							cnt++;
						}
					}
					if (cnt == 0) {
						int distTmp = Math.abs(a2[1] - a1[1]) + Math.abs(a2[0] - a1[0]);
						if (distTmp > 2) {
							minLen = Math.min(minLen, distTmp);
						}
					}
				} else if (a1[1] == a2[1]) {
					int cnt = 0;
					int tmp1 = a1[0];
					int tmp2 = a2[0];
					if (a1[0] > a2[0]) {
						tmp1 = a2[0];
						tmp2 = a1[0];
					}
					for (int i = tmp1 + 1; i < tmp2; i++) {
						if (board[i][a1[1]] == 1) {
							cnt++;
						}
					}
					if (cnt == 0) {
						int distTmp = Math.abs(a2[1] - a1[1]) + Math.abs(a2[0] - a1[0]);
						if (distTmp > 2) {
							minLen = Math.min(minLen, distTmp);
						}
					}
				}
			}
		}
		return minLen;
	}

	private static void bfs(int i, int j) {
		ArrayDeque<int[]> queue = new ArrayDeque<int[]>();
		ArrayList<int[]> curIsland = new ArrayList<int[]>();
		queue.add(new int[] { i, j });
		curIsland.add(new int[] { i, j });
		visited[i][j] = 1;

		while (!queue.isEmpty()) {
			int[] q = queue.removeFirst();
			int x = q[0];
			int y = q[1];
			for (int dir = 0; dir < 4; dir++) {
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				if (nx >= 0 && ny >= 0 && nx < N && ny < M && visited[nx][ny] == 0 && board[nx][ny] == 1) {
					queue.add(new int[] { nx, ny });
					curIsland.add(new int[] { nx, ny });
					visited[nx][ny] = 1;
				}
			}
		}
		island.add(curIsland);
	}

}