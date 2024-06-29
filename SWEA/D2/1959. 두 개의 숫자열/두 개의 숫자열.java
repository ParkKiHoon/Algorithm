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
	    public static void main(String[] args) {
	    	Scanner scanner=new Scanner(System.in);
	    	int testCase=0;
	    	testCase=scanner.nextInt();
	    	for(int tc=1; tc<=testCase; tc++)
	    	{
	    		int N =scanner.nextInt();
	    		int M =scanner.nextInt();
	    		
	    		int[] A = new int[N];
	    		int[] B = new int[M];
	    		
	    		for(int i=0; i<N; i++) {
	    			A[i]=scanner.nextInt();
	    		}
	    		for(int i=0; i<M; i++) {
	    			B[i]=scanner.nextInt();
	    		}
	    		
	    		int ans=0;
	    		
	    		if (N<M) {
	    			 for(int i=0; i<M-N+1; i++) {
	    				 int tmp=0;
	    				 for(int j=0; j<N; j++) {
	    					 tmp+=A[j]*B[i+j];
	    				 }
	    				 ans=Math.max(ans, tmp);
	    			 }
	    		}
	    		else if (N==M) {
	    			int tmp=0;
					for(int i=0; i<N; i++) {
						tmp+=A[i]*B[i];
					}
					ans=Math.max(ans, tmp);
	    		}
	    		else {
	    			 for(int i=0; i<N-M+1; i++) {
	    				 int tmp=0;
	    				 for(int j=0; j<M; j++) {
	    					 tmp+=A[i+j]*B[j];
	    				 }
	    				 ans=Math.max(ans, tmp);
	    			 }
	    		}
	    		System.out.printf("#%d %d\n",tc,ans);
	    	}
	    }
}