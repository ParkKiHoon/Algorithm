import java.lang.*;
class Solution {
    public int[] solution(String s) {
        int try2=0;
        int ans=0;
        while(true){
            int cnt=0;
            int del=0;
            for(char ch:s.toCharArray()){
                if(ch=='1'){
                    cnt++;
                }
                else{
                    del++;
                }
            }
            s=Integer.toBinaryString(cnt);
            try2++;
            ans+=del;
            if(Integer.toBinaryString(cnt).equals("1")){
                return new int[]{try2,ans};
            }
        }
        
    }
}