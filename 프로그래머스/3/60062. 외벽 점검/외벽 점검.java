import java.util.*;
class Solution {
    public int solution(int n, int[] weak2, int[] dist) {
        int[][] weak=new int[weak2.length][weak2.length];
        Deque<Integer> deque=new ArrayDeque<>();
        for(int i : weak2){
            deque.offerLast(i);
        }
        weak[0]=weak2.clone();
        for(int i=1;i<weak2.length;i++){
            deque.offerLast(deque.pollFirst()+n);
            for(int j=0;j<weak2.length;j++){
                weak[i][j]=deque.pollFirst();
            }
            for(int j=0;j<weak2.length;j++){
                deque.offerLast(weak[i][j]);
            }
        }

        
        int[] visited=new int[dist.length];
        int[] output=new int[dist.length];
        ans=99999999;
        perm(weak,dist,visited,output,0,dist.length,dist.length);
        
        if(ans==99999999){
            return -1;
        }else
        return ans;
    }
    
    static int ans;
    public void perm(int[][] weak,int[] dist,int[] visited,int[] output,int depth, int n, int r){
        if(depth==r){
            
            for(int[] w:weak){
                int start=w[0];
                int ind=0;
                for(int i=0;i<output.length;i++){
                    start+=output[i];
                    if(start>=w[w.length-1]){
                        ans=Math.min(ans,i+1);
                        break;
                    }
                    for(int w2:w){
                        if(w2>start){
                            start=w2;
                            break;
                        }
                    }
                }
                //System.out.println(ans);
            }
            //System.out.println(Arrays.toString(output));
            
            return;
        }
        
        for(int i=0;i<n;i++){
            if(visited[i]==0){
                visited[i]=1;
                output[depth]=dist[i];
                perm(weak,dist,visited,output,depth+1,n,r);
                visited[i]=0;
            }
        }
    }
}