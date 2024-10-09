import java.util.*;
class Solution {
    public int solution(String[] strs, String t) {
        int answer = 0;
        
        int[] dp=new int[t.length()+1];
        Arrays.fill(dp,99999999);
        dp[0]=0;
        
        for(int i=1;i<t.length()+1;i++){
            for(String str: strs){
                int size=str.length();
                if(i-size>=0 && t.substring(i-size,i).equals(str)){
                    dp[i]=Math.min(dp[i-size]+1,dp[i]);
                }
            }
        }
        
        //System.out.println(Arrays.toString(dp));
        if(dp[t.length()]==99999999){
            return -1;
        }else{
            return dp[t.length()];
        }
        
    }
}