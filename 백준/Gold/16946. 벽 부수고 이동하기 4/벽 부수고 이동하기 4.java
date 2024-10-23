import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] split = in.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);

        int[][] board = new int[N][M];
        for (int i = 0; i < N; i++) {
            split = in.readLine().split("");
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(split[j]);
            }
        }

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int[][] area = new int[N][M];  // 각 구역의 번호
        int[] areaSize = new int[N * M + 1];  // 각 구역의 크기
        int areaIndex = 1;

        // BFS로 각 구역의 크기 계산
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 0 && area[i][j] == 0) {
                    Queue<int[]> queue = new ArrayDeque<>();
                    queue.offer(new int[]{i, j});
                    area[i][j] = areaIndex;
                    int size = 1;

                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        int x = cur[0], y = cur[1];
                        for (int d = 0; d < 4; d++) {
                            int nx = x + dx[d];
                            int ny = y + dy[d];
                            if (nx >= 0 && nx < N && ny >= 0 && ny < M && board[nx][ny] == 0 && area[nx][ny] == 0) {
                                area[nx][ny] = areaIndex;
                                queue.offer(new int[]{nx, ny});
                                size++;
                            }
                        }
                    }
                    areaSize[areaIndex] = size;
                    areaIndex++;
                }
            }
        }

        // 각 벽을 부쉈을 때 이동 가능한 칸의 수 계산
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 1) {
                    Set<Integer> connectedAreas = new HashSet<>();
                    int moveCount = 1;  // 벽을 부쉈으므로 1칸은 기본
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        if (nx >= 0 && nx < N && ny >= 0 && ny < M && area[nx][ny] > 0) {
                            connectedAreas.add(area[nx][ny]);
                        }
                    }
                    for (int areaId : connectedAreas) {
                        moveCount += areaSize[areaId];
                    }
                    sb.append(moveCount % 10);
                } else {
                    sb.append(0);
                }
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}