import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T;
		T = Integer.parseInt(in.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");

			String[] split = in.readLine().split(" ");

			int V = Integer.parseInt(split[0]);
			int E = Integer.parseInt(split[1]);
			int A = Integer.parseInt(split[2]);
			int B = Integer.parseInt(split[3]);

			int[] parentNode= new int[10005];
			ArrayList<Integer>[] childNode= new ArrayList[10005];
			int[] depth=new int[10005];
			for(int i=0;i<10005;i++) {
				childNode[i]=new ArrayList<>();
			}
			
			parentNode[1]=1;
			depth[1]=1;
			split=in.readLine().split(" ");
			for(int i=0;i<split.length;i+=2) {
				int from=Integer.parseInt(split[i]);
				int to =Integer.parseInt(split[i+1]);
				parentNode[to]=from;
				childNode[from].add(to);
			}
			
	
			ArrayList<Integer> left=new ArrayList<>();
			ArrayList<Integer> right=new ArrayList<>();

			while(A!=1) {
				A=parentNode[A];
				left.add(A);
				
			}
			while(B!=1) {
				B=parentNode[B];
				right.add(B);
			}

			for(int i:left) {
				if(right.contains(i)) {
					ArrayDeque<Integer> queue=new ArrayDeque<>();
					queue.offerLast(i);
					int cnt=0;
					while(!queue.isEmpty()) {
						int q=queue.pollFirst();
						cnt++;
						for(int chile:childNode[q]) {
							queue.offerLast(chile);
						}
					}
					sb.append(i+" "+cnt);
					break;
				}
			}

			sb.append("\n");
		}

		System.out.println(sb);
	}

}