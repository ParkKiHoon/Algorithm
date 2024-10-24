import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	static public class Node {

		HashMap<Character, Node> child;
		boolean isEnd;

		Node() {
			this.child = new HashMap<>();
			this.isEnd = false;
		}

	}

	static public class Trie {

		Node root;

		Trie() {
			this.root = new Node();
		}

		public void insert(String str) {
			Node node = this.root;
			
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				if (node.child.containsKey(ch)) {
					node = node.child.get(ch);
				} else {
					node.child.put(ch, new Node());
					node = node.child.get(ch);
				}
			}

			node.isEnd = true;
		}

		public int search(String str) {
			Node node = this.root;

			int cnt = 0;
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				if (node.child.containsKey(ch)) {
					node = node.child.get(ch);
				} else {
					return 0;
				}
				if ((i != str.length() && node.isEnd == true) || node.child.size() > 1) {
					cnt++;
				}
			}

			return cnt;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while((line = in.readLine()) != null && !line.isEmpty()) {
		    int N = Integer.parseInt(line);
			Trie trie=new Trie();
			ArrayList<String> str=new ArrayList<>();
			
			double sum=0;
			for(int i=0;i<N;i++) {
				String tmp=in.readLine();
				str.add(tmp);
				trie.insert(tmp);
			}
			
			Collections.sort(str);
			
			for(String st:str) {
				sum+=trie.search(st);
			}
			
			sum/=N;
			System.out.printf("%.2f",(double)Math.round(sum*100)/100);
			System.out.println();
		}
	}
}