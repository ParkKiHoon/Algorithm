import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(in.readLine());
		}

		int[] ans = new int[N];

		if (N == 1) {
			System.out.println(arr[0]);
		} else if (N == 2) {
			System.out.println(arr[0] + arr[1]);
		} else {
			ans[0] = arr[0];
			ans[1] = arr[0] + arr[1];
			ans[2] = Math.max(arr[0] + arr[2], arr[1] + arr[2]);

			for (int i = 3; i < N; i++) {
				ans[i] = Math.max(ans[i - 2] + arr[i], ans[i - 3] + arr[i - 1] + arr[i]);
			}
			System.out.println(ans[N - 1]);
		}
	}

	static int N;
	static int[] arr;

}