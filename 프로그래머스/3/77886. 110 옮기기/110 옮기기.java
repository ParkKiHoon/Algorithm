import java.util.*;
class Solution {
    public String[] solution(String[] s) {
        
        String[] answer = new String[s.length];
        for(int i=0;i<s.length;i++){
            answer[i]=dfs(s[i]);
        }
        
        return answer;
    }
    
    public String dfs(String str){
        Deque<Character> stk= new ArrayDeque<>();
        int cnt=0;
        for(char ch : str.toCharArray()){
            if(stk.size()>=2){
                char tmp1=stk.pollLast();
                char tmp2=stk.pollLast();
                if(tmp2=='1' && tmp1=='1' && ch=='0'){
                    cnt++;
                }else{
                    stk.offerLast(tmp2);
                    stk.offerLast(tmp1);
                    stk.offerLast(ch);
                }
            }else{
                stk.offerLast(ch);
            }
        }

        int indZero=-1;
        int ind=1;
        for(int i: stk){
            if(i=='0'){
                indZero=ind;
            }
            ind++;
        }

        if(indZero==-1){
            indZero=0;
        }
        
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<indZero;i++){
            sb.append(stk.pop());
        }
        for(int i=0;i<cnt;i++){
            sb.append("110");
        }
        while(!stk.isEmpty()){
            sb.append(stk.pop());
        }
        return sb.toString();
    }
}
