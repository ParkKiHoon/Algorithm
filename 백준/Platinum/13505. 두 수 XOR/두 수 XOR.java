import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main {

	static int height = 31;

	static class Node {

		HashMap<Integer, Node> child;

		Node() {
			child = new HashMap<>();
		}

	}

	static class Trie {

		Node root;

		Trie() {
			root = new Node();
		}

		void insert(int num) {
			Node node = this.root;
			for (int i = height; i >= 0; i--) {
				int bit = (num >> i) & 1;
				if (!node.child.containsKey(bit)) {
					node.child.put(bit, new Node());
				}
				node = node.child.get(bit);
			}

		}

		int search(int num) {
			Node node = this.root;
			int result=0;
			for (int i = height; i >= 0; i--) {
				int bit = (num >> i) & 1;
				int opposit = bit == 0 ? 1 : 0;
				if(node.child.containsKey(opposit)) {
					node=node.child.get(opposit);
					result=result|(1<<i);
				}else {
					node=node.child.get(bit);
				}
			}

			return result;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());

		int[] arr = new int[N];
		String[] split = in.readLine().split(" ");
		int max = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(split[i]);
		}

		Trie trie = new Trie();
		trie.insert(arr[0]);

		int ans=0;
		for(int i=1;i<N;i++) {
			int tmp=trie.search(arr[i]);
			//System.out.println(tmp);
			ans=Math.max(ans, tmp);
			//ans=Math.max(ans,arr[i]^ tmp);
			trie.insert(arr[i]);
		}

		
		System.out.println(ans);
	}
}