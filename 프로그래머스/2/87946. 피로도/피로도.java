import java.util.*;
class Solution {
    public int solution(int k, int[][] dungeons) {
        int[] visited=new int[dungeons.length];
        ans=0;
        dfs(0,k,visited,dungeons);
        return ans;
    }
    
    static int ans;
    public void dfs(int depth,int k,int[] visited,int[][] dungeons){
        for(int i=0;i<visited.length;i++){
            if(visited[i]==0 && k>=dungeons[i][0]){
                visited[i]=1;
                dfs(depth+1,k-dungeons[i][1],visited,dungeons);
                visited[i]=0;
            }
        }
        
        //System.out.println(Arrays.toString(visited));
        ans=Math.max(ans,depth);
    }
}
