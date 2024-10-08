import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        
        int sum=0;
        int i=0;
        int j=people.length-1;
        while(i<=j){
            //System.out.println(people[i]+people[j]);
            if(people[i]+people[j]>limit){
                j--;
                answer++;
            }
            else{
                j--;
                i++;
                answer++;
            }
            
            //System.out.println(i+" "+j+ " "+answer);
        }
        return answer;
    }
}