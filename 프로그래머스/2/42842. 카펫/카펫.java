class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};

            
        for(int i=3;i<brown/2;i++){
            int s=i-2;
            int e=brown/2-i;
            if(s*e==yellow){
                return new int[]{e+2,s+2};
            }


        }
        
        
        return answer;
    }
}