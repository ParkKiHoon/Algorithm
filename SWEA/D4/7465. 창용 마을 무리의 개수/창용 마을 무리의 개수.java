import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static int find(int a) {
		if (arr[a] == a) {
			return a;
		} else
			return arr[a] = find(arr[a]);
	}

	public static void union(int a, int b) {
		int t1 = find(a);
		int t2 = find(b);
		if (t1 != t2) {
			arr[t1] = t2;
		}
	}

	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T;
		T = Integer.parseInt(in.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");

			String[] split = in.readLine().split(" ");
			int N = Integer.parseInt(split[0]);
			int M = Integer.parseInt(split[1]);

			arr = new int[N + 1];
			for (int i = 1; i < N + 1; i++) {
				arr[i] = i;
			}
			for (int i = 0; i < M; i++) {
				String[] tmp = in.readLine().split(" ");
				int from = Integer.parseInt(tmp[0]);
				int to = Integer.parseInt(tmp[1]);

				union(from,to);
			}

			
			int cnt=0;
			for(int i=1;i<N+1;i++) {
				if(find(i)==i) {
					cnt++;
				}
			}
			sb.append(cnt);
			sb.append("\n");
		}

		System.out.println(sb);
	}
}