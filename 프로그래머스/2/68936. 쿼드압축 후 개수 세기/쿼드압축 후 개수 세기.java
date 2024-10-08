import java.util.*;
class Solution {
    public int[] solution(int[][] arr) {
        int[] answer = {};
        dfs(arr,arr.length);
        return new int[]{zero,one};
    }
    static int zero=0;
    static int one=0;
    public void dfs(int[][] arr,int len){
        
        int cnt0=0;
        int cnt1=0;
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(arr[i][j]==1){
                    cnt1++;
                }else{
                    cnt0++;
                }
            }
        }
        
        if(cnt1==(len*len)){
            one+=1;
            return;
        }else if(cnt0==(len*len)){
            zero+=1;
            return;
        }
        
        if(len==1){
            zero+=cnt0;
            one+=cnt1;
            return;
        }
        
        int[][] tmp1=new int[len/2][len/2];
        int[][] tmp2=new int[len/2][len/2];
        int[][] tmp3=new int[len/2][len/2];
        int[][] tmp4=new int[len/2][len/2];
        for(int i=0;i<len/2;i++){
            for(int j=0;j<len/2;j++){
                tmp1[i][j]=arr[i][j];
            }
            for(int j=len/2;j<len;j++){
                tmp2[i][j-len/2]=arr[i][j];
            }
        }
        
        for(int i=len/2;i<len;i++){
            for(int j=0;j<len/2;j++){
                tmp3[i-len/2][j]=arr[i][j];
            }
            for(int j=len/2;j<len;j++){
                tmp4[i-len/2][j-len/2]=arr[i][j];
            }
        }
        dfs(tmp1,len/2);
        dfs(tmp2,len/2);
        dfs(tmp3,len/2);
        dfs(tmp4,len/2);
    }
}