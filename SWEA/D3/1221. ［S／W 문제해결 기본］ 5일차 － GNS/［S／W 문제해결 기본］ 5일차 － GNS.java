import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T;
		T = Integer.parseInt(in.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");
			String[] num= {"ZRO", "ONE","TWO","THR","FOR","FIV","SIX","SVN","EGT","NIN"};
			HashMap<String,Integer> map=new HashMap<>();
			for(String s:num) {
				map.put(s, 0);
			}

			in.readLine();
			String[] split=in.readLine().split(" ");
			for(int i=0;i<split.length;i++) {
				int tmp=map.get(split[i]);
				map.replace(split[i], tmp+1);
			}
			
			for(String s:num) {
				int cycle=map.get(s);
				for(int i=0;i<cycle;i++) {
					sb.append(s+" ");
				}
			}
			
			sb.append("\n");
		}

		System.out.println(sb);
	}


}