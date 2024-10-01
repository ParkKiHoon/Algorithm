import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		board = new int[5][5];
		int[][] linkTo = new int[25 + 1][2];
		for (int i = 0; i < 5; i++) {
			String[] tmp = in.readLine().split(" ");
			for (int j = 0; j < 5; j++) {
				board[i][j] = Integer.parseInt(tmp[j]);
				linkTo[board[i][j]][0] = i;
				linkTo[board[i][j]][1] = j;
			}
		}

		bingoX = new int[5];
		bingoY = new int[5];
		bingoZ = new int[2];
		cnt = 0;

		label:
		for (int i = 0; i < 5; i++) {
			String[] tmp = in.readLine().split(" ");
			for (int j = 0; j < 5; j++) {
				int ind = Integer.parseInt(tmp[j]);
				int x = linkTo[ind][0];
				int y = linkTo[ind][1];
				board[x][y] = 0;
				checkX(x, y);
				checkY(x, y);
				checkZ(x, y);
				if (cnt >= 3) {
					System.out.println(5*i+j+1);
					break label;
				}
			}
		}

		
	}

	static int[][] board;
	static int[] bingoX;
	static int[] bingoY;
	static int[] bingoZ;
	static int cnt;

	private static void checkX(int x, int y) {
		if (bingoX[x] == 1) {
			return;
		}

		int check = 0;
		for (int i = 0; i < 5; i++) {
			if (board[x][i] > 0) {
				check++;
			}
		}
		if (check == 0) {
			bingoX[x] = 1;
			cnt++;
		}
	}

	private static void checkY(int x, int y) {
		if (bingoY[y] == 1) {
			return;
		}

		int check = 0;
		for (int i = 0; i < 5; i++) {
			if (board[i][y] > 0) {
				check++;
			}
		}
		if (check == 0) {
			bingoY[y] = 1;
			cnt++;
		}
	}

	private static void checkZ(int x, int y) {
		if (x == 2 && y == 2) {
			if(bingoZ[0]==0) {
				int check=0;
				for(int i=0;i<5;i++) {
					if(board[i][i]>0) {
						check++;
					}
				}
				if (check == 0) {
					bingoZ[0] = 1;
					cnt++;
				}
			}
			
			if(bingoZ[1]==0) {
				int check=0;
				for(int i=0;i<5;i++) {
					if(board[i][4-i]>0) {
						check++;
					}
				}
				if (check == 0) {
					bingoZ[1] = 1;
					cnt++;
				}
			}
		}else if(x==y) {
			if(bingoZ[0]==0) {
				int check=0;
				for(int i=0;i<5;i++) {
					if(board[i][i]>0) {
						check++;
					}
				}
				if (check == 0) {
					bingoZ[0] = 1;
					cnt++;
				}
			}
		}else if(x==4-y) {
			if(bingoZ[1]==0) {
				int check=0;
				for(int i=0;i<5;i++) {
					if(board[i][4-i]>0) {
						check++;
					}
				}
				if (check == 0) {
					bingoZ[1] = 1;
					cnt++;
				}
			}
		}
	}
}