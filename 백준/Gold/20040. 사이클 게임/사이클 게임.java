import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

	static int[] parent;
	static int find(int x) {
		if(parent[x]==x) {
			return x;
		}else {
			return parent[x]=find(parent[x]);
		}
		
	}
	
	static boolean union(int p1,int p2) {
		p1=find(p1);
		p2=find(p2);
		if(p1==p2) return false;
		if(p1<p2) parent[p2]=p1;
		else parent[p1]=p2;
		return true;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] split=in.readLine().split(" ");
		int N=Integer.parseInt(split[0]);
		int M=Integer.parseInt(split[1]);
		
		parent=new int[N];
		for(int i=0;i<N;i++) {
			parent[i]=i;
		}
		
		int sig=-1;
		for(int i=0;i<M;i++) {
			split=in.readLine().split(" ");
			int A=Integer.parseInt(split[0]);
			int B=Integer.parseInt(split[1]);
		
			if(!union(A,B)) {
				sig=i;
				break;
			}
		}
		if(sig==-1) {
			System.out.println(0);
		}else {
			System.out.println(sig+1);
		}
	}
}