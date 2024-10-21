import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] split = in.readLine().split(" ");
		int N = Integer.parseInt(split[0]);
		int M = Integer.parseInt(split[1]);

		ArrayList<int[]>[] arr = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			arr[i] = new ArrayList<int[]>();
		}

		for (int i = 0; i < M; i++) {
			split = in.readLine().split(" ");
			int from = Integer.parseInt(split[0]);
			int to = Integer.parseInt(split[1]);
			int cost = Integer.parseInt(split[2]);

			arr[from].add(new int[] { to, cost });
			arr[to].add(new int[] { from, cost });
		}

		split = in.readLine().split(" ");
		int V1 = Integer.parseInt(split[0]);
		int D1 = Integer.parseInt(split[1]);

		split = in.readLine().split(" ");
		for (String str : split) {
			arr[0].add(new int[] { Integer.parseInt(str), 0 });
		}

		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[1] - o2[1];
			}

		});

		int[] dist_mac = new int[N + 1];
		int[] dist_star = new int[N + 1];
		Arrays.fill(dist_mac, 999999999);
		Arrays.fill(dist_star, 999999999);
		dist_mac[0] = 0;
		dist_star[0] = 0;
		pq.offer(new int[] { 0, 0 });
		while (!pq.isEmpty()) {
			int[] q = pq.poll();
			int cur = q[0];
			int cost = q[1];

			if (dist_mac[cur] < cost) {
				continue;
			}

			for (int[] i : arr[cur]) {
				int next = i[0];
				int next_cost = i[1] + cost;
				if (dist_mac[next] > next_cost) {
					dist_mac[next] = next_cost;
					pq.offer(new int[] { next, next_cost });
				}
			}
		}

		// System.out.println(Arrays.toString(dist_mac));

		split = in.readLine().split(" ");
		int V2 = Integer.parseInt(split[0]);
		int D2 = Integer.parseInt(split[1]);

		arr[0].clear();
		split = in.readLine().split(" ");
		for (String str : split) {
			arr[0].add(new int[] { Integer.parseInt(str), 0 });
		}

		pq.offer(new int[] { 0, 0 });
		while (!pq.isEmpty()) {
			int[] q = pq.poll();
			int cur = q[0];
			int cost = q[1];

			if (dist_star[cur] < cost) {
				continue;
			}

			for (int[] i : arr[cur]) {
				int next = i[0];
				int next_cost = i[1] + cost;
				if (dist_star[next] > next_cost) {
					dist_star[next] = next_cost;
					pq.offer(new int[] { next, next_cost });
				}
			}
		}

		// System.out.println(Arrays.toString(dist_star));

		int ans = 999999999;
		for (int i = 1; i <= N; i++) {
			if (dist_mac[i] != 0 && dist_star[i] != 0 && dist_mac[i] <= D1 && dist_star[i] <= D2) {
				ans = Math.min(ans, dist_mac[i] + dist_star[i]);
			}
		}

		if (ans == 999999999) {
			System.out.println(-1);
		} else {
			System.out.println(ans);
		}
	}
}