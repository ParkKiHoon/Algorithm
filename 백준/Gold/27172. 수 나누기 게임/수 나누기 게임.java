import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        int N=Integer.parseInt(in.readLine());
        int[] arr=new int[N];
        
        String[] split=in.readLine().split(" ");
        int max=0;
        for(int i=0;i<N;i++) {
        	arr[i]=Integer.parseInt(split[i]);
        	max=Math.max(arr[i], max);
        }

        
        
        int[] dp=new int[max+1];
        for(int i=0;i<N;i++) {
        	dp[arr[i]]=i+1;
        }
       
        int[] ans=new int[N];
        
        for(int i=0;i<N;i++) {
        	int cur=arr[i];
        	int ind=2;
        	for(int j=cur*2;j<=max;j=cur*(++ind)) {
        		if(dp[j]>0) {
        			ans[i]+=1;
        			ans[dp[j]-1]-=1;
        		}
        	}
        }

        for(int i:ans) {
        	System.out.print(i+" ");
        }
    }
}