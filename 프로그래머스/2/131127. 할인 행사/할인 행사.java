import java.util.ArrayDeque;
import java.util.HashMap;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
		int cnt = want.length;
		int total = 0;
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < want.length; i++) {
			map.put(want[i], number[i]);
			total += number[i];
		}

		ArrayDeque<String> deque = new ArrayDeque<String>();

		int ans = 0;
		for (String s : discount) {
			if (map.containsKey(s)) {
				int tmp = map.get(s);
				if (tmp == 1) {
					cnt--;
				}
				map.replace(s, tmp - 1);

			}
			deque.addLast(s);

			if (deque.size() > total) {
				String delKey = deque.removeFirst();
				if (map.containsKey(delKey)) {
					int del = map.get(delKey);
					map.replace(delKey, del + 1);
					if (del == 0) {
						cnt++;
					}
				}
			}

			if (cnt == 0) {
				ans++;
			}
		}
		return ans;
    }
}