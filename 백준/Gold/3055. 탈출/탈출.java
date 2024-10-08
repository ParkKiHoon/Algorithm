import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] split = in.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);

        char[][] board = new char[N][M];
        int[][] visited = new int[N][M]; // 0: 미방문, 1: 고슴도치 방문, -1: 물 방문

        Deque<int[]> deque = new ArrayDeque<>();
        Deque<int[]> water = new ArrayDeque<>();

        int startX = -1, startY = -1, endX = -1, endY = -1;

        for (int i = 0; i < N; i++) {
            split = in.readLine().split("");
            for (int j = 0; j < M; j++) {
                board[i][j] = split[j].charAt(0);
                if (board[i][j] == 'S') {
                    startX = i;
                    startY = j;
                } else if (board[i][j] == 'D') {
                    endX = i;
                    endY = j;
                } else if (board[i][j] == '*') {
                    water.add(new int[] { i, j });
                    visited[i][j] = -1;
                }
            }
        }

        // 고슴도치 초기 위치
        deque.add(new int[] { startX, startY });
        visited[startX][startY] = 1;

        int[] dx = { 1, -1, 0, 0 };
        int[] dy = { 0, 0, 1, -1 };

        int time = 0;

        while (!deque.isEmpty()) {
            time++;

            // 물이 먼저 확산
            int waterSize = water.size();
            for (int w = 0; w < waterSize; w++) {
                int[] cur = water.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = cur[0] + dx[i];
                    int ny = cur[1] + dy[i];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < M && visited[nx][ny] == 0 && board[nx][ny] == '.') {
                        visited[nx][ny] = -1;
                        water.add(new int[] { nx, ny });
                    }
                }
            }

            // 고슴도치 이동
            int dequeSize = deque.size();
            for (int d = 0; d < dequeSize; d++) {
                int[] cur = deque.poll();
                if (cur[0] == endX && cur[1] == endY) {
                    System.out.println(time - 1);
                    return;
                }
                for (int i = 0; i < 4; i++) {
                    int nx = cur[0] + dx[i];
                    int ny = cur[1] + dy[i];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < M && visited[nx][ny] == 0 && (board[nx][ny] == '.' || board[nx][ny] == 'D')) {
                        visited[nx][ny] = 1;
                        deque.add(new int[] { nx, ny });
                    }
                }
            }
        }

        System.out.println("KAKTUS");
    }
}