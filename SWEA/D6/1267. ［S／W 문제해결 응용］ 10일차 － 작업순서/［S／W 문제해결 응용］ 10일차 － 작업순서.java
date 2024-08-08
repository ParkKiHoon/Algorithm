import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Solution {
	
	static int V;
	static int E;
	static ArrayList<Integer>[] graphIn;
	static ArrayList<Integer>[] graphOut;
	static ArrayList<Integer> ans;
	static void dfs(int start) {
		Stack<Integer> stk=new Stack<>();
		for (int node  : graphIn[start]) {
			stk.add(node);
		}
		while(!stk.isEmpty()) {
			int p=stk.pop();
			for(int delIndex=0; delIndex<graphOut[p].size(); delIndex++) {
				if(graphOut[p].get(delIndex)==start) {
					graphOut[p].remove(delIndex);
					if(graphOut[p].size()==0) {
						ans.add(p);
					}
					break;
				}
			}
			if(graphOut[p].size()==0) {
				for (int node : graphIn[p]) {
					dfs(p);
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T;
		T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");

			// 여러분의 알고리즘 코드 작성하기
			String[] split= in.readLine().split(" ");
			V=Integer.parseInt(split[0]);
			E=Integer.parseInt(split[1]);
			graphIn= new ArrayList[V+1];
			graphOut= new ArrayList[V+1];
			ans=new ArrayList<>();
			for(int i=1;i<=V;i++) {
				graphIn[i]=new ArrayList<Integer>();
				graphOut[i]=new ArrayList<Integer>();
			}

			
			String[] inputArr=in.readLine().split(" ");
			for(int i=0; i<inputArr.length;i=i+2) {
				int a=Integer.parseInt(inputArr[i]);
				int b=Integer.parseInt(inputArr[i+1]);
				graphIn[a].add(b);
				graphOut[b].add(a);
			}
			
			ArrayList<Integer> startPoints= new ArrayList<>();
			for(int i=1;i<=V;i++) {
				if (graphOut[i].size()==0) {
					startPoints.add(i);
				}
			}
			
			for (int start : startPoints) {
				ans.add(start);
				dfs(start);
			}
			for(int a:ans) {
				sb.append(a+" ");
			}
			sb.append('\n');
		}

		System.out.println(sb);
	}
}