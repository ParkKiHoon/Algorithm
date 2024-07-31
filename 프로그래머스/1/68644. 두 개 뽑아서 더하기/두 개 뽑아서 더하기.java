import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
class Solution {
    public int[] solution(int[] numbers) {
		HashSet<Integer> set= new HashSet<>();
		for (int i = 0; i < numbers.length; i++) {
			for (int j = i; j < numbers.length; j++) {
				if(i!=j) {
					set.add(numbers[i]+numbers[j]);
				}
			}
		}
		
		int index=0;
		int[] ans=new int[set.size()];
		Iterator<Integer> iter = set.iterator();
		while(iter.hasNext()) {
			ans[index]=iter.next();
			index++;
		}
        Arrays.sort(ans);
        return ans;
    }
}
