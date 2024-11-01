import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		int N = Integer.parseInt(split[0]);
		int M = Integer.parseInt(split[1]);
		int K = Integer.parseInt(split[2]);

		segment = new long[4 * N+1];
		arr = new long[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Long.parseLong(in.readLine());
		}

		buildSegmentTree(1, 1, N);

		for (int i = 0; i < M + K; i++) {
			split = in.readLine().split(" ");
			int type = Integer.parseInt(split[0]);
			int a = Integer.parseInt(split[1]);
			long b = Long.parseLong(split[2]);
			if (type == 1) {
				long diff = b - arr[a];
				arr[a] = b;
				updateSegmentTree(1, 1, N, a, diff);
			} else {
				System.out.println(querySegmentTree(1,1,N,a,(int)b));
			}
		}
	}

	static long[] segment;
	static long[] arr;


	private static long querySegmentTree(int node, int start, int end, int left,int right) {
		if(left>end || right <start) return 0;
		if(left <=start && end <=right) return segment[node];
		
		int mid=(start+end)/2;
		return querySegmentTree(node*2, start, mid, left, right)+querySegmentTree(node*2+1, mid+1, end, left, right);
		
	}
	
	private static void updateSegmentTree(int node, int start, int end, int ind, long diff) {
		if (ind < start || ind > end) {
			return;
		}

		segment[node] += diff;

		if (start != end) {
			int mid = (start + end) / 2;
			updateSegmentTree(node * 2, start, mid, ind, diff);
			updateSegmentTree(node * 2 + 1, mid+1, end, ind, diff);
		}

	}

	private static long buildSegmentTree(int node, int start, int end) {
		if (start == end) {
			segment[node] = arr[start];
		} else {
			int mid = (start + end) / 2;
			segment[node] += buildSegmentTree(node * 2, start, mid) + buildSegmentTree(node * 2 + 1, mid + 1, end);

		}
		return segment[node];
	}
}