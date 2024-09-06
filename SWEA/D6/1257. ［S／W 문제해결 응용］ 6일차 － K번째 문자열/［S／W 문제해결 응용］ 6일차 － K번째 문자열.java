import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {


	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T;
		T = Integer.parseInt(in.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");
			int N=Integer.parseInt(in.readLine());
			String str = in.readLine();
			Deque<Character> arr = new ArrayDeque<Character>();
			for (int i = 0; i < str.length(); i++) {
				if (arr.peekLast() == null) {
					arr.addLast(str.charAt(i));
				} else {
					if (arr.peekLast() != str.charAt(i)) {
						arr.addLast(str.charAt(i));
					}
				}
			}

			char[] charType = new char[str.length()];
			int[] charCnt = new int[str.length()];

			int ind = 0;
			int start = 0;
			for (char ch : str.toCharArray()) {
				if (start == 0) {
					charType[ind] = ch;
					charCnt[ind]++;
					start = 1;
				} else {
					if (charType[ind] != ch) {
						ind++;
						charType[ind] = ch;
						charCnt[ind]++;
					} else {
						charCnt[ind]++;
					}
				}
			}


			HashSet<String> ans=new HashSet<>();
			for (int i = str.length(); i > 0; i--) {
				StringBuilder sb2 = new StringBuilder();
				for (int j = 0; j <= ind; j++) {
					if (charCnt[j] > i) {
						charCnt[j] = i;
					}
					for (int time = 0; time < charCnt[j]; time++) {
						sb2.append(charType[j]);
					}
				}

				for(int pos=0;pos<=sb2.length()-i;pos++) {
					ans.add(sb2.substring(pos,pos+i));
				}
			}
			
			ArrayList<String> ans2=new ArrayList<>(ans);
			Collections.sort(ans2);
			sb.append(ans2.get(N-1));
			sb.append("\n");
		}

		System.out.println(sb);
	}


}