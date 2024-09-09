import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
class Solution {
    public int solution(int[][] targets) {
		Arrays.sort(targets,new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]==o2[0]) {
					return o1[1]-o2[1];
				}else {
					return o1[0]-o2[0];
				}
			}
		});

		int start=targets[0][0];
		int end=targets[0][1];
		int cnt=1;
		for(int i=1;i<targets.length;i++) {
			int nowStart=targets[i][0];
			int nowEnd=targets[i][1];
			if(nowStart<end) {
				start=Math.max(start,nowStart);
                end=Math.min(end,nowEnd);
			}
			else {
				start=nowStart;
				end=nowEnd;
				cnt++;
			}
		}
		return cnt;
    }
}