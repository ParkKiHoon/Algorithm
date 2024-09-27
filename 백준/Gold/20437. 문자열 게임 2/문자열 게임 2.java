import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());
		for (int i = 0; i < T; i++) {
			char[] W = in.readLine().toCharArray();
			int K = Integer.parseInt(in.readLine());

			int ans1=Integer.MAX_VALUE;
			for (int j = 0; j < W.length; j++) {
				ans1=Math.min(ans1,getFirst(K, j, W));
			}
			if(ans1==Integer.MAX_VALUE) {
				ans1=-1;
			}
			System.out.print(ans1);
			
			if(ans1==-1) {
				System.out.println();
				continue;
			}
			
			int ans2=0;
			for (int j = 0; j < W.length; j++) {
				ans2=Math.max(ans2,getSecond(K, j, W));
			}
			System.out.print(" "+ans2);
			System.out.println();
		}
	}

	private static int getFirst(int finish, int start, char[] W) {
		char target = W[start];
		int len=0;
		int cnt = 0;

		for (int i = start; i < W.length; i++) {
			len++;
			if(W[i]==target) {
				cnt++;
			}
			if(cnt==finish) {
				return len;
			}
		}
		
		return Integer.MAX_VALUE;
	}
	
	private static int getSecond(int finish, int start, char[] W) {
		char target = W[start];
		int len=0;
		int cnt = 0;

		for (int i = start; i < W.length; i++) {
			len++;
			if(W[i]==target) {
				cnt++;
			}
			if(cnt==finish) {
				return len;
			}
		}
		
		return 0;
	}
}