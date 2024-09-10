import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());
		int[][] arr = new int[31][31];
		arr[0][0] = 0;

		for (int i = 0; i < 31; i++) {
			for (int j = 0; j < 31; j++) {
				if (j > i) {
					continue;
				} else if (i == j || j==0) {
					arr[i][j]=1;
				} else {
					arr[i][j] = arr[i - 1][j] + arr[i - 1][j - 1];
				}
			}
		}

		for (int i = 0; i < N; i++) {
			String[] tmp = in.readLine().split(" ");
			int n = Integer.parseInt(tmp[1]);
			int r = Integer.parseInt(tmp[0]);
			System.out.println(arr[n][r]);
		}
	}

}