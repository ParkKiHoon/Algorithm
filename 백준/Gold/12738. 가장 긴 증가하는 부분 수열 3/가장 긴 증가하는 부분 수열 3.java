import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(in.readLine());
        String[] split=in.readLine().split(" ");
        int[] arr=new int[N];
        for(int i=0;i<N;i++) {
        	arr[i]=Integer.parseInt(split[i]);
        }
        
        int[] dp=new int[N];
        Arrays.fill(dp, -1000000001);
        dp[0]=arr[0];
        int pos=0;
        for(int i=1;i<N;i++) {
        	if(arr[i]>dp[pos]) {
        		dp[++pos]=arr[i];
        	}else {
        		int low=0;
        		int high=pos;
        		while(low<high) {
        			int mid=(low+high)/2;
        			if(dp[mid]<arr[i]) {
        				low=mid+1;
        			}else {
        				high=mid;
        			}
        		}
        		dp[low]=arr[i];
        	}
        	
        }

        System.out.println(pos+1);
    }
}