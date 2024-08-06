import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	private static int N;
	private static int R;
	private static int[] numbers;
	
	public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] str=in.readLine().split(" ");
        N=Integer.parseInt(str[0]);
        R=Integer.parseInt(str[1]);
		numbers=new int[R];
		permutation(0,0);
	}

	private static void permutation(int cnt,int start) {
		//기저부분
		if(cnt==R) {
			for (int n : numbers) {
				System.out.print(n+1+" ");
			}
			System.out.println();

			return;
		}
		
		//유도부분
		for(int i=start; i<N; i++) {
			numbers[cnt]=i;
			permutation(cnt+1,i+1);
		}
	}
}