import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int id=0;
        for(int[] tmp:commands){
            int[] arr= new int[tmp[1]-tmp[0]+1];
            int ind=0;
            for(int i=tmp[0]-1;i<tmp[1];i++){
                arr[ind]=array[i];
                ind++;
            }
            Arrays.sort(arr);
            answer[id]=arr[tmp[2]-1];
            id++;
            //System.out.println(arr[tmp[2]-1]);
        }
        return answer;
    }
}