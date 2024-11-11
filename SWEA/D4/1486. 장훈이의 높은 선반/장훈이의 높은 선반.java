import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

	private static int N, B, T;
	private static int[] heights;
	private static boolean[] visited;

	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			String[] split = in.readLine().split(" ");

			N = Integer.parseInt(split[0]); // 점원 수
			B = Integer.parseInt(split[1]); // 선반 높이

			heights = new int[N];
			ans = Integer.MAX_VALUE;

			split = in.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				heights[i] = Integer.parseInt(split[i]);
			}

			for (int i = 1; i <= N; i++) {
				combi = new int[i];
				top(0, 0, i);
			}

			System.out.println("#" + t + " " + ans);

		}
	}

	private static int[] combi;
	private static int ans;

	private static void top(int cnt, int start, int R) {

		if (cnt == R) {
			int h = 0;
			for (int i = 0; i < R; i++) {
				h += heights[combi[i]];
			}
			// System.out.println(h);

			if (h >= B) {
				ans = Math.min(ans, h - B);
			}

			return;
		}

		for (int i = start; i < N; i++) {
			combi[cnt] = i;
			top(cnt + 1, i + 1, R);

		}
	}

}