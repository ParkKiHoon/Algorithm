import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N=Integer.parseInt(in.readLine());
		
		long[][] dp=new long[N+1][10];
		
		dp[1][0]=0;
		
		for(int i=1;i<=9;i++) {
			dp[1][i]=1;
		}
		
		for(int i=2;i<=N;i++) {
			for(int j=0;j<=9;j++) {
				if(j==0) {
					dp[i][j]=dp[i-1][1];
				}
				else if(j==9) {
					dp[i][j]=dp[i-1][8];
				}else {
					dp[i][j]=dp[i-1][j-1]+dp[i-1][j+1];
				}
				dp[i][j]%=1000000000;
			}
		}
		System.out.println(Arrays.stream(dp[N]).sum()%1000000000);
		
	}
}