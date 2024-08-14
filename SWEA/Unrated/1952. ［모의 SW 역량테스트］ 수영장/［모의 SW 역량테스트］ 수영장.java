import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");

			String[] split = in.readLine().split(" ");
			int[] yogum = new int[4];
			for (int i = 0; i < 4; i++) {
				yogum[i] = Integer.parseInt(split[i]);
			}

			String[] split2 = in.readLine().split(" ");
			int[] dal = new int[13];
			for (int i = 0; i < 12; i++) {
				dal[i] = Integer.parseInt(split2[i]);
			}

			int[] ans = new int[13];
			for (int i = 1; i < 13; i++) {
				int tmp = Integer.MAX_VALUE;
				ans[i] = Math.min(ans[i - 1] + yogum[1], ans[i - 1] + (dal[i-1] * yogum[0]));
				if (i > 2) {
					ans[i] = Math.min(ans[i], ans[i - 3] + yogum[2]);
				}
			}
			
			sb.append(Math.min(ans[12], yogum[3]));
			sb.append("\n");
		}

		System.out.println(sb);
	}
}