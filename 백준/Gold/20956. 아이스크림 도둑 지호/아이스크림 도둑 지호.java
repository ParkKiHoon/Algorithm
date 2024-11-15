import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] split = in.readLine().split(" ");
		int N = Integer.parseInt(split[0]);
		int M = Integer.parseInt(split[1]);

		TreeSet<Integer> set = new TreeSet<>();
		split = in.readLine().split(" ");

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			int key = Integer.parseInt(split[i]);
			set.add(key);
			arr[i] = key;
		}

		//System.out.println(set);

		int ind = 1;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int s : set) {
			map.put(s, ind++);
		}

		//System.out.println(map);

		Deque<Integer>[] deque = new ArrayDeque[set.size() + 1];
		for (int i = 0; i < set.size() + 1; i++) {
			deque[i] = new ArrayDeque<Integer>();
		}

		for (int i = 0; i < N; i++) {
			deque[map.get(arr[i])].add(i);
		}

		//System.out.println();
		ind--;
		int sig = 0;
		while (M > 0) {
			if (deque[ind].size() > 0) {
				if (sig == 0) {
					int tmp = deque[ind].pollFirst();
					System.out.println(tmp+1);
					if (arr[tmp] % 7 == 0) {
						sig = 1;
					}
					M--;
				} else {
					int tmp = deque[ind].pollLast();
					System.out.println(tmp+1);
					if (arr[tmp] % 7 == 0) {
						sig = 0;
					}
					M--;
				}
			} else {
				ind--;
			}
		}

	}
}