import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	private static int N;
	private static int R;
	private static boolean[] isSelected;
	private static int[] numbers;
	
	public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] str=in.readLine().split(" ");
        N=Integer.parseInt(str[0]);
        R=Integer.parseInt(str[1]);
		numbers=new int[R];
		isSelected=new boolean[N+1];
		permutation(0);
	}

	private static void permutation(int cnt) {
		//기저부분
		if(cnt==R) {
			for (int n : numbers) {
				System.out.print(n+" ");
			}
			System.out.println();

			return;
		}
		
		//유도부분
		for(int i=1; i<=N; i++) {
			if (isSelected[i]) {
				continue;
			}
			numbers[cnt]=i;
			isSelected[i]=true;
			permutation(cnt+1);
			isSelected[i]=false;
		}
	}
}