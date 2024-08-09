import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T;
		T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");
			String[] split = in.readLine().split(" ");
			int length = Integer.parseInt(split[0]);
			int start = Integer.parseInt(split[1]);
			ArrayList<Integer>[] arr = new ArrayList[101];
			for (int i = 0; i < 101; i++) {
				arr[i] = new ArrayList<>();
			}

			int[] visited = new int[101];
			String[] split2 = in.readLine().split(" ");
			for (int i = 0; i < split2.length; i = i + 2) {
				arr[Integer.parseInt(split2[i])].add(Integer.parseInt(split2[i + 1]));
			}

			Deque<Integer> deque = new ArrayDeque<>();
			deque.addLast(start);
			while (!deque.isEmpty()) {
				
				ArrayList<Integer> forResult = new ArrayList<>();
				for(int i : deque) {
					forResult.add(i);
				}
				ArrayList<Integer> tmp = new ArrayList<>();
				while (!deque.isEmpty()) {
					int q = deque.removeFirst();
					if (visited[q] == 0) {
						visited[q] = 1;
						for (int inputVal : arr[q]) {
							if(visited[inputVal]==0)
								tmp.add(inputVal);
						}
					}
				}
				for(int i:tmp) {
					deque.addLast(i);
				}
				if(tmp.isEmpty()) {
					int maxVal=0;
					for(int i:forResult) {
						maxVal=Math.max(maxVal, i);
					}
					sb.append(maxVal);
				}
			}

			sb.append('\n');
		}

		System.out.println(sb);
	}

}