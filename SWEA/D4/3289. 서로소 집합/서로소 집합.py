import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	static int[] arr;
	static int target;
	static int ans;

	static int find(int a) {
		if(arr[a]==a) {
			return a;
		}else {
			return arr[a]=find(arr[a]);
		}
	}

	static void union(int a, int b) {
		int rootA=find(a);
		int rootB=find(b);
		if(rootA!=rootB) {
			arr[rootA]=rootB;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T;
		// T = 10;
		T = Integer.parseInt(in.readLine());
		ans = 0;
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");

			String[] split = in.readLine().split(" ");
			int n = Integer.parseInt(split[0]);
			int m = Integer.parseInt(split[1]);

			arr = new int[n + 1];
			for (int i = 0; i < n + 1; i++) {
				arr[i] = i;
			}
			for (int i = 0; i < m; i++) {
				String[] order = in.readLine().split(" ");
				int a = Integer.parseInt(order[1]);
				int b = Integer.parseInt(order[2]);
				if (Integer.parseInt(order[0]) == 0) {
					union(a,b);
				} else {
					if(find(a)==find(b)) {
						sb.append(1);
					}
					else {
						sb.append(0);
					}
				}
			}
			sb.append('\n');

		}

		System.out.println(sb);
	}

}