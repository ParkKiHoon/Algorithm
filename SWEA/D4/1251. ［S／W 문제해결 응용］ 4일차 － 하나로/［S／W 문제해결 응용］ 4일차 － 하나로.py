import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T;
		T = Integer.parseInt(in.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");

			int N = Integer.parseInt(in.readLine());
			int[] x = new int[N];
			int[] y = new int[N];
			double tax;
			String[] split1 = in.readLine().split(" ");
			String[] split2 = in.readLine().split(" ");
			tax = Double.parseDouble(in.readLine());
			for (int i = 0; i < N; i++) {
				x[i] = Integer.parseInt(split1[i]);
				y[i] = Integer.parseInt(split2[i]);
			}

			ArrayList<double[]>[] arr = new ArrayList[N];
			for (int i = 0; i < N; i++) {
				arr[i] = new ArrayList<>();
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i != j) {
						arr[i].add(new double[] { (double) j,
								(double) (tax * (Math.pow(x[i] - x[j], 2) + Math.pow(y[i] - y[j], 2))) });
					}
				}
			}

			PriorityQueue<double[]> queue = new PriorityQueue<>(new Comparator<double[]>() {
				
				@Override
				public int compare(double[] o1, double[] o2) {
					return Double.compare(o1[1], o2[1]);
				}
			});
			
			queue.add(new double[] {0,0});
			
			int[] visited=new int[N];
			double sum=0;
			int conn=0;
			while(!queue.isEmpty() && conn<N) {
				
				double[] cur=queue.poll();
				int node=(int)cur[0];
				double cost=cur[1];
				
				if(visited[node]==1)continue;
				
				visited[node]=1;
				sum+=cost;
				conn++;
				
				for(double[] i:arr[node]) {
					if(visited[(int) i[0]]==0) {
						queue.add(new double[] {i[0],i[1]});
					}
				}
				

			}
			sb.append(Math.round(sum));
			sb.append("\n");
		}

		System.out.println(sb);
	}
}