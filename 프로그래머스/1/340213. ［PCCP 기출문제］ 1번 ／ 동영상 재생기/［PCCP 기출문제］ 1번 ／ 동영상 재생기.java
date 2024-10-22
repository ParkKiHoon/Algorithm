class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String[] split=video_len.split(":");
        int len=Integer.parseInt(split[0])*60+Integer.parseInt(split[1]);
        split=pos.split(":");
        int cur=Integer.parseInt(split[0])*60+Integer.parseInt(split[1]);
        
        split=op_start.split(":");
        int ops=Integer.parseInt(split[0])*60+Integer.parseInt(split[1]);
        
        split=op_end.split(":");
        int ope=Integer.parseInt(split[0])*60+Integer.parseInt(split[1]);
    
        if(cur>= ops && cur<=ope){
            cur=ope;
        }
        
        for(String s:commands){
            if(s.equals("next")){
                cur+=10;
                if(cur>=len){
                    cur=len;
                }
                if(cur>= ops && cur<=ope){
                    cur=ope;
                }
            }else if(s.equals("prev")){
                cur-=10;
                if(cur<=0){
                    cur=0;
                }
                if(cur>= ops && cur<=ope){
                    cur=ope;
                }   
            }
        }
        int h=cur/60;
        int m=cur%60;
        String ans="";
        if(h<10){
            ans+="0"+h;
        }else{
            ans+=h+"";
        }
        
        ans+=":";
        if(m<10){
            ans+="0"+m;
        }else{
            ans+=m+"";
        }
        return ans;
    }
}