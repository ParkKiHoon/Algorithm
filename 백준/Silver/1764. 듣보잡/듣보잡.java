import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
		
		String[] split=in.readLine().split(" ");
		int N=Integer.parseInt(split[0]);
		int M=Integer.parseInt(split[1]);
		
		HashMap<String,Integer> map = new HashMap<>();
		for(int i=0;i<N;i++) {
			String tmp=in.readLine();
			map.put(tmp, 1);
		}
		
		ArrayList<String> ans=new ArrayList<>();
		for(int i=0;i<M;i++) {
			String tmp=in.readLine();
			if(map.containsKey(tmp)) {
				ans.add(tmp);
			}
		}
		
		Collections.sort(ans);
		System.out.println(ans.size());
		for(String s:ans) {
			System.out.println(s);
		}
	}
}