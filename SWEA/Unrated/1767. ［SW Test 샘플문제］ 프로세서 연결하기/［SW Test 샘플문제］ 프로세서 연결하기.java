import java.util.Scanner;

class Pair {
    int x, y;
    Pair(int x, int y) { 
        this.x = x; 
        this.y = y; 
    }
}

public class Solution {
    private static int T, N, coreCount, minWireLength;
    private static int[][] grid;
    private static Pair[] cores;
    private static boolean[] selected;
    private static final int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    private static final int[] dy = {0, 0, -1, 1};

    // 코어를 선택하는 조합 함수
    public static void selectCores(int idx, int selectedCount, int total) {
        if (selectedCount == total) {
            connectCores(0, 0);
            return;
        }
        for (int i = idx; i < coreCount; i++) {
            selected[i] = true;
            selectCores(i + 1, selectedCount + 1, total);
            selected[i] = false;
        }
    }

    // 코어에 전선을 연결하는 함수
    public static void connectCores(int idx, int totalWireLength) {
        if (idx == coreCount) {
            minWireLength = Math.min(minWireLength, totalWireLength);
            return;
        }

        if (!selected[idx]) { // 선택되지 않은 코어는 다음으로 넘어간다
            connectCores(idx + 1, totalWireLength);
            return;
        }

        for (int i = 0; i < 4; i++) { // 4방향 탐색
            int x = cores[idx].x;
            int y = cores[idx].y;
            int wireLength = 0;
            boolean canConnect = false;

            while (true) {
                x += dx[i];
                y += dy[i];

                if (x < 0 || x >= N || y < 0 || y >= N) { // 전원에 도달한 경우
                    canConnect = true;
                    break;
                }

                if (grid[x][y] != 0) break; // 다른 전선이나 코어에 막힌 경우

                grid[x][y] = 2; // 전선 놓기
                wireLength++;
            }

            if (canConnect) connectCores(idx + 1, totalWireLength + wireLength);

            // 전선을 놓기 전에 상태 복구 (백트래킹)
            while (true) {
                x -= dx[i];
                y -= dy[i];
                if (x == cores[idx].x && y == cores[idx].y) break;
                grid[x][y] = 0; // 전선 제거
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();
            grid = new int[N][N];
            cores = new Pair[12];
            selected = new boolean[12];
            coreCount = 0;
            minWireLength = Integer.MAX_VALUE;

            // 입력 받기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            // 가장자리를 제외한 Core 좌표 수집
            for (int i = 1; i < N - 1; i++) {
                for (int j = 1; j < N - 1; j++) {
                    if (grid[i][j] == 1) {
                        cores[coreCount++] = new Pair(i, j);
                    }
                }
            }

            // 연결 가능한 코어 개수별로 전선 길이 계산
            for (int i = coreCount; i >= 0; i--) {
                selectCores(0, 0, i);
                if (minWireLength < Integer.MAX_VALUE) break; // 최솟값 갱신되면 탐색 중단
            }

            System.out.println("#" + t + " " + minWireLength);
        }
        sc.close();
    }
}