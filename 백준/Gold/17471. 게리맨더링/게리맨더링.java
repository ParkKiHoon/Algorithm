
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    
    static int N;
    static int[] population;
    static ArrayList<Integer>[] adjList;
    static boolean[] visited;
    static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        population = new int[N + 1];
        adjList = new ArrayList[N + 1];
        
        String[] popInput = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            population[i] = Integer.parseInt(popInput[i - 1]);
            adjList[i] = new ArrayList<>();
        }
        
        for (int i = 1; i <= N; i++) {
            String[] line = br.readLine().split(" ");
            int adjCount = Integer.parseInt(line[0]);
            for (int j = 1; j <= adjCount; j++) {
                int adjNode = Integer.parseInt(line[j]);
                adjList[i].add(adjNode);
            }
        }

        // 모든 경우의 수 탐색
        for (int i = 1; i <= (1 << N) - 1; i++) {
            ArrayList<Integer> groupA = new ArrayList<>();
            ArrayList<Integer> groupB = new ArrayList<>();

            for (int j = 1; j <= N; j++) {
                if ((i & (1 << (j - 1))) != 0) {
                    groupA.add(j);
                } else {
                    groupB.add(j);
                }
            }

            if (groupA.size() > 0 && groupB.size() > 0) {
                if (isConnected(groupA) && isConnected(groupB)) {
                    int popA = getPopulation(groupA);
                    int popB = getPopulation(groupB);
                    minDiff = Math.min(minDiff, Math.abs(popA - popB));
                }
            }
        }

        System.out.println(minDiff == Integer.MAX_VALUE ? -1 : minDiff);
    }

    // 각 그룹의 연결성을 확인하는 BFS
    static boolean isConnected(ArrayList<Integer> group) {
        visited = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(group.get(0));
        visited[group.get(0)] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int neighbor : adjList[current]) {
                if (group.contains(neighbor) && !visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                    count++;
                }
            }
        }

        return count == group.size();
    }

    // 각 그룹의 인구 수 계산
    static int getPopulation(ArrayList<Integer> group) {
        int sum = 0;
        for (int node : group) {
            sum += population[node];
        }
        return sum;
    }
}