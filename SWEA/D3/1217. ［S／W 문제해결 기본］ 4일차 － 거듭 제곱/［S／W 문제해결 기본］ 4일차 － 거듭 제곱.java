import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			int notuse = sc.nextInt();

			int left=sc.nextInt();
			int right=sc.nextInt();
			int init=1;
			for(int i=0; i<right; i++) {
				init*=left;
			}
			System.out.println("#"+test_case+" "+init);
		}
	}
}