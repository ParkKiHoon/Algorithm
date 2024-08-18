import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
 
public class Solution {
 
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T;
        T = Integer.parseInt(in.readLine());
 
        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#" + test_case + " ");

            String[] split = in.readLine().split(" ");
            N=Integer.parseInt(split[0]);
            K=Integer.parseInt(split[1]);
            board=new int[N][N];
            visited=new int[N][N];
            ans=0;
            int maxVal=0;
            for(int i=0;i<N;i++) {
            	String[] tmp=in.readLine().split(" ");
            	for(int j=0;j<N;j++) {
            		board[i][j]=Integer.parseInt(tmp[j]);
            		maxVal=Math.max(maxVal, board[i][j]);
            	}
            }
            ArrayList<int[]> pos=new ArrayList<>();
            for(int i=0;i<N;i++) {
            	for(int j=0;j<N;j++) {
            		if(board[i][j]==maxVal) {
            			pos.add(new int[] {i,j});
            		}
            	}
            }
            for(int[] i : pos) {
            	visited[i[0]][i[1]]=1;
            	dfs(i[0],i[1],0,board[i[0]][i[1]],1);
            	visited[i[0]][i[1]]=0;
            }
            sb.append(ans+1);
            sb.append("\n");
 
        }
 
        System.out.println(sb);
    }
    
    static int ans;
    static int N;
    static int K;
    static int[][] board;
    static int[] dx= {1,-1,0,0};
    static int[] dy= {0,0,1,-1};
    static int[][] visited;
    static void dfs(int x,int y,int sum,int before,int use) {
    	if(sum>ans) {
    		ans=sum;
    	}
    	for(int i=0; i<4; i++) {
    		int cx=x+dx[i];
    		int cy=y+dy[i];
    		if(cx>=0 && cx<N && cy>=0 && cy<N && visited[cx][cy]==0) {
    			if(board[cx][cy]<before) {
    				visited[cx][cy]=1;
    				dfs(cx,cy,sum+1,board[cx][cy],use);
    				visited[cx][cy]=0;
    			}else if(use == 1){
    				int tmp=0;
    				while(tmp!=K) {
    					tmp++;
    					if(board[cx][cy]-tmp<before){
    						visited[cx][cy]=1;
    						dfs(cx,cy,sum+1,board[cx][cy]-tmp,0);
    						visited[cx][cy]=0;
    						break;
    					}
    				}
    			}
    		}
    	}
    }
}