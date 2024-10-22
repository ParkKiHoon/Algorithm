class Solution {
    static int[] diffs;
    static int[] times;
    static long limit;
    public int solution(int[] diffs2, int[] times2, long limit2) {
        diffs=diffs2;
        times=times2;
        limit=limit2;
        
        long start=1L;
        long end=limit;
        
        int cnt=0;
        while(start<=end){
            cnt++;
            long middle=(start+end)/2;
            //System.out.println(middle +" "+ start+ " "+ end);
            if(find(middle)==1){
                end=middle-1;                
            }
            else{
                start=middle+1;
            }
        }
        
        return (int)end+1;
    }
    
    public int find(long level){
        long time=0;
        for(int i=0;i<diffs.length;i++){
            if(level>=diffs[i]){
                time+=times[i];
            }
            else{
                if(i>=1){
                    time+=(times[i-1]+times[i])*(diffs[i]-level) + times[i];
                }
                else{
                    time+=(times[i])*(diffs[i]-level) + times[i];
                }
            }
        }
        if(time<=limit){
            return 1;
        }else{
            return 0;
        }
    }
}