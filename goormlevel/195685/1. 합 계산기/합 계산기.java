import java.io.*;
import java.util.*;
class Main {
    public static void main(String[] args) throws Exception {
        //입력값 처리하는 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //결과값 출력하는 BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        int result = 0;
        //계산식 저장 및 계산 진행
        for(int i=0;i<T;i++){
            st = new StringTokenizer(br.readLine()," ");
            int left = Integer.parseInt(st.nextToken());
            String operation = st.nextToken();
            int right = Integer.parseInt(st.nextToken());
            if(operation.equals("+")){		// +
                result += left + right;
            }else if(operation.equals("-")){		// -
                result += left - right;
            }else if(operation.equals("*")){		// ×
                result += left * right;
            }else{			//÷
                result += left / right;
            }
        }
        //계산된 값의 합을 BufferedWriter 저장
        bw.write(String.valueOf(result));
        bw.flush();		//결과 출력
        bw.close();
        br.close();
    }
}