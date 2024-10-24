import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Main {

	
	static public class Node{
		
		HashMap<Character,Node> child;
		boolean isEnd;
		
		public Node() {
			child=new HashMap<>();
			isEnd=false;
		}
		
	}

	
	
	static public class Trie{
		
		Node root;
		
		public Trie() {
			root=new Node();
		}
		
		public boolean insert(String str) {
			Node node=this.root;
			
			for(int i=0;i<str.length();i++) {
				char ch=str.charAt(i);
				
				if(i==str.length()-1 && node.child.containsKey(ch)) {
					return false;
				}
				if(node.isEnd==true) {
					return false;
				}
				
				if(node.child.containsKey(ch)) {
					node=node.child.get(ch);
				}else {
					node.child.put(ch, new Node());
					node=node.child.get(ch);
				}
			}
			
			node.isEnd=true;
			
			return true;
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int times=Integer.parseInt(in.readLine());
		for(int time=0;time<times;time++) {
			int N=Integer.parseInt(in.readLine());
			
			Trie trie=new Trie();
			
			int sig=0;
			ArrayList<String> arr=new ArrayList<>();
			for(int i=0;i<N;i++) {
				String str=in.readLine();
				arr.add(str);
			}
			Collections.sort(arr);
			//System.out.println(arr);
			for(String str:arr) {
				
				if(!trie.insert(str)) {
					sig=1;break;
				}
			}
			System.out.println(sig==1?"NO":"YES");
			
		}
	}
}