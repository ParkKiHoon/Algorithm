import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 수열의 크기를 읽어들임
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N]; // 원래 수열 저장
        int[] dp = new int[N];  // LIS 길이 추적을 위한 배열
        int[] trace = new int[N]; // LIS의 실제 경로 추적을 위한 배열
        
        // 수열의 요소들을 읽어 배열에 저장
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        
        // LIS 추적 변수
        ArrayList<Integer> lis = new ArrayList<>(); // LIS 수열 값을 저장할 리스트
        lis.add(arr[0]);
        dp[0] = 1; // 첫 번째 요소는 초기화
        trace[0] = 0;

        // LIS 알고리즘 실행
        for (int i = 1; i < N; i++) {
            int pos = Collections.binarySearch(lis, arr[i]);
            
            // 삽입 위치 찾기
            if (pos < 0) pos = -pos - 1;
            
            // 새로운 LIS 값을 업데이트하거나 대체
            if (pos == lis.size()) {
                lis.add(arr[i]);
            } else {
                lis.set(pos, arr[i]);
            }
            
            // dp와 trace에 위치 기록
            dp[i] = pos + 1; // dp에 LIS 길이 기록
            trace[i] = pos; // trace에 LIS 경로 기록
        }

        // LIS 길이 출력
        System.out.println(lis.size());

        // 역추적하여 LIS 수열 찾기
        int maxIndex = lis.size();
        Stack<Integer> stack = new Stack<>(); // 수열을 역추적하여 저장할 스택

        for (int i = N - 1; i >= 0; i--) {
            if (dp[i] == maxIndex) {
                stack.push(arr[i]);
                maxIndex--;
            }
        }

        // LIS 수열 출력
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}