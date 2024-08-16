import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
		HashMap<String, Integer> genreCnt = new HashMap<>();
		HashMap<String, ArrayList<int[]>> genreDetail = new HashMap<>();

		for (int i = 0; i < genres.length; i++) {
			if (genreCnt.containsKey(genres[i])) {
				int tmp = genreCnt.get(genres[i]);
				genreCnt.replace(genres[i], tmp + plays[i]);
			} else {
				genreCnt.put(genres[i], plays[i]);
			}
		}

		for (int i = 0; i < genres.length; i++) {
			if (genreDetail.containsKey(genres[i])) {
				ArrayList<int[]> tmp = genreDetail.get(genres[i]);
				tmp.add(new int[] { i, plays[i] });
				genreDetail.put(genres[i], tmp);
			} else {
				ArrayList<int[]> tmp = new ArrayList<int[]>();
				int[] tmp2 = new int[] { i, plays[i] };
				tmp.add(tmp2);
				genreDetail.put(genres[i], tmp);
			}
		}

		ArrayList<String> keys = new ArrayList<>(genreCnt.keySet());
		Collections.sort(keys, (v1, v2) -> (genreCnt.get(v2).compareTo(genreCnt.get(v1))));

		ArrayList<Integer> ans= new ArrayList<Integer>();
		for (String s : keys) {
			ArrayList<int[]> tmp = genreDetail.get(s);
			Collections.sort(tmp, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					if (o1[1] < o2[1]) {
						return o2[1] - o1[1];
					} else if (o1[1] == o2[1]) {
						return o1[0] - o2[0];
					} else {
						return -1;
					}
				}
			});
			ans.add(tmp.get(0)[0]);
			if(tmp.size()>=2) {
				ans.add(tmp.get(1)[0]);
			}
			
		}
		
		int[] answer= new int[ans.size()];
		for(int i=0; i<ans.size();i++) {
			answer[i]=ans.get(i);
		}
		return answer;
    }
}