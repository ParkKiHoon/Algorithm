import java.util.*;
class Solution {
    public int solution(int[][] land, int height) {
        int N=land.length;
        
        int[][] visited=new int[N][N];
        int[] dx={1,-1,0,0};
        int[] dy={0,0,1,-1};
        int cnt=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
                    @Override
                    public int compare(int[] o1, int[] o2){
                        return o1[2]-o2[2];
                    }
                });
                
                pq.offer(new int[]{i,j,land[i][j]});
                if(visited[i][j]==0){
                    cnt++;
                    visited[i][j]=cnt;
                }
                while(!pq.isEmpty()){
                    int[] q=pq.poll();
                    for(int d=0;d<4;d++){
                        int nx=q[0]+dx[d];
                        int ny=q[1]+dy[d];
                        if(nx>=0 && nx<N && ny>=0 && ny<N && visited[nx][ny]==0){
                            int val=land[nx][ny];
                            if(Math.abs(q[2]-val)<=height){
                                visited[nx][ny]=cnt;
                                pq.offer(new int[]{nx,ny,val});
                            }
                        }
                    }
                }

            }
        }
        
        HashMap<Integer,Integer>[] map=new HashMap[cnt+1];
        for(int i=0;i<cnt+1;i++){
            map[i]=new HashMap();
        }
        
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                int pos=visited[i][j];
                for(int d=0;d<4;d++){
                    int nx=i+dx[d];
                    int ny=j+dy[d];
                    if(nx>=0 && nx<N && ny>=0 && ny<N){
                        if(visited[nx][ny]!=visited[i][j]){
                            int next=visited[nx][ny];
                            if(map[pos].containsKey(next)){
                                int changeVal=Math.min(map[pos].get(next), Math.abs(land[nx][ny]- land[i][j]));
                                map[pos].replace(next, changeVal);
                            }else{
                                map[pos].put(next,Math.abs(land[nx][ny]- land[i][j]));
                            }
                        }
                    }
                }
            }
        }
               

        
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
                    @Override
                    public int compare(int[] o1, int[] o2){
                        return o1[1]-o2[1];
                    }
                });
        
        pq.offer(new int[]{1,0});
        int[] pq_visited=new int[cnt+1];

        int ans=0;
        while(!pq.isEmpty()){
            int[] queue=pq.poll();
            int cur=queue[0];
            int val=queue[1];
            //System.out.println(cur+" "+val);
            //System.out.println(Arrays.toString(pq_visited));
            if(pq_visited[cur]==1){
                continue;
            }
            pq_visited[cur]=1;
            ans+=val;
            //System.out.println(cur+" "+val);
            for(int key: map[cur].keySet()){

                int next=key;
                int nextVal=map[cur].get(next);
                //System.out.println(next+" "+nextVal);
                if(pq_visited[next]==0){
                    //pq_visited[next]=1;
                    pq.offer(new int[]{next,nextVal});
                }
            }
            
        }
        
        return ans;
    }
}