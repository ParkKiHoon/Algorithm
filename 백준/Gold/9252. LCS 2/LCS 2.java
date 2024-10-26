import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String a=in.readLine();
		String b=in.readLine();
		
		int[][] dp=new int[a.length()+1][b.length()+1];
		
		for(int i=1;i<a.length()+1;i++) {
			for(int j=1;j<b.length()+1;j++) {
				if(a.charAt(i-1)==b.charAt(j-1)) {
					dp[i][j]=dp[i-1][j-1]+1;
				}else {
					dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		int cnt=dp[a.length()][b.length()];
		int i=a.length();
		int j=b.length();
		char[] ans=new char[cnt];
		while(cnt>0) {
			int cur=dp[i][j];
			if(dp[i][j-1]==dp[i][j]) {
				j--;
			}else if(dp[i-1][j]==dp[i][j]) {
				i--;
			}else if(dp[i][j]==dp[i-1][j-1]+1) {
				cnt--;
				i--;
				j--;
				ans[cnt]=a.charAt(i);
			}
		}
		System.out.println(dp[a.length()][b.length()]);
		for(char ch:ans) {
			System.out.print(ch);
		}
	}
}