import java.io.BufferedReader;
import java.io.InputStreamReader;import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) throws Exception {   
       BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
       StringBuilder sb = new StringBuilder();
       int T;
       T=10;
       
       for (int test_case = 1; test_case <= T; test_case++) {
           sb.append("#" + test_case + " ");
            
           // 여러분의 알고리즘 코드 작성하기
           int len = Integer.parseInt(in.readLine().split(" ")[1]);
           int[][] arr = new int[2][100];
           String[] str = in.readLine().split(" ");
           for(int i=0; i<str.length; i=i+2) {
        	   int t1=Integer.parseInt(str[i]);
        	   int t2=Integer.parseInt(str[i+1]);
        	   if(arr[0][t1]==0) {
        		   arr[0][t1]=t2;
        	   }
        	   else {
        		   arr[1][t1]=t2;
        	   }
           }
           
           Stack<Integer> stk=new Stack<>();
           stk.add(0);
           int success=0;
           while(stk.size()!=0) {
        	   int tmp=stk.pop();
        	   if(tmp==99) {
        		   sb.append(1);
        		   success=1;
        		   break;
        	   }
        	   
        	   if(arr[0][tmp]!=0) {
        		   stk.add(arr[0][tmp]);
        	   }
        	   if(arr[1][tmp]!=0) {
        		   stk.add(arr[1][tmp]);
        	   }

           }
           
           if(success==0) {
        	   sb.append(0);
           }
           sb.append('\n');
            
       }
        
       System.out.println(sb);
    }
}