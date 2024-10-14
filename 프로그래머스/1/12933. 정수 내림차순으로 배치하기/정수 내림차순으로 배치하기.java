import java.util.*;
class Solution {
    public long solution(long n) {
        int[] arr=new int[10];
        String str=n+"";
        for(char ch : str.toCharArray()){
            int ind=ch-'0';
            arr[ind]++;
        }
        

        StringBuilder sb=new StringBuilder();
        for(int i=9;i>=0;i--){

            for(int j=0;j<arr[i];j++){
                sb.append(i);
            }
        }
        return Long.parseLong(sb.toString());
    }
}