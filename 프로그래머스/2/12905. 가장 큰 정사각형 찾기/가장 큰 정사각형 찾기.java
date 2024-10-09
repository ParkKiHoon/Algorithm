import java.util.*;
class Solution
{
    public int solution(int [][]board)
    {
        int[][] dp=new int[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                dp[i][j]=board[i][j];
            }
        }
        
        if(board.length<2 || board[0].length<2){
            int tmp=0;
            for(int i=0;i<board.length;i++){
                for(int j=0;j<board[0].length;j++){
                    tmp+=board[i][j];
                }
            }
            if(tmp>0){
                return 1;
            }else{
                return 0;
            }
        }
        int ans=0;
        for(int i=1;i<board.length;i++){
            for(int j=1;j<board[0].length;j++){
                if(dp[i][j]==0){
                    continue;
                }
                dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                ans=Math.max(ans,dp[i][j]);
            }
        }

        return ans*ans;
    }
}