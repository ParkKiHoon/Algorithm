import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
1. 부분 집합 구하기
2. 두 그룹관 연결성 확인
3. 인구 차이 계산
4. 최소 인구 차이 찾기
 */
public class Main {

	private static int n, r;
	private static int[][] graph;
	private static int[] population;
	private static boolean[] selected;
	private static int[] parents;
	private static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(in.readLine());
		graph = new int[n][n];
		population = new int[n]; // 인구수
		parents = new int[n];
		selected = new boolean[n];

		String[] split = in.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			population[i] = Integer.parseInt(split[i]);
		}

		// 인접 구역 수 : 인접 구역 번호
		for (int from = 0; from < n; from++) {
			st = new StringTokenizer(in.readLine());
			int cnt = Integer.parseInt(st.nextToken()); // Number of adjacent districts
			for (int i = 0; i < cnt; i++) {
				int to = Integer.parseInt(st.nextToken()) - 1; // Convert to 0-based index
				graph[from][to] = 1;
			}
		}

		subSet(0);
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);

	}

	private static void subSet(int r) {

		if (r == n) {
			List<Integer> group1 = new ArrayList<>();
			List<Integer> group2 = new ArrayList<>();

			for (int i = 0; i < n; i++) {

				if (selected[i]) {
					group1.add(i);
				} else {
					group2.add(i);
				}
			}

			if (group1.size() == 0 || group2.size() == 0) {
				return;
			}

			makeSet();
			distribute(group1);
			distribute(group2);

			if (isConnected(group1, group2)) {
				int sum1 = populSum(group1);
				int sum2 = populSum(group2);
				answer = Math.min(answer, Math.abs(sum1 - sum2));
			}

			return;

		}

		selected[r] = true;
		subSet(r + 1);
		selected[r] = false;
		subSet(r + 1);

	}

	private static int populSum(List<Integer> group) {
		int sum = 0;
		for (int idx : group) {
			sum += population[idx];
		}

		return sum;
	}

	private static void distribute(List<Integer> group) {
		for (int from : group) {
			for (int to : group) {
				if (from != to && graph[from][to] == 1) {
					union(from, to);
				}
			}
		}
	}

	private static boolean isConnected(List<Integer> group1, List<Integer> group2) {

		int root1 = find(group1.get(0));
		for (int i = 1; i < group1.size(); i++) {
			if (find(group1.get(i)) != root1) {
				return false;
			}
		}

		int root2 = find(group2.get(0));
		for (int i = 1; i < group2.size(); i++) {
			if (find(group2.get(i)) != root2) {
				return false;
			}
		}

		return true;
	}

	private static void makeSet() {
		for (int i = 0; i < n; i++) {
			parents[i] = i;
		}
	}

	private static int find(int u) {
		if (parents[u] == u) {
			return u;
		}
		return parents[u] = find(parents[u]);
	}

	private static void union(int u, int v) {
		int rootU = find(u);
		int rootV = find(v);
		if (rootU != rootV) {
			parents[rootV] = rootU; // Union by setting one root as the parent of the other
		}
	}

}