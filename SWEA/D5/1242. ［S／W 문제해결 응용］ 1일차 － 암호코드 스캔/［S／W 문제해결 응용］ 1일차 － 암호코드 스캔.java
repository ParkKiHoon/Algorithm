import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    static Map<String, Integer> ratio = new HashMap<>();
    
    static {
        ratio.put("2,1,1", 0);
        ratio.put("2,2,1", 1);
        ratio.put("1,2,2", 2);
        ratio.put("4,1,1", 3);
        ratio.put("1,3,2", 4);
        ratio.put("2,3,1", 5);
        ratio.put("1,1,4", 6);
        ratio.put("3,1,2", 7);
        ratio.put("2,1,3", 8);
        ratio.put("1,1,2", 9);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 수 입력 받음

        for (int caseNum = 1; caseNum <= T; caseNum++) {
            int N = sc.nextInt(); // 세로줄의 개수
            int M = sc.nextInt(); // 가로줄의 개수
            Set<String> codeSet = new HashSet<>(); // 중복된 코드 제거용
            for (int i = 0; i < N; i++) {
                codeSet.add(sc.next()); // 코드를 입력 받음
            }
            List<String> code = new ArrayList<>(codeSet); // set을 리스트로 변환
            int answer = 0; // 최종 결과 값
            List<String> temps = new ArrayList<>(); // 이미 처리된 코드 저장용

            for (String line : code) {
                String result = new BigInteger(line, 16).toString(2); // 16진수를 2진수로 변환
                result = result.replaceFirst("^0+", ""); // 앞에 붙은 0 제거
                int n1 = 0, n2 = 0, n3 = 0; // 비율 계산용
                int cnt = 0; // 암호의 자릿수 세기
                int even = 0, odd = 0; // 짝수자리, 홀수자리 계산용
                String overlap = ""; // 암호 코드 누적 저장
                for (int j = 0; j < result.length(); j++) {
                    char bit = result.charAt(j);
                    if (bit == '1' && n2 == 0) {
                        n1++; // 1을 받았는데 n2가 0이면 n1을 증가
                    } else if (bit == '0' && n1 != 0 && n3 == 0) {
                        n2++; // 0을 받았는데 n1이 0이 아니고, n3이 0이면 n2 증가
                    } else if (bit == '1' && n2 != 0) {
                        n3++; // 다시 1을 받았는데 n2가 0이 아니면 n3 증가
                    } else if (n3 != 0) {
                        cnt++; // 암호 자릿수 증가
                        int r = Math.min(n1, Math.min(n2, n3)); // 비율 나누기 위한 최소값
                        String key = (n1 / r) + "," + (n2 / r) + "," + (n3 / r); // 비율로 키 만들기
                        int nums = ratio.getOrDefault(key, -1); // 해당 비율의 숫자 가져오기

                        overlap += nums; // 암호 코드 누적
                        if (cnt == 8) { // 암호가 8자리가 되었을 때
                            if ((odd * 3 + even + nums) % 10 == 0 && !temps.contains(overlap)) {
                                answer += odd + even + nums; // 유효한 암호이면 결과에 더함
                            }
                            temps.add(overlap); // 암호 중복 방지용 저장
                            even = odd = 0; // 짝수, 홀수 초기화
                            cnt = 0; // 자릿수 초기화
                            overlap = ""; // 암호 초기화
                        } else if (cnt % 2 == 0) {
                            even += nums; // 짝수 자리에 해당하는 경우
                        } else {
                            odd += nums; // 홀수 자리에 해당하는 경우
                        }
                        n1 = n2 = n3 = 0; // 비율 초기화
                    }
                }
            }
            System.out.println("#" + caseNum + " " + answer); // 최종 결과 출력
        }

        sc.close();
    }
}