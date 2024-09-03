import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T;
		T = Integer.parseInt(in.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");

			int N = Integer.parseInt(in.readLine());
			pos = new int[N];
			weight = new int[N];
			String[] split = in.readLine().split(" ");
			for (int i = 0; i < N; i++) {
pos[i] = Integer.parseInt(split[i].trim());
				weight[i] = Integer.parseInt(split[i + N].trim());
			}
			

			for (int i = 0; i < N-1; i++) {
				ArrayList<Integer> left=new ArrayList<>();
				ArrayList<Integer> right=new ArrayList<>();
				for (int j = 0; j < N; j++) {
					if (j<=i) {
						left.add(j);
					}else {
						right.add(j);
					}
				}

				double start=pos[i];
				double end=pos[i+1];
				double middle=(start+end)/2.0;
				double leftSum=0;
				double rightSum=0;
				for(int l:left) {
					leftSum+=getF(l,middle);
				}
				for(int r:right) {
					rightSum+=getF(r,middle);
				}

				int cnt=0;
				while(true) {
					leftSum=0;
					rightSum=0;
					for(int l:left) {
						leftSum+=getF(l,middle);
					}
					for(int r:right) {
						rightSum+=getF(r,middle);
					}
					
					if(leftSum<rightSum) {
						end=middle;
					}else {
						start=middle;
					}
					middle=(start+end)/2.0;
//					System.out.println(left);
//					System.out.println(right);
//					System.out.println(leftSum);
//					System.out.println(rightSum);
//					System.out.println(middle);
//					System.out.println();
					if(cnt==100) {
						break;
					}
					cnt++;
				}
				sb.append(String.format("%.10f ",middle));
			}
			
			sb.append("\n");
		}

		System.out.println(sb);
	}
	static int[] pos;
	static int[] weight;
	static double getF(int v1,double v2) {
		double a1=weight[v1] ;
		double a2=Math.pow(pos[v1]-v2,2);
		return a1/a2;
	}
}