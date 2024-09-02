import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T;
		T = Integer.parseInt(in.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");

			String[] nm = in.readLine().split(" ");
			int N = Integer.parseInt(nm[0]);
			int M = Integer.parseInt(nm[1]);

			int[][] board = new int[N][M];

			int x = 0;
			int y = 0;
			for (int i = 0; i < N; i++) {
				String[] tmp = in.readLine().split("");
				for (int j = 0; j < M; j++) {
					board[i][j] = Integer.parseInt(tmp[j]);
					if (board[i][j] == 1) {
						x = Math.max(x, i);
						y = Math.max(y, j);
					}
				}
			}
			y -= 55;

			Map<Integer, Integer> map = new HashMap<>();
			map.put(Integer.parseUnsignedInt("0001101", 2), 0);
			map.put(Integer.parseUnsignedInt("0011001", 2), 1);
			map.put(Integer.parseUnsignedInt("0010011", 2), 2);
			map.put(Integer.parseUnsignedInt("0111101", 2), 3);
			map.put(Integer.parseUnsignedInt("0100011", 2), 4);
			map.put(Integer.parseUnsignedInt("0110001", 2), 5);
			map.put(Integer.parseUnsignedInt("0101111", 2), 6);
			map.put(Integer.parseUnsignedInt("0111011", 2), 7);
			map.put(Integer.parseUnsignedInt("0110111", 2), 8);
			map.put(Integer.parseUnsignedInt("0001011", 2), 9);

			int odd = 0;
			int even = 0;
			int cnt = 0;
			StringBuilder bin= new StringBuilder();
			for (int i = 0; i < 56; i++) {
				bin.append(board[x][y+i]);
				if ((i+1) % 7 == 0 && i>1) {
					int tmp=Integer.parseUnsignedInt(bin.toString(),2);
					if (cnt % 2 == 0) {
						odd+=map.get(tmp);
					} else {
						even+=map.get(tmp);
					}
					cnt++;
					bin.setLength(0);
				}
			}

			if((odd*3+even)%10==0) {
				sb.append(odd+even);
			}
			else {
				sb.append(0);
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}
}