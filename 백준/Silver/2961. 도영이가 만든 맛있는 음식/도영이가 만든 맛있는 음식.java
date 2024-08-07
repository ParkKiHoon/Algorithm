import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	

	static int min=Integer.MAX_VALUE;
    static boolean[] used;
    static int num;
    static int[] flavor1;
    static int[] flavor2;
    
    static int cal(boolean[] used) {
    	int f1=1;
    	int f2=0;
    	for(int i=0;i<used.length;i++) {
    		if(used[i]==true) {
    			f1*=flavor1[i];
    			f2+=flavor2[i];
    		}
    	}
    	return Math.abs(f2-f1);
    }
    
	static void find(int depth) {
		if(depth==num) {
			int trueCnt=0;
			for (boolean b : used) {
				if(b==true) {
					trueCnt++;
				}
			}
			if(trueCnt>0) {
				min=Math.min(min, cal(used));
			}

			return;
		}
		
		used[depth]=true;
		find(depth+1);
		
		used[depth]=false;
		find(depth+1);
	}
	
	public static void main(String[] args) throws Exception {   
       BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
       StringBuilder sb = new StringBuilder();
       int T;
       T=1;
       
       for (int test_case = 1; test_case <= T; test_case++) {
           sb.append("#" + test_case + " ");
            
           // 여러분의 알고리즘 코드 작성하기
           min=Integer.MAX_VALUE;
           num = Integer.parseInt(in.readLine());
           flavor1= new int[num];
           flavor2= new int[num];
           for(int i=0; i<num; i++) {
        	   String[] str = in.readLine().split(" ");
        	   flavor1[i]=Integer.parseInt(str[0]);
        	   flavor2[i]=Integer.parseInt(str[1]);  	   
           }
           
           
	        used=new boolean[num];
	        for(int i=0; i<num; i++) {
	        	used[i]=false;
	        }

	        find(0);
          
            
       }
        
       System.out.println(min);
    }
}