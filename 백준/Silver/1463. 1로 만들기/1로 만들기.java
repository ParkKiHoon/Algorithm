import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(in.readLine());
		int[] arr=new int[1000001];
		arr[0]=0;
		arr[1]=0;
		for(int i=2;i<1000001;i++){
			if(i%2==0 && i%3==0) {
				arr[i]=Math.min(Math.min(arr[i-1], arr[i/2]), arr[i/3])+1;
			}else if(i%2==0 && i%3!=0) {
				arr[i]=Math.min(arr[i-1], arr[i/2])+1;
			}else if(i%2!=0 && i%3==0) {
				arr[i]=Math.min(arr[i-1], arr[i/3])+1;
			}else {
				arr[i]=arr[i-1]+1;
			}
		}
		
		System.out.println(arr[N]);
	}

}