import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String[] str = new String[numbers.length];
        for(int i=0;i<numbers.length;i++){
            StringBuilder sb=new StringBuilder();
            sb.append(numbers[i]);sb.append(numbers[i]);sb.append(numbers[i]);
            //System.out.println(sb);
            str[i]=sb.toString();
        }
        Arrays.sort(str,Collections.reverseOrder());
        StringBuilder sb=new StringBuilder();
        for(String s:str){
            sb.append(s.substring(0,s.length()/3));
        }
        if(sb.charAt(0)=='0'){
            return "0";
        }
        return sb.toString();
    }
}