import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split=in.readLine().split(" ");
		int N=Integer.parseInt(split[0]);
		int M=Integer.parseInt(split[1]);
		int[] a1=new int[M];
		int[] a2=new int[M];
		for(int i=0;i<M;i++) {
			String[] tmp=in.readLine().split(" ");
			a1[i]=Integer.parseInt(tmp[0]);
			a2[i]=Integer.parseInt(tmp[1]);
		}
		Arrays.sort(a1);
		Arrays.sort(a2);
		int ans=99999999;
		int b1=N/6;
		int b2=N%6;
		
		if(b2!=0) {
			ans=Math.min(ans, a1[0]*(b1+1));
		}else {
			ans=Math.min(ans,a1[0]*b1 );	
		}
		
		ans=Math.min(ans,a2[0]*N);
		ans=Math.min(ans,a1[0]*b1 + a2[0]* b2);
		
		System.out.println(ans);
	}

}