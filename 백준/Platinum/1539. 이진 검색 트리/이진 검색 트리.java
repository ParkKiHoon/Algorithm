import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());

		TreeSet<Integer> set=new TreeSet<>();
		int[] h=new int[N+2];

	

		set.add(0);
		set.add(N+1);
		
		long ans=0;
		for(int i=0;i<N;i++) {
			int cur=Integer.parseInt(in.readLine())+1;
			int pos=Math.max(h[set.higher(cur)], h[set.lower(cur)])+1;
			h[cur]=pos;
			set.add(cur);
			ans+=pos;

		}
		System.out.println(ans);
		
	}
}