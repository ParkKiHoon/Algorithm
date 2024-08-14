import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {    
    static int[] parent;
    
    static int find(int a) {
        if (parent[a] == a) {
            return a;
        } else {
            return parent[a] = find(parent[a]);
        }        
    }
    
    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            parent[rootA] = rootB;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(in.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#" + test_case + " ");

            String[] split = in.readLine().split(" ");
            int V = Integer.parseInt(split[0]);
            int E = Integer.parseInt(split[1]);
            int[][] arr = new int[E][3];
            parent = new int[V + 1];
            for (int i = 0; i <= V; i++) {
                parent[i] = i;
            }
            for (int i = 0; i < E; i++) {
                String[] input = in.readLine().split(" ");
                arr[i][0] = Integer.parseInt(input[0]);
                arr[i][1] = Integer.parseInt(input[1]);
                arr[i][2] = Integer.parseInt(input[2]);
            }
            
            Arrays.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[2] - o2[2];
                }
            });
            
            long total = 0;
            int cnt = 0;
            for (int i = 0; i < E; i++) {
                if (cnt == V - 1) {
                    break;
                }
                if (find(arr[i][0]) != find(arr[i][1])) {
                    union(arr[i][0], arr[i][1]);
                    total += arr[i][2];
                    cnt++;
                }
            }
            sb.append(total);
			sb.append('\n');
        }
        System.out.println(sb);
    }
}