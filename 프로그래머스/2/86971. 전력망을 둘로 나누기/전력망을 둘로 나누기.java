import java.util.*;
class Solution {
    public int solution(int n, int[][] wires) {
        ArrayList<Integer>[] arr=new ArrayList[n+1];
        for(int i=0;i<n+1;i++){
            arr[i]=new ArrayList();
        }
        for(int[] wire:wires){
            int w1=wire[0];
            int w2=wire[1];
            arr[w1].add(w2);
            arr[w2].add(w1);
        }
        
        int ans=99999999;
        for(int[] wire:wires){
            int w1=wire[0];
            int w2=wire[1];
            arr[w1].remove(Integer.valueOf(w2));
            arr[w2].remove(Integer.valueOf(w1));
            
            int[] visited=new int[n+1];
            Deque<Integer> deque = new ArrayDeque<>();
            deque.offerLast(1);
            int cnt=0;
            visited[1]=1;
            while(!deque.isEmpty()){
                int q=deque.pollFirst();
                cnt++;
                for(int i:arr[q]){
                    if(visited[i]==0){
                        visited[i]=1;
                        deque.offerLast(i);
                    }
                }
            }
            
            ans=Math.min(ans,Math.abs(n-cnt-cnt));
            //System.out.println(w1+" "+w2+" "+cnt);
            
            arr[w1].add(w2);
            arr[w2].add(w1);
        }
        return ans;
    }
}