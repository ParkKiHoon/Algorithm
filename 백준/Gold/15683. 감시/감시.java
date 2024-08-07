import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	static int[][] board;
	static List<int[]> cctv=new ArrayList<>();
	static int N;
	static int M;
	static int[] dx= {-1,0,1,0};
	static int[] dy= {0,1,0,-1};
	static int[][][] dir= {
			{},
			{{0},{1},{2},{3}},
			{{0,2},{1,3}},
			{{0,1},{1,2},{2,3},{3,0}},
			{{0,1,3},{0,1,2},{1,2,3},{2,3,0}},
			{{0,1,2,3}}
	};
	static int min=Integer.MAX_VALUE;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] xy=br.readLine().split(" ");
        N=Integer.parseInt(xy[0]);
        M=Integer.parseInt(xy[1]);
        int[][] board = new int[N][M];
        for(int i=0; i<N; i++) {
        	String[] tmp=br.readLine().split(" ");
        	for(int j=0; j<tmp.length; j++) {
        		board[i][j]=Integer.parseInt(tmp[j]);
        		if(board[i][j]>=1 && board[i][j]<=5) {
        			cctv.add(new int[] {board[i][j],i,j});
        		}
        	}
        }
        
        dfs(0,board);
        System.out.println(min);
    }

    static void search(int[] directions,int[][] board, int nx, int ny) {
    	for (int d : directions) {
    		int x=nx;
    		int y=ny;
			while(true) {
				if(x+dx[d]<0 || x+dx[d]>=N || y+dy[d]<0 || y+dy[d]>=M || board[x+dx[d]][y+dy[d]]==6  ) {
					break;
				}
				x+=dx[d];
				y+=dy[d];
				if(board[x][y]==0) {
					board[x][y]=7;
				}
			}
		}
    }
    
    static void dfs(int depth, int[][] board) {
    	if(depth==cctv.size()) {
    		int cnt=0;
    		for(int i=0; i<N; i++) {

    			for(int j=0; j<M; j++) {
    				if(board[i][j]==0) {
    					cnt++;
    				}
    			}
    		}
    		min=Math.min(min, cnt);

    		return;
    	}
    	
    	int[][] newBoard=new int[N][M];
    	for(int i=0;i<N;i++) {
    		for(int j=0;j<M;j++) {
    			newBoard[i][j]=board[i][j];
    		}
    	}
    	int t=cctv.get(depth)[0], x=cctv.get(depth)[1], y=cctv.get(depth)[2];
    	
    	
    	for(int[] d:dir[t]) {

    		search(d,newBoard,x,y);
    		dfs(depth+1,newBoard);

        	for(int i=0;i<N;i++) {
        		for(int j=0;j<M;j++) {
        			newBoard[i][j]=board[i][j];
        		}
        	}
    	}
    }

}