import java.util.*;

class Solution {
    public int solution(int[] topping) {
        
        int ans=0;
        
        HashMap<Integer,Integer> map1=new HashMap<>();
        HashMap<Integer,Integer> map2=new HashMap<>();
        for(int i:topping){
            if(map1.containsKey(i)){
                int tmp=map1.get(i);
                map1.replace(i,tmp+1);
            }else{
                map1.put(i,1);
            }
        }
        
        for(int i:topping){
            int tmp=map1.get(i);
            if(tmp==1){
                map1.remove(i);
            }
            else{
                map1.replace(i,tmp-1);
            }
            if(map2.containsKey(i)){
                int tmp2=map2.get(i);
                map2.replace(i,tmp+1);
            }
            else{
                map2.put(i,1);
            }
            
            if(map1.size()==map2.size()){
                ans++;
            }
        }
        
        
        return ans;
    }
}