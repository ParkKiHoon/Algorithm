import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[][] matchUp = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 0, 4 }, { 0, 5 }, { 1, 2 }, { 1, 3 }, { 1, 4 }, { 1, 5 },
			{ 2, 3 }, { 2, 4 }, { 2, 5 }, { 3, 4 }, { 3, 5 }, { 4, 5 } };
	static long[] exp = { 1_000_000_000_000_000L, 1_000_000_000_000L, 1_000_000_000L, 1_000_000L, 1_000L, 1L };
	static long result;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			result = Long.parseLong(in.readLine().replaceAll(" ", ""));
			sb.append(dfs(0, 0) ? "1 " : "0 ");

		}
		System.out.println(sb);
	}

	private static boolean dfs(int n, long state) {
		if (n == 15)
			return state == result;
		if (state > result)
			return false;

		int A = matchUp[n][0];
		int B = matchUp[n][1];

		long win = state + 100 * exp[A] + exp[B];
		long draw = state + 10 * exp[A] + 10 * exp[B];
		long lose = state + exp[A] + 100 * exp[B];
		
		return dfs(n+1,win)||dfs(n+1,draw)||dfs(n+1,lose);	
	}

}