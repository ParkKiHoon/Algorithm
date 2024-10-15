import java.util.*;
class Solution {
    public int solution(String[] maps) {
        int N=maps.length;
        int M=maps[0].length();
        
        char[][] board=new char[N][M];
        int[][] visited=new int[N][M];
        
        
        int sx=-1;
        int sy=-1;
        int lx=-1;
        int ly=-1;
        int a=1;
        int ex=-1;
        int ey=-1;
        
        for(int i=0;i<maps.length;i++){
            char[] split=maps[i].toCharArray();
            for(int j=0;j<maps[0].length();j++){
                board[i][j]=split[j];
                if(board[i][j]=='S'){
                    sx=i;
                    sy=j;
                }else if(board[i][j]=='E'){
                    ex=i;
                    ey=j;
                }else if(board[i][j]=='L'){
                    lx=i;
                    ly=j;
                }
            }
        }

        Deque<int[]> pq = new ArrayDeque<>();
        pq.offerLast(new int[]{sx,sy,0});
        
        int[] dx={1,-1,0,0};
        int[] dy={0,0,1,-1};
        
        visited[sx][sy]=1;
        int cnt=0;
        while(!pq.isEmpty()){
            int[] cur=pq.pollFirst();
            if(cur[0]==lx && cur[1]==ly){
                cnt+=cur[2];
                break;
            }
            for(int i=0;i<4;i++){
                int nx=cur[0]+dx[i];
                int ny=cur[1]+dy[i];
                if(nx>=0 && nx<N && ny>=0 && ny<M && visited[nx][ny]==0 && board[nx][ny]!='X'){
                    visited[nx][ny]=1;
                    pq.offerLast(new int[]{nx,ny,cur[2]+1});
                }
            }
        }
        if(cnt==0){
            return -1;
        }
        visited= new int[N][M];
        pq = new ArrayDeque<>();
        pq.offerLast(new int[]{lx,ly,cnt});
        visited[lx][ly]=1;
        cnt=0;
        while(!pq.isEmpty()){
            int[] cur=pq.pollFirst();
            if(cur[0]==ex && cur[1]==ey){
                cnt=cur[2];
                break;
            }
            for(int i=0;i<4;i++){
                int nx=cur[0]+dx[i];
                int ny=cur[1]+dy[i];
                if(nx>=0 && nx<N && ny>=0 && ny<M && visited[nx][ny]==0 && board[nx][ny]!='X'){
                    visited[nx][ny]=1;
                    pq.offerLast(new int[]{nx,ny,cur[2]+1});
                }
            }
        }
        if(cnt==0){
            return -1;
        }
        return cnt;
    }
}