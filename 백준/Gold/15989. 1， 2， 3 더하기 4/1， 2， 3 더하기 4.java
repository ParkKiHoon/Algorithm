import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in= new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(in.readLine());
		int[] dp= new int[10001];
		for(int j=0;j<10001;j++) {
			dp[j]=1;
		}
		for(int j=2;j<10001;j++) {
			dp[j]+=dp[j-2];
		}
		for(int j=3;j<10001;j++){
			dp[j]+=dp[j-3];
		}
		for(int i=0;i<N;i++) {
			int tmp=Integer.parseInt(in.readLine());
			System.out.println(dp[tmp]);
		}
		
	}
}