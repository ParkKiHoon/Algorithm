import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		PriorityQueue<Integer> min=new PriorityQueue<Integer>(Comparator.reverseOrder());
		PriorityQueue<Integer> max=new PriorityQueue<Integer>();
		
		int N=Integer.parseInt(in.readLine());
		if(N==1) {
			System.out.println(Integer.parseInt(in.readLine()));
		}else if(N==2) {
			int a=Integer.parseInt(in.readLine());
			int b=Integer.parseInt(in.readLine());
			System.out.println(a);
			if(a<b) {
				System.out.println(a);
			}else {
				System.out.println(b);
			}
		}else {
			int a=Integer.parseInt(in.readLine());
			int b=Integer.parseInt(in.readLine());
			if(a<b) {
				min.offer(a);
				max.offer(b);
				System.out.println(min.peek());
				System.out.println(min.peek());
			}else {
				max.offer(a);
				min.offer(b);
				System.out.println(max.peek());
				System.out.println(min.peek());
			}
			for(int i=2;i<N;i++) {
				int num=Integer.parseInt(in.readLine());
				if(num>=min.peek()) {
					max.offer(num);
				}
				else {
					min.offer(num);
				}
				while(max.size()>min.size()) {
					int tmp=max.poll();
					min.offer(tmp);
				}
				while(min.size()-1>max.size()) {
					int tmp=min.poll();
					max.offer(tmp);
				}
				System.out.println(min.peek());
			}
		}
	}
}