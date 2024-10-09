class Solution {
    public int solution(int[][] t) {
        int answer = 0;
        if(t.length==1){
            return t[0][0];
        }
        for(int i=t.length-2;i>=0;i--){
            for(int j=0;j<t[i].length;j++){
                t[i][j]+=Math.max(t[i+1][j],t[i+1][j+1]);
            }            
        }
        return t[0][0];
    }
}