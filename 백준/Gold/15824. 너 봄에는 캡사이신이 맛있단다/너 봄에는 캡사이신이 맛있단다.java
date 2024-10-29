import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());
        long[] arr = new long[N];
        long[] two = new long[N];
		String[] split=in.readLine().split(" ");
		for(int i=0;i<N;i++) {
			arr[i]=Long.parseLong(split[i]);
		}
		
		Arrays.sort(arr);
		
		long mod=1000000007;
		long sum=0L;
		
		long temp=1;
		for(int i=0;i<N;i++) {
			two[i]=temp-1;
			temp=(temp*2)%mod;
		}
		
		//System.out.println(Arrays.toString(arr));
		for(int i=0;i<N;i++) {
			long tmp1=(arr[i]*two[i])%mod;
			long tmp2=(arr[i]*two[N-i-1])%mod;
			sum=(sum+tmp1-tmp2+mod)%mod;
		}
		

		System.out.println(sum);
	}
}