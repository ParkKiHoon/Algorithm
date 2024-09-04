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

			N=Integer.parseInt(in.readLine());
			N=N+2;
			w=new int[N+2][N+2];
			finish=(1<<(N-1))-1;
			String[] split=in.readLine().split(" ");
			String tmp1=split[2];
			String tmp2=split[3];
			split[2]=split[split.length-2];
			split[3]=split[split.length-1];
			split[split.length-2]=tmp1;
			split[split.length-1]=tmp2;
			for(int i=0;i<(N)*2;i+=2) {
				for(int j=0;j<(N)*2;j+=2) {
					w[i/2][j/2]=Math.abs(Integer.parseInt(split[i])-Integer.parseInt(split[j])) +
							Math.abs(Integer.parseInt(split[i+1])-Integer.parseInt(split[j+1]));
				}
			}
			
			

			min=Integer.MAX_VALUE;
			dfs(0,1,0);
			sb.append(min);
			sb.append("\n");
		}

		System.out.println(sb);
 	}

	private static void dfs(int pos, int visited,int sum) {
		if(visited==finish) {
			min=Math.min(min, sum+w[pos][N-1]);
			return;
		}
		for(int i=0;i<N-1;i++) {
			if((visited&(1<<i))==0 &&pos!=i ) {
				dfs(i,visited|(1<<i),sum+w[pos][i]);
			}
		}
	}
	static int N;
	static int[][] w;
	static int finish;
	static int min;
	

}