import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());

		int[][] board = new int[N][N];
		for (int i = 0; i < N; i++) {
			String[] split = in.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(split[j]);
			}
		}

		max=0;
		for(int i=0;i<4;i++) {
			get(board,0);
			board=rotate(board);
		}
		System.out.println(max);
	}

	static int N;
	static int max;
	
	private static int[][] rotate(int[][] board) {
		int[][] new_board=new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				new_board[i][j]=board[j][N-1-i];
			}
		}
		return new_board;
	}


	static void get(int[][] board,int depth) {

		if(depth==5) {
			for (int i = 0; i < N; i++) {
				for(int j=0;j<N;j++) {
					max=Math.max(board[i][j], max);
				}
			}
			return;
		}
		
		int[][] new_board = new int[N][N];

		for (int i = 0; i < N; i++) {
			Deque<int[]> deque = new ArrayDeque<>();
			for (int j = 0; j < N; j++) {
				int cur = board[i][j];

				if (cur == 0) {
					continue;
				} else {
					if (deque.size() >= 1) {
						if (deque.peekLast()[1] == 1) {
							deque.offerLast(new int[] { cur, 0 });
						} else if (deque.peekLast()[1] == 0 && deque.peekLast()[0] == cur) {
							deque.pollLast();
							deque.offerLast(new int[] { cur * 2, 1 });
						} else {
							deque.offerLast(new int[] { cur, 0 });
						}
					} else {
						deque.offerLast(new int[] { cur, 0 });
					}
				}
			}

			int size = deque.size();
			for (int j = 0; j < size; j++) {
				new_board[i][j] = deque.pollFirst()[0];
			}
		}

		for(int i=0;i<4;i++) {
			get(new_board,depth+1);
			new_board=rotate(new_board);
		}
		//get(new_board,depth+1);
		
	}

}