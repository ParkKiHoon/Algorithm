import java.util.*;
class Solution {
    public int solution(int[][] board) {
        int N=board.length;

        PriorityQueue<int[]> pq= new PriorityQueue<>(new Comparator<int[]>(){
            
            @Override
            public int compare(int[] o1,int o2[]){
                return o1[2]-o2[2];
            }
        });
        
        // 상 하 좌 우
        int[] dx={-1,1,0,0};
        int[] dy={0,0,-1,1};
        
        
        int ans=99999999;
        int[][][] visited=new int[N][N][4];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                for(int k=0;k<4;k++){
                    visited[i][j][k]=99999999;
                }
            }
        }
        
        visited[0][0][0]=0;visited[0][0][1]=0;visited[0][0][2]=0;visited[0][0][3]=0;
        
        if(board[0][1]==0){
            pq.offer(new int[]{0,1,100,3});
            visited[0][1][3]=100;
        }
        if(board[1][0]==0){
            pq.offer(new int[]{1,0,100,1});
            visited[1][0][1]=100;
        }
        
        while(!pq.isEmpty()){
            int[] cur=pq.poll();
            int cx=cur[0];
            int cy=cur[1];
            int cv=cur[2];
            int cd=cur[3];
            
            if(cx==N-1 && cy==N-1){
                ans=Math.min(ans,cv);
            }
            
            for(int i=0;i<4;i++){
                int nx=cx+dx[i];
                int ny=cy+dy[i];
                if(nx>=0 && nx<N && ny>=0 && ny<N && board[nx][ny]!=1){
                    if(i==cd){
                        if(visited[nx][ny][i]>cv+100){
                            pq.offer(new int[]{nx,ny,cv+100,i});
                            visited[nx][ny][i]=cv+100;
                        }
                    }else{
                        if(visited[nx][ny][i]>cv+600){
                            pq.offer(new int[]{nx,ny,cv+600,i});
                            visited[nx][ny][i]=cv+600;
                        }
                    }     
                }
            }
        }
        
        return ans;
    }
}