import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    static int N;
    static int K;
    static boolean[] visited = new boolean[100001]; // 방문 여부를 저장하는 배열

    static void BFS(int start) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offerLast(new int[]{start, 0});
        visited[start] = true;

        while (!deque.isEmpty()) {
            int[] q = deque.pollFirst();
            int position = q[0];
            int time = q[1];

            if (position == K) {
                System.out.println(time);
                return;
            }

            // X-1로 이동
            if (position - 1 >= 0 && !visited[position - 1]) {
                deque.offerLast(new int[]{position - 1, time + 1});
                visited[position - 1] = true;
            }

            // X+1로 이동
            if (position + 1 <= 100000 && !visited[position + 1]) {
                deque.offerLast(new int[]{position + 1, time + 1});
                visited[position + 1] = true;
            }

            // 2*X로 순간이동
            if (position * 2 <= 100000 && !visited[position * 2]) {
                deque.offerLast(new int[]{position * 2, time + 1});
                visited[position * 2] = true;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] split = in.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        K = Integer.parseInt(split[1]);
        BFS(N);
    }
}