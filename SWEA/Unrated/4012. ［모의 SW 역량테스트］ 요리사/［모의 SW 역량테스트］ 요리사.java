import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
    static int n;
    static int[][] arr;
    static boolean[] visited;
    static int minval;

    public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T;
		T = Integer.parseInt(in.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");
			minval=Integer.MAX_VALUE;
	        n = Integer.parseInt(in.readLine());
	        arr = new int[n][n];
	        visited = new boolean[n];

	        // 배열 입력 받기
	        for (int i = 0; i < n; i++) {
	        	String[] tmp=in.readLine().split(" ");
	            for (int j = 0; j < n; j++) {
	                arr[i][j] = Integer.parseInt(tmp[j]);
	            }
	        }

	        // dfs 호출
	        dfs(0, 0);

	        sb.append(minval);
			sb.append("\n");
		}

		System.out.println(sb);

    }

    static void dfs(int ind, int cnt) {
        if (cnt == n / 2) {
            int tmp1 = 0, tmp2 = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i] && visited[j]) {
                        tmp1 += arr[i][j];
                    } else if (!visited[i] && !visited[j]) {
                        tmp2 += arr[i][j];
                    }
                }
            }
            minval = Math.min(Math.abs(tmp1 - tmp2), minval);
            return;
        }

        for (int i = ind; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i + 1, cnt + 1);
                visited[i] = false;
            }
        }
    }
}