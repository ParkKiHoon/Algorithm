import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:tangerine){
            if(map.containsKey(i)){
                map.replace(i,map.get(i)+1);
            }else{
                map.put(i,1);
            }
        }
        PriorityQueue<int[]> pq=new PriorityQueue<int[]>(new Comparator<>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o2[1]-o1[1];
            }
        });
        
        for(int i:map.keySet()){
            pq.offer(new int[]{i,map.get(i)});
        }
        
        while(k>0){
            int[] tmp=pq.poll();
            k-=tmp[1];
            answer++;
        }
        
        return answer;
    }
}


