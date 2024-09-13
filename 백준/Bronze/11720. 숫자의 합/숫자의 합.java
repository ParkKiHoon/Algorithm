import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String s = sc.next();
		char input[] = s.toCharArray();
		
		int sum = 0;

		for (int i = 0; i < s.length(); i++) {
			sum +=  (input[i] - '0');
		}
		System.out.println(sum);
	}
}