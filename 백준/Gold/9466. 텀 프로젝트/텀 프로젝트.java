import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;

public class Main {

	static int[] parent;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int times = Integer.parseInt(in.readLine());
		for (int time = 0; time < times; time++) {

			int N = Integer.parseInt(in.readLine());

			arr = new int[N + 1];

			String[] split = in.readLine().split(" ");
			for (int i = 1; i < N + 1; i++) {
				arr[i] = Integer.parseInt(split[i - 1]);
			}

			visited = new int[N + 1];
			int num = 0;
			for (int i = 1; i < N + 1; i++) {

				if (visited[i] == 0) {
					cnt = 0;
					set = new HashSet<>();
					deque = new ArrayDeque<>();
					dfs(i);
					num += cnt;
				}
			}
			System.out.println(N - num);
		}
	}

	static HashSet<Integer> set;
	static Deque<Integer> deque;
	static int cnt;
	static int arr[];
	static int visited[];

	private static void dfs(int i) {
		if (visited[i] == 0) {
			visited[i] = 1;
			set.add(i);
			deque.offerLast(i);
			dfs(arr[i]);
		} else {
			if (set.contains(i)) {
				while (!deque.isEmpty()) {
					int q = deque.pollLast();
					if (q == i) {
						cnt++;
						break;
					} else {
						cnt++;
					}
				}
			}
		}

	}
}