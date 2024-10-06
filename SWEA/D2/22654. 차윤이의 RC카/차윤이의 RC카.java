import java.io.*;
import java.util.*;

public class Solution {

    // 방향을 나타내는 배열 (위, 오른쪽, 아래, 왼쪽 순서)
    private static final int[] dY = { -1, 0, 1, 0 };
    private static final int[] dX = { 0, 1, 0, -1 };
    
    // 필드 정보와 현재 RC카 위치 및 목적지 위치
    private static char[][] field;
    private static int startY, startX, goalY, goalX;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // 테스트 케이스 수 입력
        int T = Integer.parseInt(br.readLine().trim());
        
        for (int t = 1; t <= T; t++) {
            // 필드 크기 N 입력
            int N = Integer.parseInt(br.readLine().trim());
            field = new char[N][N];

            // 필드 정보 입력
            for (int i = 0; i < N; i++) {
                String line = br.readLine().trim();
                for (int j = 0; j < N; j++) {
                    field[i][j] = line.charAt(j);
                    if (field[i][j] == 'X') {
                        startY = i;
                        startX = j;
                    }
                    if (field[i][j] == 'Y') {
                        goalY = i;
                        goalX = j;
                    }
                }
            }
            
            // 조종 명령의 수 Q 입력
            int Q = Integer.parseInt(br.readLine().trim());
            
            sb.append("#").append(t).append(" ");
            
            // 각 명령어에 대한 실행 결과 확인
            for (int q = 0; q < Q; q++) {
                String[] commandInput = br.readLine().split(" ");
                int C = Integer.parseInt(commandInput[0]);  // 커맨드의 길이
                String commands = commandInput[1];  // 커맨드 내용
                
                // 시작 위치 및 방향 초기화 (위쪽)
                int y = startY, x = startX;
                int direction = 0;  // 방향 (0: 위, 1: 오른쪽, 2: 아래, 3: 왼쪽)
                
                // 명령어 실행
                for (char cmd : commands.toCharArray()) {
                    if (cmd == 'R') {
                        direction = (direction + 1) % 4;  // 오른쪽 회전
                    } else if (cmd == 'L') {
                        direction = (direction + 3) % 4;  // 왼쪽 회전 (모듈러로 3 더함)
                    } else if (cmd == 'A') {
                        // 앞으로 이동
                        int nextY = y + dY[direction];
                        int nextX = x + dX[direction];
                        
                        // 이동할 수 있는지 확인
                        if (nextY >= 0 && nextY < N && nextX >= 0 && nextX < N && field[nextY][nextX] != 'T') {
                            y = nextY;
                            x = nextX;
                        }
                    }
                }
                
                // 최종 위치가 목적지인 경우
                if (y == goalY && x == goalX) {
                    sb.append("1 ");
                } else {
                    sb.append("0 ");
                }
            }
            
            sb.append("\n");
        }
        
        System.out.print(sb.toString());
        br.close();
    }
}
