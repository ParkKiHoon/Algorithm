import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int ans=0;
		HashMap<Integer,Integer> map = new HashMap<>();
		int N = Integer.parseInt(in.readLine());
		int[] arr = new int[N];
		String[] split = in.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			int tmp=Integer.parseInt(split[i]);
			arr[i]=tmp;
			if(map.containsKey(tmp)) {
				map.replace(tmp, map.get(tmp)+1);
			}
			else {
				map.put(tmp, 1);
			}
		}
		
		
		for(int i=0;i<N;i++) {
			int cur=arr[i];
			map.replace(cur,map.get(cur)-1);
			for(int j=0;j<N;j++) {
				if(i==j) {
					continue;
				}
				
				int first=arr[j];
				int second=cur-first;
				if(map.containsKey(second)) {
					map.replace(first, map.get(first)-1);
					map.replace(second, map.get(second)-1);
					if(map.get(first)>=0 && map.get(second)>=0) {
						ans++;
						map.replace(first, map.get(first)+1);
						map.replace(second, map.get(second)+1);
						break;
					}
					
					map.replace(first, map.get(first)+1);
					map.replace(second, map.get(second)+1);
				}else {
					continue;
				}
			}
			map.replace(cur,map.get(cur)+1);
		}
		

		System.out.println(ans);
	}
}