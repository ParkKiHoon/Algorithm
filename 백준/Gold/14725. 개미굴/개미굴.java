import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Main {

	static class Node {

		HashMap<String, Node> child;
		boolean isEnd;

		Node() {
			child = new HashMap<>();
			isEnd = false;
		}
	}

	static class Trie {

		Node root;

		Trie() {
			root = new Node();
		}

		void insert(int len, String[] str) {

			Node node = this.root;
			for (int i = 0; i < len; i++) {
				String s = str[i];
				if (node.child.containsKey(s)) {
					node = node.child.get(s);
				} else {
					node.child.put(s, new Node());
					node = node.child.get(s);
				}
			}

			node.isEnd = true;
		}


		void search(Node node, int depth) {
			
			ArrayList<String> arr=new ArrayList<>();
			for(String str:node.child.keySet()) {
				arr.add(str);
			}
			
			Collections.sort(arr);
			for(String str:arr) {
				StringBuilder sb= new StringBuilder();
				for(int i=0;i<depth;i++) {
					sb.append("--");
				}
				System.out.println(sb+str);
				search(node.child.get(str),depth+1);
			}
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(in.readLine());
		Trie trie=new Trie();
		for(int i=0;i<N;i++) {
			String[] split=in.readLine().split(" ");
			String[] str=new String[split.length-1];
			int ind=Integer.parseInt(split[0]);
			for(int j=0;j<str.length;j++) {
				str[j]=split[j+1];
			}
			
			trie.insert(ind, str);
		}
		trie.search(trie.root, 0);

	}
}