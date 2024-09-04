import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(in.readLine());
		PriorityQueue<int[]> queue= new PriorityQueue<int[]>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1]==o2[1]) {
					return o1[0]-o2[0];
				}else {
					return o1[1]-o2[1];
				}
			}
		});
		
		for(int i=0;i<N;i++) {
			String[] split=in.readLine().split(" ");
			queue.add(new int[] {Integer.parseInt(split[0]),Integer.parseInt(split[1])});
		}
		
		int now=0;
		int cnt=0;
		for(int i=0;i<N;i++) {
			int[] tmp=queue.poll();
			if(tmp[0]>=now) {
				now=tmp[1];
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}