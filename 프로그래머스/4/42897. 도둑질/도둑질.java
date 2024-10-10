import java.util.*;
class Solution {
    public int solution(int[] money) {
        int answer = 0;
        
        
        int[] dp=new int[money.length];
        dp[0]=money[0];
        dp[1]=money[0];
        for(int i=2;i<money.length-1;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+money[i]);
        }
        //System.out.println(Arrays.toString(dp));
              
        int[] dp2=new int[money.length];
        dp2[0]=0;
        dp2[1]=money[1];
        for(int i=2;i<money.length;i++){
            dp2[i]=Math.max(dp2[i-1],dp2[i-2]+money[i]);
        }
        //System.out.println(Arrays.toString(dp2)); 
        
        
        return Math.max(dp[money.length-2],dp2[money.length-1]);
    }
}

    