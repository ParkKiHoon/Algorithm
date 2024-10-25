import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	static int[] parent;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(in.readLine());
		
		Integer[] arr=new Integer[N];
		String[] split=in.readLine().split(" ");
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(split[i]);

		}
		
		Arrays.sort(arr);
		
		int start=0;
		int end=N-1;
		int ans=2000000001;
		int a=0;
		int b=0;
		while(start<end) {
			int tmp=arr[end]+arr[start];
			
			if(Math.abs(tmp)<ans) {
				a=start;
				b=end;
				ans=Math.abs(tmp);
			}
			if(tmp==0) {
				break;
			}
			if(tmp>0) {
				end--;
			}else {
				start++;
			}
		}

		System.out.println(arr[a]+" "+arr[b]);
	}
}