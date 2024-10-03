import java.util.*;
class Solution {
    public int[][] solution(int n) {
        int[][] board=new int[n][n];
        Deque<Integer> deque=new ArrayDeque<>();
        deque.add(n-1);
        for(int i=n-1;i>=1;i--){
            deque.offerLast(i);
            deque.offerLast(i);
        }
        
        
        int dir=-1;
        int x=0;
        int y=0;
        board[0][0]=1;
        int s=2;
        int[] dx={0,1,0,-1};
        int[] dy={1,0,-1,0};
        while(!deque.isEmpty()){
            int q=deque.pollFirst();
            dir=(dir+1)%4;
            for(int i=0;i<q;i++){
                x+=dx[dir];
                y+=dy[dir];
                board[x][y]=s;
                s++;
            }
        }
        return board;
    }
}