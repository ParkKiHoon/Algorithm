import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {

	static int[] dx = { 0, -1, 0, 1, 0 };
	static int[] dy = { 0, 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T;
		T = Integer.parseInt(in.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");
			String[] split = in.readLine().split(" ");
			int M = Integer.parseInt(split[0]);
			int A = Integer.parseInt(split[1]);

			int[] a = new int[M];
			int[] b = new int[M];
			String[] splitA = in.readLine().split(" ");
			String[] splitB = in.readLine().split(" ");
			for (int i = 0; i < M; i++) {
				a[i] = Integer.parseInt(splitA[i]);
				b[i] = Integer.parseInt(splitB[i]);
			}
			int[][] board = new int[10][10];
			ArrayList<Integer>[][] arr = new ArrayList[10][10];
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					arr[i][j] = new ArrayList<>();
				}
			}
			HashMap<Integer, Integer> map = new HashMap<>();
			int ind = 1;
			for (int i = 0; i < A; i++) {
				String[] tmp = in.readLine().split(" ");
				int x = Integer.parseInt(tmp[1]) - 1;
				int y = Integer.parseInt(tmp[0]) - 1;
				int c = Integer.parseInt(tmp[2]);
				int p = Integer.parseInt(tmp[3]);

				for (int dx = -c; dx <= c; dx++) {
					for (int dy = -c; dy <= c; dy++) {
						int nx = x + dx;
						int ny = y + dy;
						if (nx >= 0 && nx < 10 && ny >= 0 && ny < 10 && Math.abs(dx) + Math.abs(dy) <= c) {
							arr[nx][ny].add(ind);
						}
					}
				}
				map.put(ind, p);
				ind++;
			}

			int x1 = 0, y1 = 0;
			int x2 = 9, y2 = 9;
			int ans = 0;
            ans += calculateMaxCharge(arr, map, x1, y1, x2, y2);

            // 매 시간마다 이동하면서 충전량 계산
            for (int i = 0; i < M; i++) {
                x1 += dx[a[i]];
                y1 += dy[a[i]];
                x2 += dx[b[i]];
                y2 += dy[b[i]];

                // 범위 검사
                if (isValid(x1, y1) && isValid(x2, y2)) {
                    ans += calculateMaxCharge(arr, map, x1, y1, x2, y2);
                }
            }
			sb.append(ans);
			sb.append("\n");
		}

		System.out.println(sb);
	}

    static boolean isValid(int x, int y) {
        return x >= 0 && x < 10 && y >= 0 && y < 10;
    }
    
    static int calculateMaxCharge(ArrayList<Integer>[][] arr, HashMap<Integer, Integer> map, int x1, int y1, int x2, int y2) {
        int maxSum = 0;

        // 사용자 A와 B가 동일한 BC에 접속한 경우 충전량을 반으로 나눔
        for (int bcA : arr[x1][y1]) {
            for (int bcB : arr[x2][y2]) {
                if (bcA == bcB) {
                    maxSum = Math.max(maxSum, map.get(bcA)); // 같은 BC일 경우 한 명만 사용 가능
                } else {
                    maxSum = Math.max(maxSum, map.get(bcA) + map.get(bcB)); // 다른 BC일 경우 각자 사용
                }
            }
        }

        // A 또는 B만 BC에 접속했을 경우
        if (arr[x1][y1].size() > 0 && arr[x2][y2].size() == 0) {
            for (int bcA : arr[x1][y1]) {
                maxSum = Math.max(maxSum, map.get(bcA));
            }
        } else if (arr[x1][y1].size() == 0 && arr[x2][y2].size() > 0) {
            for (int bcB : arr[x2][y2]) {
                maxSum = Math.max(maxSum, map.get(bcB));
            }
        }

        return maxSum;
    }
}