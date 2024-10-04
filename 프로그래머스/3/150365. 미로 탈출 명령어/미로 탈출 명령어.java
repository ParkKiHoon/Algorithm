import java.util.*;

class Solution {
    static StringBuilder sb;
    static int[] dx={1,0,0,-1};
    static int[] dy={0,-1,1,0};
    static String ans;
    static String[] dstr={"d","l","r","u"};
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        x--;
        y--;
        r--;
        c--;
        
        ans="";
        sb=new StringBuilder();
        dfs(x,y,r,c,0,k,n,m);
        if(ans==""){
            return "impossible";
        }
        else{
            return ans;
        }
    }
    
    static public void dfs(int cx, int cy, int r,int c, int ck,int k,int n,int m){
        if (!ans.equals("")) return;
        
        int distToEnd= Math.abs(r-cx)+Math.abs(c-cy);
        int remainK=k-ck;
        if(distToEnd>remainK){
            return;
        }
        if( (distToEnd%2 == 1 && remainK%2==0) || (distToEnd%2 == 0 && remainK%2==1) ){
            //System.out.println(distToEnd+ " "+remainK);
            return;
        }
        if(ck==k){
            if(cx==r && cy==c){
                String tmp=sb.toString();
                //System.out.println(tmp);
                if(ans.equals("")){
                    ans=tmp;
                }
                else if(tmp.compareTo(ans)<0){
                    ans=tmp;
                }
            }
            return;
        }
        for(int i=0;i<4;i++){
            int nx=cx+dx[i];
            int ny=cy+dy[i];
            if(nx>=0 && ny>=0 && nx<n && ny<m){
                sb.append(dstr[i]);
                dfs(nx,ny,r,c,ck+1,k,n,m);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}