import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.OptionalInt;
class Solution {
    public int[] solution(int[] answers) {
		int[] ans= {0,0,0};
		int[][] supoza= {{1,2,3,4,5},{2,1,2,3,2,4,2,5},{3,3,1,1,2,2,4,4,5,5}};
		for(int i=0; i<answers.length; i++) {
			for(int j=0; j<3; j++) {
				if (answers[i]== supoza[j][i%supoza[j].length] ) {
					ans[j]+=1;
				}
			}
		}
		int maxVal = 0;
		for (int tmp : ans) {
			if(tmp>maxVal) {
				maxVal=tmp;
			}
		}
		ArrayList<Integer> answer=new ArrayList<Integer>();
		for (int i=0;i<3;i++) {
			if(ans[i]>=maxVal) {
				answer.add(i+1);
			}
		}
        return answer.stream().mapToInt(i->i).toArray();
    }
}