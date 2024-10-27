import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());

		if(N==1)
		{
			System.out.println(0);
			return;
		}
		arr = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++) {
			arr[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			String[] split = in.readLine().split(" ");
			int start = Integer.parseInt(split[0]);
			int end = Integer.parseInt(split[1]);
			int cost = Integer.parseInt(split[2]);
			arr[start].add(new int[] { end, cost });
			arr[end].add(new int[] { start, cost });

		}

		dist1 = 0;
		dist2 = 0;
		first = -1;
		second = -1;
		visited = new int[N + 1];
		visited[1] = 1;
		dfs(1, 0);

		visited = new int[N + 1];
		visited[first] = 1;
		dfs2(first, 0);
		System.out.println(dist2);
	}

	static ArrayList<int[]>[] arr;
	static int[] visited;
	static int dist1;
	static int dist2;
	static int first;
	static int second;

	private static void dfs(int i, int sum) {
		if (sum > dist1) {
			dist1 = sum;
			first = i;
		}
		for (int[] next : arr[i]) {
			if (visited[next[0]] == 0) {
				visited[next[0]] = 1;
				dfs(next[0], next[1] + sum);
			}
		}
	}

	private static void dfs2(int i, int sum) {
		if (sum > dist2) {
			dist2 = sum;
			second = i;
		}
		for (int[] next : arr[i]) {
			if (visited[next[0]] == 0) {
				visited[next[0]] = 1;
				dfs2(next[0], next[1] + sum);
			}
		}
	}
}