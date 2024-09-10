import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split=in.readLine().split(" ");
		int N=Integer.parseInt(split[0]);
		int M=Integer.parseInt(split[1]);
		
		int[][] board=new int[N][M];
		for(int i=0;i<N;i++) {
			String[] tmp=in.readLine().split(" ");
			for(int j=0;j<M;j++) {
				board[i][j]=Integer.parseInt(tmp[j]);
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				int tmp=0;
				if(i-1>=0 && j-1>=0) {
					tmp=Math.max(tmp, board[i-1][j-1]);
				}
				if(i-1>=0) {
					tmp=Math.max(tmp, board[i-1][j]);
				}
				if(j-1>=0) {
					tmp=Math.max(tmp, board[i][j-1]);
				}
				board[i][j]+=tmp;
			}
		}
		System.out.println(board[N-1][M-1]);
	}

}