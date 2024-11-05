import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Main {
    static long[] DP = new long[63]; // 1의 개수 누적합 저장 배열

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        int N=Integer.parseInt(in.readLine());
        int[] A=new int[N];
        int[] B=new int[N];
        int[] C=new int[N];
        int[] D=new int[N];
        for(int i=0;i<N;i++) {
        	String[] split=in.readLine().split(" ");
        	A[i]=Integer.parseInt(split[0]);
        	B[i]=Integer.parseInt(split[1]);
        	C[i]=Integer.parseInt(split[2]);
        	D[i]=Integer.parseInt(split[3]);
        }
        
        long[] AB=new long[N*N];
        int ind=0;
        for(int i=0;i<N;i++) {
        	for(int j=0;j<N;j++) {
        		AB[ind++]=A[i]+B[j];
        	}
        }
        
        long[] CD=new long[N*N];
        ind=0;
        for(int i=0;i<N;i++) {
        	for(int j=0;j<N;j++) {
        		CD[ind++]=C[i]+D[j];
        	}
        }
        
        Arrays.sort(AB);
        Arrays.sort(CD);
        
        long ans=0;
        for(long lo:AB) {
        	long key=-lo;
        	int start=0;
        	int end=AB.length-1;
        	while(start<=end) {
        		int mid=(end+start)/2;
        		if(CD[mid]>=key) {
        			end=mid-1;
        		}else {
        			start=mid+1;
        		}
        	}
        	
        	int start2=0;
        	int end2=AB.length-1;
        	while(start2<=end2) {
        		int mid2=(end2+start2)/2;
        		if(CD[mid2]>key) {
        			end2=mid2-1;
        		}else {
        			start2=mid2+1;
        		}
        	}

        	ans+=end2-end;
        	
        }
        System.out.println(ans);
    }
}