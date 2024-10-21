import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {

	static public int find(int x) {
		if (friend[x] == x) {
			return x;
		} else {
			return friend[x] = find(friend[x]);
		}
	}

	static public void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
        if (pa < pb) {
        	friend[pb] = pa;
        } else {
        	friend[pa] = pb;
        }
	}

	static int[] friend;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] split = in.readLine().split(" ");
		int N = Integer.parseInt(split[0]);
		int M = Integer.parseInt(split[1]);
		int K = Integer.parseInt(split[2]);

		int[] arr = new int[N + 1];
		friend = new int[N + 1];
		split = in.readLine().split(" ");
		

		
		
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(split[i - 1]);
			friend[i] = i;
		}

		//System.out.println(Arrays.toString(arr));
		//System.out.println(Arrays.toString(friend));
		for (int i = 0; i < M; i++) {
			split = in.readLine().split(" ");
			union(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
		}
		//System.out.println(Arrays.toString(friend));

		int[] arr1 = new int[N + 1];
		int[] arr2 = new int[N + 1];
		
		for (int i = 1; i < N + 1; i++) {
			int tmp=find(i);
			arr1[tmp]++;
			arr2[tmp] += arr[i];
		}

		//System.out.println(Arrays.toString(arr1));
		//System.out.println(Arrays.toString(arr2));
		int cnt = 0;
		for (int i : arr1) {
			if (i > 0) {
				cnt++;
			}
		}

		int[] cost = new int[cnt + 1];
		int[] value = new int[cnt + 1];
		int ind = 1;
		for (int i = 1; i < N + 1; i++) {
			if (arr1[i] > 0) {
				cost[ind] = arr1[i];
				value[ind] = arr2[i];
				ind++;
			}
		}


		int[][] dp = new int[cnt + 1][K];
		for (int i = 1; i < cnt + 1; i++) {
			for (int j = 0; j < K; j++) {

				if (j >= cost[i]) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i - 1][j - cost[i]] + value[i]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}

			}
		}




		System.out.println(dp[cnt][K - 1]);
	}
}