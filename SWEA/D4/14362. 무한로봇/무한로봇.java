import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	private static int T;
	private static int[] dx = { 1, 0, -1, 0 }; // x 방향으로의 이동 (오른쪽, 아래, 왼쪽, 위)
	private static int[] dy = { 0, 1, 0, -1 }; // y 방향으로의 이동
	private static int direction; // 방향 (0: 오른쪽, 1: 아래, 2: 왼쪽, 3: 위)

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			String commands = in.readLine();
			direction = 0;
			int x = 0, y = 0;
			int maxDistance = 0;
			boolean infinity = true;

			for (int i = 0; i < 4; i++) {

				for (char command : commands.toCharArray()) {
					if (command == 'L') {
						direction = (direction + 3) % 4;
					} else if (command == 'R') {
						direction = (direction + 1) % 4;
					} else if (command == 'S') { // S : 전진
						x += dx[direction];
						y += dy[direction];
					}

					int dis = x * x + y * y;
					maxDistance = Math.max(dis, maxDistance);
				}

				if (x == 0 && y == 0 && direction == 0) {
					infinity = false;
					break;
				}
				infinity = true;
			}
			System.out.println("#" + t + " " + (infinity ? "oo" : maxDistance));
		}
	}
}