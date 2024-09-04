import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T;
		T = Integer.parseInt(in.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");

			N = Integer.parseInt(in.readLine());
			N = N + 2;
			w = new int[N + 2][N + 2];
			dp = new int[1 << (N - 1)][N]; // dp[visited][pos]로 변경

			for (int i = 0; i < (1 << (N - 1)); i++) {
				for (int j = 0; j < N; j++) {
					dp[i][j] = -1; // 초기화
				}
			}

			finish = (1 << (N - 1)) - 1;
			String[] split = in.readLine().split(" ");
			String tmp1 = split[2];
			String tmp2 = split[3];
			split[2] = split[split.length - 2];
			split[3] = split[split.length - 1];
			split[split.length - 2] = tmp1;
			split[split.length - 1] = tmp2;

			for (int i = 0; i < (N) * 2; i += 2) {
				for (int j = 0; j < (N) * 2; j += 2) {
					w[i / 2][j / 2] = Math.abs(Integer.parseInt(split[i]) - Integer.parseInt(split[j])) +
							Math.abs(Integer.parseInt(split[i + 1]) - Integer.parseInt(split[j + 1]));
				}
			}

			min = tsp(0, 1); // DP 기반으로 최적 경로 탐색
			sb.append(min);
			sb.append("\n");
		}

		System.out.println(sb);
	}

	// 동적 계획법으로 최단 경로 탐색 (tsp)
	private static int tsp(int pos, int visited) {
		// 모든 노드를 방문했을 때, 마지막 노드에서 시작점으로 돌아가는 비용 계산
		if (visited == finish) {
			return w[pos][N - 1]; // 마지막 위치에서 회사(끝점)으로 이동
		}

		// 이미 계산된 값이 있으면 그 값을 반환
		if (dp[visited][pos] != -1) {
			return dp[visited][pos];
		}

		int ret = Integer.MAX_VALUE;
		// 아직 방문하지 않은 노드들을 방문
		for (int i = 0; i < N - 1; i++) {
			// 방문하지 않은 노드에 대해서만 처리
			if ((visited & (1 << i)) == 0 && pos != i) {
				ret = Math.min(ret, tsp(i, visited | (1 << i)) + w[pos][i]);
			}
		}

		// dp 테이블에 값 저장
		dp[visited][pos] = ret;
		return ret;
	}

	static int N;
	static int[][] w, dp;
	static int finish;
	static int min;

}