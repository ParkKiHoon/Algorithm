import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N;
		N=Integer.parseInt(in.readLine());
		StringBuilder sb=new StringBuilder();
		for(int time=1; time<=N; time++) {
			sb.append("#" + time +" ");
			
			long val=Long.parseLong(in.readLine());
			int visited=0;
			int total=(1<<10)-1;
			for(int cnt=1;;cnt++) {
				
				String tmp=(val*cnt)+"";
				for(char c : tmp.toCharArray()) {
					int num=c-'0';
					visited=visited|(1<<num);
				}
				
				if(visited==total) {
					sb.append(cnt*val);
					break;
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}