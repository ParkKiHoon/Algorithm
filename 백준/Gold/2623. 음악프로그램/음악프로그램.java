import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] split = in.readLine().split(" ");
		int N = Integer.parseInt(split[0]);
		int M = Integer.parseInt(split[1]);

		int[] arr = new int[N + 1];
		ArrayList<Integer>[] list = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			split = in.readLine().split(" ");
			int len = split.length;
			for (int j = 1; j < len; j++) {
				if (j >= 2) {
					arr[Integer.parseInt(split[j])] += 1;
				}
				if (j < len - 1) {
					list[Integer.parseInt(split[j])].add(Integer.parseInt(split[j + 1]));
				}
			}
		}
		//System.out.println(Arrays.toString(arr));

		Deque<Integer> deque = new ArrayDeque<>();
		for (int i = 1; i < N + 1; i++) {
			if (arr[i] == 0) {
				deque.offerLast(i);
			}
		}
		
		ArrayList<Integer> ans=new ArrayList<>();
		
		while(!deque.isEmpty()) {
			int q=deque.pollFirst();
			
			if(arr[q]==0) {
				ans.add(q);
			}
			for(int next:list[q]) {
				arr[next]--;
				if(arr[next]==0) {
					deque.offerLast(next);
				}
			}
		}
		
		if(ans.size()==N) {
			for(int i:ans) {
				System.out.println(i);
			}
		}else {
			System.out.println(0);
		}
	}
}