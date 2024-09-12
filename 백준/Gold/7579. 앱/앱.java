import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] split=in.readLine().split(" ");
		int N=Integer.parseInt(split[0]);
		int M=Integer.parseInt(split[1]);
		
		int[] weights=new int[N+1];
		int[] values=new int[N+1];
		

		String[] tmp=in.readLine().split(" ");
		for(int i=0;i<N;i++) {
			values[i]=Integer.parseInt(tmp[i]);
		}
		tmp=in.readLine().split(" ");
		for(int i=0;i<N;i++) {
			weights[i]=Integer.parseInt(tmp[i]);
		}
		int weight_total=0;
		for(int i: weights) {
			weight_total+=i;
		}
		int ans=Integer.MAX_VALUE;
		int[][] dp=new int[N+1][weight_total+1];
		for(int i=0;i<N;i++) {
			int weight=weights[i];
			int value=values[i];
			for(int j=0;j<=weight_total;j++) {
				if(i==0){
					if(j>=weight) {
						dp[i][j]=value;
					}
				}else {
					if(j>=weight) {
						dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-weight]+value);
					}else {
						dp[i][j]=dp[i-1][j];
					}
				}
				if(dp[i][j]>=M) {
					ans=Math.min(ans, j);
				}
			}
		}
		System.out.println(ans);
		
	}

}