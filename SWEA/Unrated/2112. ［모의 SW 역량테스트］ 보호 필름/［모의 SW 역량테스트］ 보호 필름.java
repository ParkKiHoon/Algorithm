import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    // 전역 변수 선언
    static int D, W, K; // D: 두께, W: 가로크기, K: 합격 기준
    static int[][] map; // 보호 필름의 정보를 저장하는 2D 배열
    static int min; // 약품을 투입한 최소 횟수

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 수
        int TC = Integer.parseInt(br.readLine());

        // 각 테스트 케이스 처리
        for (int test_case = 1; test_case <= TC; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            D = Integer.parseInt(st.nextToken()); // 필름의 두께
            W = Integer.parseInt(st.nextToken()); // 필름의 가로 크기
            K = Integer.parseInt(st.nextToken()); // 성능 검사 합격 기준
            map = new int[D][W]; // 필름의 셀 정보를 담는 배열
            min = Integer.MAX_VALUE; // 최소 약품 투입 횟수

            // 필름 정보를 입력받아 2D 배열에 저장
            for (int i = 0; i < D; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // DFS 탐색 시작 (필름의 첫 번째 막부터 탐색)
            dfs(0, 0);

            // 결과 출력
            sb.append('#').append(test_case).append(' ').append(min == Integer.MAX_VALUE ? 0 : min).append('\n');
        }

        // 결과 출력
        System.out.print(sb);
    }

    // DFS 탐색 함수
    private static void dfs(int k, int cnt) {
        // 이미 최소 투입 횟수를 넘는 경우 더 이상 탐색할 필요 없음
        if (cnt >= min) 
            return;
        
        // 마지막 막까지 탐색이 완료된 경우
        if (k == D) {
            // 성능검사 통과 여부를 확인
            loop: for (int i = 0; i < W; i++) {
                int same = 1; // 연속된 셀의 동일한 특성 개수를 셈
                for (int j = 0; j < D - 1; j++) {
                    if (map[j][i] == map[j + 1][i]) { // 현재와 다음 셀의 특성이 같으면 same 증가
                        same++;
                    } else {
                        same = 1; // 특성이 다르면 다시 1로 초기화
                    }

                    if (same >= K) { 
                        continue loop; // 기준을 만족하는 열이면 다음 열 검사로 넘어감
                    }
                }
                return; // 성능검사를 통과하지 못하는 열이 있으면 종료
            }
            // 모든 열이 성능검사를 통과했으면 최소 투입 횟수 갱신
            min = Math.min(min, cnt);
            return;
        }

        // 현재 막을 변경하지 않고 다음 단계로 이동
        int[] tmp = map[k].clone(); // 현재 막 상태를 백업
        dfs(k + 1, cnt); // 막 변경 없이 탐색

        // A 약품 투입 후 탐색
        Arrays.fill(map[k], 0); // 현재 막의 모든 셀을 특성 A로 변경
        dfs(k + 1, cnt + 1); // 약품을 투입했으므로 cnt를 1 증가

        // B 약품 투입 후 탐색
        Arrays.fill(map[k], 1); // 현재 막의 모든 셀을 특성 B로 변경
        dfs(k + 1, cnt + 1); // 약품을 투입했으므로 cnt를 1 증가

        // 원래 상태로 복구
        map[k] = tmp;
    }
}