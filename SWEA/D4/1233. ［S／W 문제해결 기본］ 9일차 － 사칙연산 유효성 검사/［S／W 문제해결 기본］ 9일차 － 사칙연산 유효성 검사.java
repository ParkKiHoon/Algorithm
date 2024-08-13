import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution {

	public static void main(String[] args) throws IOException {
		class BinarySearchTree<T> {
			private Object[] nodes;
			private final int SIZE;
			private int lastIndex;
			private int signal=0;
			public int error=0;
			public BinarySearchTree(int size) {
				SIZE = size;
				nodes = new Object[size + 1];
			}

			public boolean isEmpty() {
				return lastIndex == 0;
			}

			public boolean isFull() {
				return lastIndex == SIZE;
			}

			public void add(T e) {
				if (isFull()) {
					return;
				}
				nodes[++lastIndex] = e;
			}
			
			public void dfsByPostOrder() {
				dfsByPostOrder(1);
			}
			
			public void dfsByPostOrder(int cnt) {
				if(cnt*2<=lastIndex) {
					dfsByPostOrder(cnt*2);
				}
				if(Character.isDigit((char)nodes[cnt])) {
					if(signal==1) {
						error=1;
						return;
					}
					signal=1;
				}else {
					if(signal==0) {
						error=1;
						return;
					}
					signal=0;
				}
				if(cnt*2+1<=lastIndex) {
					dfsByPostOrder(cnt*2+1);
				}
				
			}
		}
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T;
		T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");

			int N = Integer.parseInt(in.readLine());


			BinarySearchTree<Character> tree = new BinarySearchTree<>(N);
			for (int i = 0; i < N; i++) {
				String[] split = in.readLine().split(" ");
				tree.add(split[1].charAt(0));

				if (split.length == 2) {
					
				} else if (split.length == 3) {

				} else if (split.length == 4) {

				}
			}

			tree.dfsByPostOrder();
			if(N%2==0 || tree.error==1) {
				sb.append(0);
			}
			else {
				sb.append(1);
			}
			sb.append('\n');

		}

		System.out.println(sb);
	}
}