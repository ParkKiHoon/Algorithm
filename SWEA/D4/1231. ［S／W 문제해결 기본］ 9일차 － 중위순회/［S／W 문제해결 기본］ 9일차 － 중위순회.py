import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	static int[][] tree;
	static String[] value;
	static StringBuilder sb;

	private static void postOrder(int x) {

		
		if (tree[x][0] != 0) {
			postOrder(tree[x][0]);
		}
		sb.append(value[x]);

		if (tree[x][1] != 0) {
			postOrder(tree[x][1]);
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int T;
		T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");

			int N = Integer.parseInt(in.readLine());
			tree = new int[N + 1][2];
			value = new String[N + 1];
			for (int i = 1; i <= N; i++) {
				String[] arr = in.readLine().split(" ");
				value[i] = arr[1];

				if (arr.length == 4) {
					int a = Integer.parseInt(arr[0]);
					int b = Integer.parseInt(arr[2]);
					int c = Integer.parseInt(arr[3]);
					tree[a][0] = b;
					tree[a][1] = c;
				}
				else if (arr.length == 3) {
					int a = Integer.parseInt(arr[0]);
					int b = Integer.parseInt(arr[2]);
					tree[a][0] = b;
				}
			}
			postOrder(1);
			sb.append('\n');

		}

		System.out.println(sb);
	}



}