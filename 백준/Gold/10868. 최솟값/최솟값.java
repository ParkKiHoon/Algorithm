import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");

		int N = Integer.parseInt(split[0]);
		int M = Integer.parseInt(split[1]);
		segment=new int[N*4+1];
		arr=new int[N+1];
		for(int i=1;i<N+1;i++) {
			arr[i]=Integer.parseInt(in.readLine());
		}
		
		buildSegment(1,1,N);
		for(int i=0;i<M;i++) {
			split=in.readLine().split(" ");
			int a=Integer.parseInt(split[0]);
			int b=Integer.parseInt(split[1]);
			System.out.println(querySegment(1,1,N,a,b));
		}
	}
	
	private static int querySegment(int node, int start, int end, int left, int right ) {
		if(right<start || end<left) return Integer.MAX_VALUE;
		if(left<=start && end<=right) return segment[node];
		
		int mid=(start+end)/2;
		int left2=querySegment(node*2, start, mid, left, right);
		int right2=querySegment(node*2+1, mid+1, end, left, right);
		
		return Math.min(left2, right2);
		
	}

	private static int buildSegment(int node, int start, int end) {
		if(start==end) {
			segment[node]=arr[start];
		}else {
			int mid=(start+end)/2;
			int left=buildSegment(node*2, start, mid);
			int right=buildSegment(node*2+1, mid+1, end);
			segment[node]=Math.min(left, right);
			
		}
		return segment[node];
	}

	static int[] arr;
	static int[] segment;
}