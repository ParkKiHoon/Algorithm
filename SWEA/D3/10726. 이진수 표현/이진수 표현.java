import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T;
		T=Integer.parseInt(in.readLine());
		StringBuilder sb=new StringBuilder();
		for(int time=1; time<=T; time++) {
			sb.append("#" + time +" ");
			
			String[] split=in.readLine().split(" ");
			int N=Integer.parseInt(split[0]);
			int M=Integer.parseInt(split[1]);
			int tmp=((1<<N)-1);
			if( (M&tmp)==tmp) {
				sb.append("ON");
			}else {
				sb.append("OFF");
			}
			
			sb.append("\n");
		}
		System.out.println(sb);
	}
}