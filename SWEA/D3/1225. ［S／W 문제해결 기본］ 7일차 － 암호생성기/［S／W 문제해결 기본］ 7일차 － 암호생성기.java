import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T;
		T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");
			String notuse = in.readLine();
			String[] split = in.readLine().split(" ");
			Deque<Integer> deque = new ArrayDeque<>();
			for (String s : split) {
				deque.add(Integer.parseInt(s));
			}

			int cnt = 1;
			while (true) {

				int tmp = deque.removeFirst();
				if (tmp - cnt <= 0) {
					deque.addLast(0);
				} else {
					deque.addLast(tmp - cnt);
				}
				cnt++;
				if(cnt>5) {
					cnt=1;
				}
				if (deque.peekLast() == 0) {

					break;
				}
			}

			for (int i : deque) {
				sb.append(i + " ");
			}
			sb.append('\n');
		}

		System.out.println(sb);
	}

}