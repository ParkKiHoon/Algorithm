import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
 
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
 
            int cnt=0;
            for(int i=0; i<100; i++) {
                int flag=0;
                for(int j=0; j<100; j++) {
                    if(board[j][i]==1) {
                        flag=1;
                    }
                    else if(board[j][i]==2 && flag==1) {
                        cnt++;
                        flag=0;
                    }
                }
 
            }
            sb.append(cnt);
            sb.append('\n');
             
        }
         
        System.out.println(sb);
    }
}