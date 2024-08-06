import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        
        /**
         * 0. 입력파일 읽어들이기
         */

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        // 결과를 한 번에 출력하기 위한 StringBuilder
        StringBuilder sb = new StringBuilder();
        
        int T;
        //T = Integer.parseInt(in.readLine());
        T=10;
        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#" + test_case + " ");
            
            // 여러분의 알고리즘 코드 작성하기
            //int testCase = Integer.parseInt(in.readLine());
            String notuse = in.readLine();
            int[][] board=new int[100][100];
            for(int i=0; i<100; i++) {
                String line = in.readLine();
                String[] arr = line.split(" ");
                for (int j =0; j<100; j++) {
                	board[i][j]=Integer.parseInt(arr[j]);
                }
            }
            int tmp=0;
            int ans=0;
            for(int i=0;i<100;i++) {
            	tmp=0;
            	for(int j=0;j<100;j++) {
            		tmp+=board[i][j];
            	}
            	ans=Math.max(ans,tmp);
            }

            for(int i=0;i<100;i++) {
            	tmp=0;
            	for(int j=0;j<100;j++) {
            		tmp+=board[j][i];
            	}
            	ans=Math.max(ans,tmp);
            }
            
            tmp=0;
            for(int i=0;i<100;i++) {
            	tmp+=board[i][i];
            }
            ans=Math.max(ans,tmp);
            
            tmp=0;
            for(int i=0;i<100;i++) {
            	tmp+=board[i][99-i];
            }
            ans=Math.max(ans,tmp);
            
            sb.append(ans);
            sb.append('\n');
            
        }
        
        System.out.println(sb);
    }
}