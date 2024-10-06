import java.io.*;
import java.util.*;

public class Solution {
	
	private static class Info {
		
		int Y, X, K, C, D;
		
		public Info(int Y, int X, int K, int C, int D) {
			super();
			this.Y = Y;
			this.X = X;
			this.K = K;
			this.C = C;
			this.D = D;
		}
		
	}
	
	private static int T, N, K;
	private static int[][] map = new int[11][11];
	private static boolean[][][][] visited = new boolean[11][11][6][4];
	private static int[] moveY = { -1,0,1,0 };
	private static int[] moveX = { 0,1,0,-1 };
	private static int startY, startX;
    private static StringBuilder sb = new StringBuilder();
    
    private static void init() {
    	for (int i = 0; i < 11; i++) {
    		for (int j = 0; j < 11; j++) {
    			for (int k = 0; k < 6; k++) {
    				for (int d = 0; d < 4; d++) {
    					visited[i][j][k][d] = false;
    				}
    			}
    		}
    	}
    }
    
    private static int bfs() {
    	Queue<Info> queue = new LinkedList<>();
    	visited[startY][startX][K][0] = true;
    	queue.add(new Info(startY, startX, K, 0, 0));
    	
    	while (!queue.isEmpty()) {
    		Info now = queue.poll();
    		int nowY = now.Y;
    		int nowX = now.X;
    		int nowK = now.K;
    		int nowC = now.C;
    		int nowD = now.D;
    		
    		if (map[nowY][nowX] == 1) {
    			return nowC;
    		}
    		
    		for (int i = 0; i < 4; i++) {
    			int nextY = nowY + moveY[i];
    			int nextX = nowX + moveX[i];
    			
    			// 1. 직진
    			if (nowD == i) {
    				if ((nextY < 0) || (nextY >= N) || (nextX < 0) || (nextX >= N)) continue;
    				if (map[nextY][nextX] == -1) {
    					if (nowK > 0) {
    						if (!visited[nextY][nextX][nowK - 1][i]) {
    							visited[nextY][nextX][nowK - 1][i] = true;
    							queue.add(new Info(nextY, nextX, nowK - 1, nowC + 1, i));
    						}
    					}
    				}
    				else {
    					if (!visited[nextY][nextX][nowK][i]) {
    						visited[nextY][nextX][nowK][i] = true;
    						queue.add(new Info(nextY, nextX, nowK, nowC + 1,i));
    					}
    				}
    			}
    			
    			// 2. 오른쪽으로 90도 회전
    			if ((nowD + 1) % 4 == i) {
    				if (!visited[nowY][nowX][nowK][i]) {
    					visited[nowY][nowX][nowK][i] = true;
    					queue.add(new Info(nowY, nowX, nowK, nowC + 1, i));
    				}
    			}
    			
    			// 3. 왼쪽으로 90도 회
    			int nextD = nowD - 1;
    			if (nextD < 0) {
    				nextD = 3;
    			}
    			if (nextD == i) {
    				if (!visited[nowY][nowX][nowK][i]) {
    					visited[nowY][nowX][nowK][i] = true;
    					queue.add(new Info(nowY, nowX, nowK, nowC + 1, i));
    				}
    			}
    		}
    	}
    	
    	return -1;
    }
	
	private static void settings(int t) {
		sb.append("#" + t + " " + bfs() + "\n");
	}
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
        	init();
            String[] inputs = br.readLine().split(" ");
            N = Integer.parseInt(inputs[0]);
            K = Integer.parseInt(inputs[1]);
            for (int i = 0; i < N; i++) {
                inputs = br.readLine().split("");
            	for (int j = 0; j < N; j++) {
            		if ("G".equals(inputs[j])) {
            			map[i][j] = 0;
            		} else if ("T".equals(inputs[j])) {
            			map[i][j] = -1; 
            		} else if ("X".equals(inputs[j])) {
            			map[i][j] = 0;
            			startY = i;
            			startX = j;
            		} else if ("Y".equals(inputs[j])) {
            			map[i][j] = 1;
            		}
            	}
            }
            
            settings(t);
        }
        
        bw.write(sb.toString());
        br.close();
        bw.close();
    }

}