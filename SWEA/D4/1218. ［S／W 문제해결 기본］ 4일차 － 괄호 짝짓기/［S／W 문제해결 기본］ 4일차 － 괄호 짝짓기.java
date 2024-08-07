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
           int len = Integer.parseInt(in.readLine());
           String order=in.readLine();
           Stack<Integer> stack = new Stack<>();
           Map<String,Integer> map=new HashMap<>();
           
           map.put("(", -1);
           map.put("[", -2);
           map.put("{", -3);
           map.put("<", -4);
           
           map.put(")", 1);
           map.put("]", 2);
           map.put("}", 3);
           map.put(">", 4);
           
           for(String s : order.split("")) {
        	   stack.add(map.get(s));
    		   while(stack.size()>1 && 
    				   stack.get(stack.size()-1)+stack.get(stack.size()-2) == 0) {
    			   stack.pop();
    			   stack.pop();
    		   }
           }
           
           sb.append(stack.size()==0? 1 : 0);
           sb.append('\n');
            
       }
        
       System.out.println(sb);
    }
}