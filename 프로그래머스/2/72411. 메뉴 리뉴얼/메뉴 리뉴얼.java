import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String[] solution(String[] orders, int[] course) {
		int maxIndex = 0;
		for (int i : course) {
			maxIndex = Math.max(maxIndex, i);
		}
		map = new HashMap[maxIndex + 1];
		for (int i = 0; i < maxIndex + 1; i++) {
			map[i] = new HashMap<String, Integer>();
		}
		
		for (String s : orders) {
			for (int i : course) {
				char[] chars=s.toCharArray();
				Arrays.sort(chars);
				s=new String(chars);
				combination(s, new int[s.length()], 0, s.length(), i);
			}
		}

		ArrayList<String> answer=new ArrayList<String>();
		for(int i:course) {
			if(map[i].isEmpty()) {
				continue;
			}
			List<String> keys= new ArrayList<String>(map[i].keySet());
			Collections.sort(keys,(v1,v2)->(map[i].get(v2).compareTo(map[i].get(v1))));
			List<Map.Entry<String,Integer>> list = new ArrayList<>(map[i].entrySet());
			int max=map[i].get(keys.get(0));
			for(String s : keys) {
				if(map[i].get(s)<max || max==1){
					break;
				}
				answer.add(s);
			}
		}
		answer.sort(null);
		return answer.toArray(new String[answer.size()]);
	}
    
    	static HashMap<String, Integer>[] map;

	static void combination(String s, int[] visited, int start, int n, int r) {
		if (r == 0) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < n; i++) {
				if (visited[i] == 1) {
					sb.append(s.charAt(i));
				}
			}
			String sbs = sb.toString();
			int sbsLen=sbs.length();
			if (map[sbsLen].containsKey(sbs)) {
				map[sbsLen].replace(sbs, map[sbsLen].get(sbs) + 1);
			} else {
				map[sbsLen].put(sbs, 1);
			}
			return;
		}

		for (int i = start; i < n; i++) {
			visited[i] = 1;
			combination(s, visited, i + 1, n, r - 1);
			visited[i] = 0;
		}

	}
}