import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());
		arr1 = new int[N + 1];
		arr2 = new int[N + 1];

		for (int i = 1; i < N + 1; i++) {
			arr1[i] = i;
			arr2[i] = Integer.parseInt(in.readLine());
		}

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (arr1[i] == arr2[i]) {
				cnt++;
			}
		}

		ans = 0;
		total_visited = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			if (total_visited[i] == 0) {
				int[] visited = new int[N + 1];
				visited[i] = 1;
				dfs(i, arr1[i], arr2[i], visited, 1);
			}
		}
		System.out.println(ans);

		for (int i = 1; i < N + 1; i++) {
			if (total_visited[i] == 1) {
				System.out.println(i);
			}
		}
	}

	static int ans;
	static int[] arr1;
	static int[] arr2;
	static int[] total_visited;

	private static void dfs(int start, int a1, int a2, int[] visited, int cnt) {

		if (visited[a2] == 0) {
			visited[a2] = 1;
			dfs(start, arr1[a2], arr2[a2], visited, cnt + 1);
		} else {
			if (a2 == start) {
				ans += cnt;
				for (int i = 1; i < visited.length; i++) {
					if (visited[i] == 1) {
						total_visited[i] = 1;
					}
				}
			}
		}
	}
}