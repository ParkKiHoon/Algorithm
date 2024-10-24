import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Main {

	
	static public class Node{
		
		HashMap<Character,Node> child;
		boolean isEnd;
		
		Node(){
			this.child=new HashMap<>();
			this.isEnd=false;
		}
		
	}
	
	
	static public class Trie{
		
		Node root;
		
		Trie(){
			this.root=new Node();
		}
		
		
		void insert(String str) {
			
			Node node=this.root;
			for(int i=0;i<str.length();i++) {
				char ch=str.charAt(i);
				
				if(node.child.containsKey(ch)) {
					node=node.child.get(ch);
				}else {
					node.child.put(ch, new Node());
					node=node.child.get(ch);
				}
			}
			
			node.isEnd=true;
			
		}
		
		
		boolean search(String str) {
			
			Node node=this.root;
			for(int i=0;i<str.length();i++) {
				char ch=str.charAt(i);
				
				if(node.child.containsKey(ch)) {
					node=node.child.get(ch);
				}else {
					return false;
				}
			}
			
			return node.isEnd;
		}
		
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		ArrayList<String> words = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			words.add(in.readLine());
		}
		
		trie=new Trie();
		for(String word:words) {
			trie.insert(word);
		}
		
		in.readLine();
		int M = Integer.parseInt(in.readLine());
		for (int i = 0; i < M; i++) {
			char[][] board = new char[4][4];
			for (int j = 0; j < 4; j++) {
				String split = in.readLine();
				for (int k = 0; k < 4; k++) {
					board[j][k] = split.charAt(k);
				}
			}
			in.readLine();
			visited = new int[4][4];
			StringBuilder sb = new StringBuilder();
			set=new HashSet[9];
			for(int j=1;j<9;j++) {
				set[j]=new HashSet<>();
			}
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < 4; k++) {
					visited[j][k] = 1;
					sb.setLength(0);
					sb.append(board[j][k]);
					dfs(board, j, k, sb,0);
					visited[j][k] = 0;
				}
				//System.out.println(Arrays.toString(board[j]));
			}
			int max=0;
			int ans=0;
			int cnt=0;
			for(int j=1;j<9;j++) {
				if(set[j].size()>0) {
					max=j;
				}
				
				ans+=set[j].size()*value[j];
				cnt+=set[j].size();
			}
			
			PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					return o1.compareTo(o2);
				}
			});
			
			for(String sr:set[max]) {
				pq.offer(sr);
			}
			System.out.println(ans+ " "+ pq.poll()+" "+cnt);

		}
	}

	static int[][] visited;
	static int[] value= {0,0,0,1,1,2,3,5,11};
	static int[] dx = { 1, -1, 0, 0, -1, -1, 1, 1 };
	static int[] dy = { 0, 0, 1, -1, -1, 1, 1, -1 };
	static int score;
	static HashSet<String>[] set;
	static Trie trie;
	private static void dfs(char[][] board, int x, int y, StringBuilder sb,int depth) {
		
		if (depth==8) {
			return;
		}
		
		
		String tmp=sb.toString();
		if(trie.search(tmp)) {
			int len=depth+1;
			set[len].add(tmp);
		}
		//System.out.println(sb);
		for(int i=0;i<8;i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			if(nx>=0 && nx<4 && ny>=0 && ny<4 && visited[nx][ny]==0) {
				visited[nx][ny]=1;
				dfs(board,nx,ny,sb.append(board[nx][ny]),depth+1);
				visited[nx][ny]=0;
				sb.setLength(sb.length()-1);
			}
		}
		
	}
}