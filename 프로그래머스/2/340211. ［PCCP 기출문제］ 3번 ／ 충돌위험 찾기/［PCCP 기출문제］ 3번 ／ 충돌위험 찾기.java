import java.util.*;
class Solution {
    public int solution(int[][] points, int[][] routes) {
        
        
        
        
        Deque<int[]>[] deque = new ArrayDeque[routes.length];
        for(int i=0;i<routes.length;i++){
            deque[i]=new ArrayDeque();
        }
        
        for(int i=0;i<routes.length;i++){
            int[] cur=points[routes[i][0]-1];
            int x=cur[0];
            int y=cur[1];
            deque[i].offerLast(new int[]{x,y});
            
            for(int j=1;j<routes[i].length;j++){
                int[] next=points[routes[i][j]-1];
                int nextx=next[0];
                int nexty=next[1];
                while(true){
                    
                    if(x==nextx && y==nexty){
                        //deque[i].offer(new int[]{x,y});
                        break;
                    }
                    if(nextx>x){
                        x++;
                    }else if(nextx<x){
                        x--;
                    }else if(nexty<y){
                        y--;
                    }else if(nexty>y){
                        y++;
                    }
                    deque[i].offerLast(new int[]{x,y});
                }
                

            }
        }
        

        
        int ans=0;
        HashMap<String,Integer> map=new HashMap<>();
        while(true){
            int nokori=0;
            for(Deque q:deque){
                nokori+=q.size();
            }
            if(nokori==0){
                break;
            }
            
            map.clear();
            for(Deque<int[]> q:deque){
                
                if(q.size()==0){
                    continue;
                }
                int[] tmp=q.pollFirst();
                String str=tmp[0]+","+tmp[1];
                map.put(str,map.getOrDefault(str,0)+1);
            }
            
            for(String str:map.keySet()){
                if(map.get(str)>1){
                    ans++;
                }
            }
                
            
        }
        
        
        return ans;
        
    }
}