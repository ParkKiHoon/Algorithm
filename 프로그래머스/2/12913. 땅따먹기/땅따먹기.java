import java.util.*;
class Solution {
    int solution(int[][] land) {
        int answer = 0;

        int[][] dp=new int[land.length][land[0].length];
        dp[0][0]=land[0][0];
        dp[0][1]=land[0][1];
        dp[0][2]=land[0][2];
        dp[0][3]=land[0][3];
        for(int i=1;i<land.length;i++){
            dp[i][0]=Math.max(dp[i-1][1],Math.max(dp[i-1][2],dp[i-1][3]))+land[i][0];
            dp[i][1]=Math.max(dp[i-1][0],Math.max(dp[i-1][2],dp[i-1][3]))+land[i][1];
            dp[i][2]=Math.max(dp[i-1][1],Math.max(dp[i-1][0],dp[i-1][3]))+land[i][2];
            dp[i][3]=Math.max(dp[i-1][1],Math.max(dp[i-1][2],dp[i-1][0]))+land[i][3];
        }

        int ind=land.length-1;

        return Math.max(dp[ind][1],Math.max(dp[ind][2],Math.max(dp[ind][3],dp[ind][0])));
    }
}