/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
		public static int[][] rotate(int[][] arr){
			int[][] result = new int[arr.length][arr.length];
					
			for(int i=0; i<arr.length;i++) {
				for(int j=0;j<arr.length;j++) {
					result[i][j]=arr[arr.length-j-1][i];
				}
			}
			return result;
		}
		
	    public static void main(String[] args) {
	    	Scanner scanner=new Scanner(System.in);
	    	int testCase=0;
	    	testCase=scanner.nextInt();
	    	for(int tc=1; tc<=testCase; tc++)
	    	{
	    		int N=scanner.nextInt();
	    		int[][] arr=new int[N][N];
	    		for(int i=0;i<N;i++) {
	    			for(int j=0;j<N;j++) {
	    				arr[i][j]=scanner.nextInt();
	    			}
	    		}
	    		
	    		int[][] degree90=rotate(arr);
	    		int[][] degree180=rotate(degree90);
	    		int[][] degree270=rotate(degree180);
	    		
	    		System.out.printf("#%d\n",tc);
	    		for(int i=0;i<N;i++) {
	    			for(int j=0;j<N;j++) {
	    				System.out.print(degree90[i][j]);
	    			}
	    			System.out.print(" ");
	    			for(int j=0;j<N;j++) {
	    				System.out.print(degree180[i][j]);
	    			}
	    			System.out.print(" ");
	    			for(int j=0;j<N;j++) {
	    				System.out.print(degree270[i][j]);
	    			}
	    			System.out.println();
	    		}
	    	}
	    }
}