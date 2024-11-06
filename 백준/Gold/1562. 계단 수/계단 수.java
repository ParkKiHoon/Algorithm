import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());

		long[][][] dp = new long[N + 1][10][1 << 10];



		long mod=1000000000;
		for (int i = 1; i <= 9; i++) {
			dp[1][i][1 << i] = 1;
		}

		for (int i = 2; i <= N; i++) {
			for (int j = 0; j <= 9; j++) {
				for (int k = 0; k < (1 << 10); k++) {
					if (j == 0) {
						dp[i][j][k|1<<j] = (dp[i][j][k|1<<j] + dp[i-1][j+1][k])%mod;
					} else if (j == 9) {
						dp[i][j][k|1<<j] = (dp[i][j][k|1<<j]+ dp[i-1][j-1][k])%mod;
					} else {
						dp[i][j][k|1<<j]=(dp[i][j][k|1<<j]+dp[i-1][j-1][k]+dp[i-1][j+1][k])%mod;
					}
					
				}
			}
		}
		long ans=0;
		for(int i=0;i<=9;i++) {
			ans=(ans+dp[N][i][(1<<10)-1])%mod;
			//ans+=(dp[N][i][(1<<10)-1]%mod);
		}
		System.out.println(ans);

	}
}