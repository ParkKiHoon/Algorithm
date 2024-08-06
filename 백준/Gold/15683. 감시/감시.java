import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int n, m;
    static int[][] board;
    static List<int[]> cctv = new ArrayList<>();
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][][] direct = {
        {},
        {{1}, {2}, {3}, {4}},
        {{1, 3}, {2, 4}},
        {{1, 2}, {2, 3}, {3, 4}, {4, 1}},
        {{1, 2, 3}, {2, 3, 4}, {3, 4, 1}, {4, 1, 2}},
        {{1, 2, 3, 4}}
    };
    static int min_val = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = sc.nextInt();
                if (board[i][j] >= 1 && board[i][j] <= 5) {
                    cctv.add(new int[]{board[i][j], i, j});
                }
            }
        }

        dfs(0, board);
        System.out.println(min_val);
    }

    static void search(int[][] arr, int[] dir, int x, int y) {
        for (int d : dir) {
            int nx = x;
            int ny = y;
            while (true) {
                nx += dx[d - 1];
                ny += dy[d - 1];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    break;
                }
                if (arr[nx][ny] == 6) {
                    break;
                }
                if (arr[nx][ny] == 0) {
                    arr[nx][ny] = 7;
                }
            }
        }
    }

    static void dfs(int depth, int[][] board) {
        if (depth == cctv.size()) {
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] == 0) {
                        cnt++;
                    }
                }
            }
            min_val = Math.min(min_val, cnt);
            return;
        }

        int[][] tmp = new int[n][m];
        for (int i = 0; i < n; i++) {
            tmp[i] = Arrays.copyOf(board[i], m);
        }

        int[] now = cctv.get(depth);
        int type = now[0], x = now[1], y = now[2];

        for (int[] dir : direct[type]) {
            search(tmp, dir, x, y);
            dfs(depth + 1, tmp);

            for (int i = 0; i < n; i++) {
                tmp[i] = Arrays.copyOf(board[i], m);
            }
        }
    }
}