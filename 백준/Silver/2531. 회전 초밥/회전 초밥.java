import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] split=in.readLine().split(" ");
		int N=Integer.parseInt(split[0]);
		int D=Integer.parseInt(split[1]);
		int K=Integer.parseInt(split[2]);
		int C=Integer.parseInt(split[3]);
		
		Deque<Integer> board= new ArrayDeque<Integer>();
		for(int i=0;i<N;i++) {
			int tmp=Integer.parseInt(in.readLine());
			board.offerLast(tmp);
		}
		Deque<Integer> board2= new ArrayDeque<Integer>();
		for(int i:board) {
			board2.offerLast(i);
		}
		for(int i:board) {
			board2.offerLast(i);
		}
		
		Deque<Integer> deque=new ArrayDeque<Integer>();
		HashSet<Integer> set=new HashSet<>();
		int ans=0;
		int[] arr=new int[D+1];
		for(int i=0;i<N*2;i++) {
			int tmp=board2.pollFirst();
			deque.offerLast(tmp);
			set.add(tmp);
			arr[tmp]++;
			int del=-1;
			if(deque.size()>K) {
				del= deque.pollFirst();
				arr[del]--;
				if(arr[del]==0) {
					set.remove(del);
				}
			}
			if(set.contains(C)) {
				ans=Math.max(ans, set.size());
			}else {
				ans=Math.max(ans, set.size()+1);
			}
			
		}
		System.out.println(ans);
	}
}