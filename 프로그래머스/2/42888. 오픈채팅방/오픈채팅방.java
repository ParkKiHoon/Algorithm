import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public String[] solution(String[] record) {
		HashMap<String, String> id_to_name = new HashMap<String, String>();
		for (String s : record) {
			String[] split = s.split(" ");
			String order = split[0];
			String id = split[1];
			if (order.equals("Enter") || order.equals("Change")) {
				String name = split[2];
				if (id_to_name.containsKey(id)) {
					id_to_name.replace(id, name);
				} else {
					id_to_name.put(id, name);
				}
			}
		}

		ArrayList<String> ans = new ArrayList<String>();
		for (String s : record) {
			String[] split = s.split(" ");
			String order = split[0];
			String id = split[1];
			if (order.equals("Enter")) {
				ans.add(id_to_name.get(id)+"님이 들어왔습니다.");
			} else if (order.equals("Leave")) {
				ans.add(id_to_name.get(id)+"님이 나갔습니다.");
			}
		}
		return ans.toArray(new String[ans.size()]);
	}
}