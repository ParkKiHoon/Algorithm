import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] split = in.readLine().split(" ");
		int N = Integer.parseInt(split[0]);
		int M = Integer.parseInt(split[1]);

		int[] arr = new int[M];
		split = in.readLine().split(" ");
		for (int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(split[i]);
		}

		int ans = 0;
		for (int i = 1; i < M - 1; i++) {

			int left = 0;
			for (int j = 0; j < i; j++) {
				left = Math.max(left, arr[j]);
			}

			int right = 0;
			for (int j = M - 1; j > i; j--) {
				right = Math.max(right, arr[j]);
			}

			int top = Math.min(left, right);
			if (top - arr[i] > 0) {
				ans += top - arr[i];
			}
		}
		System.out.println(ans);
	}
}