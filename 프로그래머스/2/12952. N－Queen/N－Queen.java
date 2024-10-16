class Solution {
    static int[] board;
    static int ans;
    public int solution(int n) {
        board=new int[n];
        ans=0;
        dfs(0,n);
        return ans;
    }

    public void dfs(int d, int depth){
        if(d==depth){
            ans++;
            return;
        }
        
        for(int i=0;i<board.length;i++){
            board[d]=i;
            if(valid(d)){
                dfs(d+1,depth);
            }
        }
    }
    
    public boolean valid(int d){
        for(int i=0;i<d;i++){
            if(board[i]==board[d]){
                return false;
            }
            if(Math.abs(board[i]-board[d])==Math.abs(i-d)){
                return false;
            }
        }
        return true;
    }
}