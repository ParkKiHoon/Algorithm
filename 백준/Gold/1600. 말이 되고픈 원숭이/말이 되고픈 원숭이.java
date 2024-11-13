import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws Exception {

        // System.setIn(new FileInputStream("input.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(in.readLine());
        String[] split = in.readLine().split(" ");

        int W = Integer.parseInt(split[0]);  // 5
        int H = Integer.parseInt(split[1]);  // 2
        int[][] map = new int[H][W];

        for (int i = 0; i < H; i++) {
            split = in.readLine().split(" ");
            for (int j = 0; j < split.length; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }

        visited = new boolean[H][W][K + 1];
        int ans = bfs(map, 0, 0, 0, 0, K);
        System.out.println(ans);

    }

    public static boolean[][][] visited;
    static int[] hx = {2, -2, -1, 1, -2, -1, 1, 2};
    static int[] hy = {1, 1, 2, 2, -1, -2, -2, -1};
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static int bfs(int[][] map, int s, int e, int hJump, int mJump, int K) {


        Queue<int[]> queue = new ArrayDeque<>();
        visited[s][e][0] = true;
        queue.offer(new int[]{s, e, hJump, mJump});  // x값, y값, 말 점프, 전체 점프


        while (!queue.isEmpty()) {

            int[] poll = queue.poll();
            s = poll[0];
            e = poll[1];
            hJump = poll[2];
            mJump = poll[3];

            // 목적지에 도달 시
            if (s == map.length - 1 && e == map[0].length - 1) {
                return mJump;
            }

            // 원숭이 점프 탐색
            for (int i = 0; i < 4; i++) {
                int nx = s + dx[i];
                int ny = e + dy[i];

                if (nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length) {
                    continue;
                }

                if (visited[nx][ny][hJump]) continue;

                if (map[nx][ny] == 0) {  // 0일때만 방문
                    visited[nx][ny][hJump] = true;
                    queue.offer(new int[]{nx, ny, hJump, mJump + 1});
                }
            }

            // 말 점프 횟수 남았을 시
            if (hJump < K) {
                for (int i = 0; i < 8; i++) {
                    int nx = s + hx[i];
                    int ny = e + hy[i];

                    if (nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length) {
                        continue;
                    }

                    if (visited[nx][ny][hJump + 1]) continue;

                    if (map[nx][ny] == 0) {
                        visited[nx][ny][hJump + 1] = true;
                        queue.offer(new int[]{nx, ny, hJump + 1, mJump + 1});
                    }
                }
            }
        }

        return -1;
    }


}