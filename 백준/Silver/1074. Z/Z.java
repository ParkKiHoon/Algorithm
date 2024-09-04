import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		int N = Integer.parseInt(split[0]);
		int r = Integer.parseInt(split[1]) + 1;
		int c = Integer.parseInt(split[2]) + 1;

		int M = (int) Math.pow(2, N);

		int start = 1;
		int end = M * M;

		while (M > 1) {
			if (r <= M / 2 && c <= M / 2) {
				int tmp1 = start;
				int tmp2 = end - ((end - start + 1) / 4 * 3);
				start = tmp1;
				end = tmp2;
				M /= 2;
			} else if (r <= M / 2 && c > M / 2) {
				int tmp1 = start + ((end - start + 1) / 4 * 1);
				int tmp2 = end - ((end - start + 1) / 4 * 2);
				start = tmp1;
				end = tmp2;
				M /= 2;
				c -= M;
			} else if (r > M / 2 && c <= M / 2) {
				int tmp1 = start + ((end - start + 1) / 4 * 2);
				int tmp2 = end - ((end - start + 1) / 4 * 1);
				start = tmp1;
				end = tmp2;
				M /= 2;
				r -= M;
			} else if (r > M / 2 && c > M / 2) {
				int tmp1 = start + ((end - start + 1) / 4 * 3);
				int tmp2 = end;
				start = tmp1;
				end = tmp2;
				M /= 2;
				r -= M;
				c -= M;
			}

		}
		System.out.println(start - 1);
	}

}