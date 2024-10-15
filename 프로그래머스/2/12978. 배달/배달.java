import java.util.*;
class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        ArrayList<int[]>[] arr=new ArrayList[N+1];
        for(int i=0;i<N+1;i++){
            arr[i]=new ArrayList();
        }
        for(int[] i:road){
            arr[i[0]].add(new int[]{i[1],i[2]});
            arr[i[1]].add(new int[]{i[0],i[2]});
        }
        
        int[] dist=new int[N+1];
        Arrays.fill(dist,99999999);
        dist[1]=0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[1]-o2[1];
            }
        });
        
        pq.offer(new int[]{1,0});
        while(!pq.isEmpty()){
            int[] cur=pq.poll();
            int curPos=cur[0];
            int curDist=cur[1];
            if(curDist<dist[curPos]){
                continue;
            }
            for(int[] next:arr[curPos]){
                int nextPos=next[0];
                int nextDist=next[1]+curDist;
                if(dist[nextPos]>nextDist){
                    dist[nextPos]=nextDist;
                    pq.offer(new int[]{nextPos,nextDist});
                }
            }
        }
        int ans=0;
        for(int d:dist){
            if(d<=K){
                ans++;
            }
        }
        return ans;
    }
}