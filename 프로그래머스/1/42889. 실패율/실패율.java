import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
class Solution {
    public int[] solution(int N, int[] stages) {
		int[] nArr=new int[N+2];
		int[] failed=new int[N+2];
		failed[0]=stages.length;
		failed[1]=stages.length;
		for(int i=0; i<stages.length; i++) {
			nArr[stages[i]]++;
		}
		for(int i=2; i<nArr.length; i++) {
			failed[i]=failed[i-1]-nArr[i-1];
		}
		
		double[] list=new double[N];
		Integer[] index=new Integer[N];
		for(int i=1;i<nArr.length-1;i++) {
            if(failed[i]==0){
                list[i-1]=0;
            }
            else{
			    list[i-1]=(double)nArr[i]/failed[i];
            }
			index[i-1]=i-1;
		}
		


		Arrays.sort(index,new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				if(list[o1]==list[o2]) {
					return o1-o2;		
				}
				else{
					return Double.compare(list[o2],list[o1]);		
				}
			};
		});
		
		for (int i=0; i<index.length;i++) {
			index[i]++;
		}

		return Arrays.stream(index).mapToInt(i->i).toArray();
    }
}