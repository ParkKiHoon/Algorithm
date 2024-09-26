import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		String[] split = in.readLine().split(" ");
		int[] arr = new int[N];
		int[] dp = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(split[i]);
			dp[i]=arr[i];
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j]+arr[i]);
				}
			}
		}
		int ans = 0;
		for (int i = 0; i < N; i++) {
			ans = Math.max(ans, dp[i]);
		}
		System.out.println(ans);
	}
}