import java.io.IOException;
import java.util.ArrayList;
class Solution {
    public int[] solution(int[] numbers) {
		int[] used = new int[200];
		ArrayList<Integer> ans = new ArrayList<>();
		for (int i = 0; i < numbers.length; i++) {
			for (int j = i; j < numbers.length; j++) {
				if(i!=j) {
					int tmp = numbers[i]+numbers[j];
					if(used[tmp]==0) {
						used[tmp]=1;
						ans.add(tmp);
					}
				}
			}
		}
		ans.sort(null);
        return ans.stream().mapToInt(i->i).toArray();
    }
}
