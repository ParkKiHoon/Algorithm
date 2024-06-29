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
	    		int N=scanner.nextInt();
	    		int M=scanner.nextInt();
	    		int sum=0;
	    		int[][] arr=new int[N][N];
	    		for(int i=0;i<N;i++) {
	    			for(int j=0;j<N;j++) {
	    				arr[i][j]=scanner.nextInt();
	    			}
	    		}
	    		
	    		int[] dx= {0,0,1,-1};
	    		int[] dy= {1,-1,0,0};
	    		for(int x=0;x<N;x++) {
	    			for(int y=0;y<N;y++) {
	    				int tmp=arr[x][y];
	    				for(int m=1;m<M;m++) {
	    					for(int d=0;d<4;d++) {
	    						int nx=x+dx[d]*m;
	    						int ny=y+dy[d]*m;
	    						if(nx>=0 && nx<N && ny>=0 && ny<N) {
	    							tmp+=arr[nx][ny];
	    						}
	    					}
	    				}
	    				if(tmp>sum) {
	    					sum=tmp;
	    				}
	    			}
	    		}
	    		
	    		int[] dx2= {-1,1,-1,1};
	    		int[] dy2= {-1,1,1,-1};
	    		for(int x=0;x<N;x++) {
	    			for(int y=0;y<N;y++) {
	    				int tmp=arr[x][y];
	    				for(int m=1;m<M;m++) {
	    					for(int d=0;d<4;d++) {
	    						int nx=x+dx2[d]*m;
	    						int ny=y+dy2[d]*m;
	    						if(nx>=0 && nx<N && ny>=0 && ny<N) {
	    							tmp+=arr[nx][ny];
	    						}
	    					}
	    				}
	    				if(tmp>sum) {
	    					sum=tmp;
	    				}
	    			}
	    		}
	    		System.out.printf("#%d %d\n",tc,sum);
	    	}
	    }
}