import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        HashSet<String> reportSet=new HashSet<>(Arrays.asList(report));
		HashMap<String, Integer> map=new HashMap<String, Integer>();
		HashMap<String,HashSet<String>> map2 = new HashMap<>();
		HashMap<String, Integer> map3=new HashMap<String, Integer>();
		for(String s:id_list) {
			map.put(s, 0);
			map2.put(s, new HashSet());
			map3.put(s, 0);
		}

		
		for(String s:reportSet) {
			String[] split=s.split(" ");
			String s1=split[0];
			String s2=split[1];
			map.replace(s2, map.get(s2)+1);
			HashSet tmp=map2.get(s2);
			tmp.add(s1);
			map2.replace(s2, tmp);
		}
		
		for(String s: id_list) {
			for(String s2:map2.get(s)) {
				if(map.get(s)>=k) {
					map3.replace(s2, map3.get(s2)+1);
				}
			}
		}
		
		int[] ans=new int[id_list.length];
		for(int i=0;i<id_list.length;i++) {
			ans[i]=map3.get(id_list[i]);
		}
		return ans;
    }
}