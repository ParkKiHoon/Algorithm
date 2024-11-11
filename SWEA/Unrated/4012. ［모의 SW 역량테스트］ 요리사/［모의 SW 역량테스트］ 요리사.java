import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

	private static int N, T;
	private static int[][] foods;

	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(in.readLine()); // 나무 개수

			foods = new int[N][N];
			split1 = new int[N / 2];
			split2 = new int[N / 2];
			ans = Integer.MAX_VALUE;

			for (int i = 0; i < N; i++) {
				String[] split = in.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					foods[i][j] = Integer.parseInt(split[j]);
				}
			}

			visited = new boolean[N];
			cook(0, 0);
			System.out.println("#" + t + " " + ans);
		}
	}

	private static int[] split1;
	private static int[] split2;
	private static boolean[] visited;
	private static int ans;

	private static void cook(int start, int cnt) {

		if (cnt == N / 2) {
			int idx = 0;
			for (int i = 0; i < N; i++) {
				if (!visited[i]) {
					split2[idx++] = i;
				}
			}

			int sum1 = 0;
			for (int i = 0; i < N / 2; i++) {
				for (int j = i + 1; j < N / 2; j++) {
					sum1 += foods[split1[i]][split1[j]];
					sum1 += foods[split1[j]][split1[i]];
				}
			}

			int sum2 = 0;
			for (int i = 0; i < N / 2; i++) {
				for (int j = i + 1; j < N / 2; j++) {
					sum2 += foods[split2[i]][split2[j]];
					sum2 += foods[split2[j]][split2[i]];
				}
			}

			ans = Math.min(ans, Math.abs(sum1 - sum2));

			return;
		}

		for (int i = start; i < N; i++) {
			split1[cnt] = i;
			visited[i] = true;
			cook(i + 1, cnt + 1);
			visited[i] = false;
			split1[cnt] = 0;

		}
	}

}