import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;

public class Main {

	static int N;
	static int K;
	static int[] used;

	static void BFS(int start) {
		Deque<int[]> deque = new ArrayDeque<>();
		deque.offerLast(new int[] { start, 0 });
		used[start]=1;

		while (!deque.isEmpty()) {
			int[] q = deque.pollFirst();
			if (q[0] == K) {
				System.out.println(q[1]);
				return;
			}
			if (q[0] - 1 >= 0 && used[q[0] - 1]==0) {
				deque.offerLast(new int[] { q[0] - 1, q[1] + 1 });
				used[q[0] - 1]=1;
			}
			if (q[0] + 1 <= 100000 && used[q[0] + 1]==0) {
				deque.offerLast(new int[] { q[0] + 1, q[1] + 1 });
				used[q[0] + 1]=1;
			}
			if (q[0] * 2 <= 100000 && used[q[0] *2]==0) {
				deque.offerLast(new int[] { q[0] * 2, q[1] + 1 });
				used[q[0] * 2]=1;
			}


		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		N = Integer.parseInt(split[0]);
		K = Integer.parseInt(split[1]);
		used = new int[100001];
		BFS(N);
	}

}