import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		int N = Integer.parseInt(split[0]);
		int M = Integer.parseInt(split[1]);
		int[] arr = new int[N];

		split = in.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(split[i]);
		}

		int[] dp = new int[N+1];
		dp[0] = 0;

		for (int i = 1; i < N+1; i++) {
			dp[i] = dp[i - 1] + arr[i-1];
		}

		int s = 0;
		int e = 0;
		int ans = 999999999;
		if(dp[0]>=M) {
			ans=1;
		}
		while (true) {
			// System.out.println(s+" "+e);
			if (e >= N+1) {
				break;
			}
			if (dp[e] - dp[s] >= M) {
				ans = Math.min(e - s, ans);
			}

			if (dp[e] - dp[s] > M) {
				s++;
			} else {
				e++;
			}
		}

		 //System.out.println(Arrays.toString(dp));
		if (ans == 999999999) {
			System.out.println(0);
		} else {
			System.out.println(ans);
		}

	}
}