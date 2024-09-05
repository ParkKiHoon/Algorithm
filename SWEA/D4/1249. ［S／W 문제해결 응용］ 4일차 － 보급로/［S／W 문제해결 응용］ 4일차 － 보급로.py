import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T;
		T = Integer.parseInt(in.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");

			N = Integer.parseInt(in.readLine());
			board = new int[N][N];
			visited = new int[N][N];
			for (int i = 0; i < N; i++) {
				String[] split = in.readLine().split("");
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(split[j]);
					visited[i][j]=Integer.MAX_VALUE;
				}
			}

			sol(0, 0);
			sb.append(visited[N-1][N-1]);
			sb.append("\n");
		}

		System.out.println(sb);
	}

	static int N;
	static int[] dx = { 1, 0, 0, -1 };
	static int[] dy = { 0, 1, -1, 0 };
	static int[][] board;
	static int[][] visited;

	private static void sol(int startX, int startY) {

		PriorityQueue<Node> queue= new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.cost-o2.cost;
			}
		});
		
		queue.add(new Node(startX,startY,0));
		visited[startX][startY]=0;
		
		while(!queue.isEmpty()) {
			Node cur=queue.poll();
			int x=cur.x;
			int y=cur.y;
			int cost=cur.cost;
			
			if(cost>visited[x][y]) {
				continue;
			}
			for(int i=0;i<4;i++) {
				int nx=cur.x+dx[i];
				int ny=cur.y+dy[i];
				if(0<=nx && nx<N && 0<=ny && ny<N) {
					int newCost=cost+board[nx][ny];
					if(newCost<visited[nx][ny]) {
						visited[nx][ny]=newCost;
						queue.add(new Node(nx, ny,newCost));
					}
				}
			}
		}
		

	}
	
	static class Node{
		int x,y,cost;
		Node(int x, int y,int cost){
			this.x=x;
			this.y=y;
			this.cost=cost;
		}
	}
}