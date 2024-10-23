import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] split = in.readLine().split(" ");
		int N = Integer.parseInt(split[0]);
		int M = Integer.parseInt(split[1]);
		int[][] board = new int[N][M];
		for (int i = 0; i < N; i++) {
			split = in.readLine().split("");
			for (int j = 0; j < M; j++) {
				int tmp = Integer.parseInt(split[j]);
				if (tmp == 1) {
					board[i][j] = -1;
				} else {
					board[i][j] = 0;
				}
			}
		}

		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };

		int ind = -2;
//		int[][] conn = new int[N][M];

		HashMap<Integer,Integer> map=new HashMap<>();
		//ArrayList<int[]> arr = new ArrayList<>();
		Deque<int[]> deque = new ArrayDeque<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 0) {
					int x = i;
					int y = j;

					int cnt = 1;
//					arr.clear();
					deque.clear();
					
					//arr.add(new int[] { x, y });
					deque.offerLast(new int[] { x, y });
					
					board[i][j] = ind;

					while (!deque.isEmpty()) {
						int[] queue = deque.pollFirst();

						for (int d = 0; d < 4; d++) {
							int nx = queue[0] + dx[d];
							int ny = queue[1] + dy[d];
							if (nx >= 0 && nx < N && ny >= 0 && ny < M && board[nx][ny] == 0) {
								board[nx][ny] = ind;
								deque.offerLast(new int[] { nx, ny });
								//arr.add(new int[] { nx, ny });
								cnt++;
							}
						}
					}

//					for (int[] ar : arr) {
//						board[ar[0]][ar[1]] = cnt;
//						conn[ar[0]][ar[1]] = ind;
//					}
					map.put(ind, cnt);
					ind--;
				}
			}
		}

//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(board[i]));
//		}
//		System.out.println();
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(conn[i]));
//		}
		
		int[][] ans =new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(board[i][j]==-1) {
					HashSet<Integer> set=new HashSet<>();
					for(int d=0;d<4;d++) {
						int nx=i+dx[d];
						int ny=j+dy[d];
						if(nx >= 0 && nx < N && ny >= 0 && ny < M && board[nx][ny]!=-1) {
							set.add(board[nx][ny]);
						}
					}
					int tmp=1;
					for(Integer se:set) {
						tmp+=map.get(se);
					}
					ans[i][j]=tmp;
				}
			}
		}


		for (int i = 0; i < N; i++) {
			for(int j=0;j<M;j++) {
				System.out.print(ans[i][j]%10);
			}
			System.out.println();
		}
	}
}