import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T;
		T = Integer.parseInt(in.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");

			int N = Integer.parseInt(in.readLine());
			String[] split = in.readLine().split(" ");
			int[] arr = new int[N];
			int max = 0;
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(split[i]);
				max = Math.max(max, arr[i]);
			}
		
			int day=0;
			int even=0;
			int odd=0;
			for(int i=0;i<N;i++) {
				even+=(max-arr[i])/2;
				odd+=(max-arr[i])%2;
			}

			if(odd>even) {
				sb.append(odd*2-1);
			}else if(odd==even) {
				sb.append(odd*2);
			}else if(even>odd) {
				int tmp=odd*2;
				int a1=((even-odd)*2)/3;
				int a2=((even-odd)*2)%3;

				tmp=tmp+a1*2+a2;

				sb.append(tmp);
			}
			
			
			sb.append("\n");
		}

		System.out.println(sb);
	}

}