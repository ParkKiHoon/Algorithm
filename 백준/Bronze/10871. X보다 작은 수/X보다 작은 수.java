import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int X = sc.nextInt();
		int input[] = new int[N];
		
		for(int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		
		for(int i = 0; i < N; i++) {
			if(input[i] < X) {
				System.out.print(input[i] + " ");
			}
		}
	}

}