import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
		ArrayDeque<int[]> deque = new ArrayDeque<>();
		ArrayList<Integer> ans = new ArrayList<>();
		for (int i = 0; i < progresses.length; i++) {
			deque.addLast(new int[] { progresses[i], speeds[i] });
		}

		int cnt = 0;
		while (true) {
			if (deque.size() == 0) {
				break;
			}
			cnt++;

			int todayCnt = 0;
			while (deque.size()>0 && deque.getFirst()[0] + cnt * deque.getFirst()[1] >= 100) {
				todayCnt++;
				deque.removeFirst();
			}
			if (todayCnt > 0) {
				ans.add(todayCnt);
			}
		}
		
		return ans.stream().mapToInt(i->i).toArray();
	}
}