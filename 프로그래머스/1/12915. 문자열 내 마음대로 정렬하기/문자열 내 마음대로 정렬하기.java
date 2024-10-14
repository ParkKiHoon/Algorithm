import java.util.*;
class Solution {
    public String[] solution(String[] strings, int n) {
        
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<>(){
           
            @Override
            public int compare(String s1, String s2){
                if(s1.charAt(n)==s2.charAt(n)){
                    return s1.compareTo(s2);
                }else{
                    return s1.charAt(n)-s2.charAt(n);
                }
            }
            
        });
        for(String s:strings){
            pq.offer(s);
        }
        for(int i=0;i<strings.length;i++){
            
            strings[i]=pq.poll();
        }
        
        return strings;
    }
}