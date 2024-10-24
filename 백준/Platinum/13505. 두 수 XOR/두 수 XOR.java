import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main {

	static class Node {

		HashMap<Character, Node> child;
		boolean isEnd;

		Node() {
			this.child = new HashMap<>();
			this.isEnd = false;
		}

	}

	static class Trie {

		Node root;

		Trie() {
			this.root = new Node();
		}

		void insert(String str) {
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

		String search(String str) {
			Node node = this.root;
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				if (ch == '1') {
					if (node.child.containsKey('0')) {
						node = node.child.get('0');
						sb.append("1");
					} else{
						node=node.child.get('1');
						sb.append("0");
					}
				}else{
					if (node.child.containsKey('1')) {
						node = node.child.get('1');
						sb.append("1");
					} else{
						node=node.child.get('0');
						sb.append("0");
					}
				}
			}

			return sb.toString();
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());

		String[] arr = new String[N];
		String[] split = in.readLine().split(" ");
		int maxLen = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.toBinaryString(Integer.parseInt(split[i]));
			maxLen = Math.max(maxLen, arr[i].length());
		}

		for (int i = 0; i < N; i++) {
			if (arr[i].length() < maxLen) {
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < maxLen - arr[i].length(); j++) {
					sb.append("0");
				}
				sb.append(arr[i]);
				arr[i] = sb.toString();
			}
		}

		//System.out.println(Arrays.toString(arr));

		Trie trie = new Trie();
		for (int i = 0; i < N; i++) {
			trie.insert(arr[i]);
		}

		int ans = 0;
		for (int i = 0; i < N; i++) {
			ans = Math.max(ans, Integer.parseUnsignedInt(trie.search(arr[i]), 2));
		}
		System.out.println(ans);

	}
}