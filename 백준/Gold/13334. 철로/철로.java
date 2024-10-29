import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());

		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {

				return o1[1] - o2[1];
			}
		});

		for (int i = 0; i < N; i++) {
			String[] split = in.readLine().split(" ");
			int a = Integer.parseInt(split[0]);
			int b = Integer.parseInt(split[1]);
			if (a < b) {
				pq.offer(new int[] { a, b });
			} else {
				pq.offer(new int[] { b, a });
			}
		}

		int D = Integer.parseInt(in.readLine());

		PriorityQueue<int[]> valid = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {

				return o1[0] - o2[0];
			}
		});

		int ans = 0;
		while (!pq.isEmpty()) {
			int[] tmp = pq.poll();
			int x = tmp[0];
			int y = tmp[1];

			if (y - x > D) {
				continue;
			}
			valid.offer(new int[] { x, y });
			
			int start=y-D;
			while(!valid.isEmpty()) {
				if(valid.peek()[0]>=start) {
					break;
				}else {
					valid.poll();
				}
			}

			ans = Math.max(ans, valid.size());
		}

		System.out.println(ans);
	}
}