
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T;
		T = Integer.parseInt(in.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");

			String[] split = in.readLine().split(" ");
			String[] split2 = split[0].split("");
			Integer[] arr = new Integer[split2.length];
			arr_sort = new Integer[split2.length];
			for (int i = 0; i < split2.length; i++) {
				arr[i] = Integer.parseInt(split2[i]);
				arr_sort[i] = Integer.parseInt(split2[i]);
			}
			int N = Integer.parseInt(split[1]);

			Arrays.sort(arr_sort, Comparator.reverseOrder());
			max = 0;
			maxVal = calculateValue(arr_sort);
			
			dfs(arr, N,new HashSet<>());
			sb.append(max);
			sb.append("\n");
		}

		System.out.println(sb);
	}

	static Integer[] arr_sort;
	static int max;
	static int maxVal;

	private static void dfs(Integer[] arr, int n,Set<String> visited) {
		String state = Arrays.toString(arr)+n;
		if(visited.contains(state)) {return;}
		else {
			visited.add(state);
		}
		if (n % 2 == 0) {
			int total = 0;
			int cnt = 1;
			for (int i = arr.length - 1; i >= 0; i--) {
				total += arr[i] * cnt;
				cnt *= 10;
			}
			if (total == maxVal) {
				max = Math.max(max, total);
				return;
			}
		}
		if (n == 0) {
			int total = 0;
			int cnt = 1;
			for (int i = arr.length - 1; i >= 0; i--) {
				total += arr[i] * cnt;
				cnt *= 10;
			}
			max = Math.max(max, total);
			return;

		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] != arr[j]) {
					swap(arr, i, j);
					dfs(arr, n - 1,visited);
					swap(arr, i, j); // 원상 복구 (백트래킹)
				}
			}
		}
	}

	// 두 배열 요소를 교환하는 메서드
	private static void swap(Integer[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
    private static int calculateValue(Integer[] arr) {
        int total = 0;
        int cnt = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            total += arr[i] * cnt;
            cnt *= 10;
        }
        return total;
    }

}
