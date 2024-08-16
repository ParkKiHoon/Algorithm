import java.util.HashMap;
class Solution {
    public String solution(String[] participant, String[] completion) {
		HashMap<String, Integer> map = new HashMap<>();
		for (String p : participant) {
			if (map.containsKey(p)) {
				int tmp = map.get(p);
				map.replace(p, tmp + 1);
			} else {
				map.put(p, 1);
			}
		}

		for (String c : completion) {
			int tmp = map.get(c);
			map.replace(c, tmp - 1);
		}


		for (String ans : map.keySet()) {
			if (map.get(ans) > 0) {
				return ans;
			}
		}
		return "GOOD!";
    }
}