
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
	static int N;
	static int R=3;
	static int[] numbers;
	static int x;
	static int y;
	static int d;
	static int[][] arr;
	static int maxVal;
    private static void comb(int depth,int start) {
        if(depth==R) {
        	//System.out.println(Arrays.toString(numbers));
        	int[][] board=new int[x][y];
        	for(int i=0; i<x;i++) {
        		for(int j=0;j<y;j++) {
        			board[i][j]=arr[i][j];
        		}
        	}
        	int xPos=x;
        	int cnt=0;
        	for(int moveUp=0; moveUp<x;moveUp++) {
	        	//System.out.println("xPos="+(xPos-1));
        		HashSet<String> delSet=new HashSet<>();
	        	for(int num:numbers) {
	        		NEXT_FOR:
	        		for(int dis=0; dis<=d-1;dis++) {
		        		for(int j=-dis;j<=dis;j++) {
		        			for(int i=-dis;i<=0;i++) {
		        				if(Math.abs(i)+Math.abs(j)==dis) {
		        					if(xPos-1+i>=0 && xPos-1+i<x && num+j>=0 && num+j<y) {
		        						if(board[xPos-1+i][num+j]==1) {
		        							//System.out.println("DIS:"+dis+"  X: "+ (xPos-1+i)+"  Y: "+(num+j));	
		        							//board[xPos-1+i][num+j]=0;
		        							delSet.add((xPos-1+i)+","+(num+j));
		        							
		        							break NEXT_FOR;
		        						}
		        					}
		        				}
		        			}
		        		}
	        		}
	        	}
	        	for(String str :delSet) {
	        		board[Integer.parseInt(str.split(",")[0])][Integer.parseInt(str.split(",")[1])]=0;
	        		cnt++;
	        	}
	        	xPos--;
        	}
        	maxVal=Math.max(maxVal, cnt);
        	//System.out.println("ANSWER!!!!!!!!!!!!!!!!!!!!!"+cnt);
        	return;
        }
        
        for(int i=start;i<N;i++) {
        	numbers[depth]=i;
        	comb(depth+1,i+1);
        }
    }
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split=in.readLine().split(" ");
		x=Integer.parseInt(split[0]);
		y=Integer.parseInt(split[1]);
		N=Integer.parseInt(split[1]);
		d=Integer.parseInt(split[2]);
		maxVal=0;
		numbers=new int[R];
		arr=new int[x][y];
		for(int i=0; i<x; i++) {
			String[] tmp=in.readLine().split(" ");
			for(int j=0; j<tmp.length;j++) {
				arr[i][j]=Integer.parseInt(tmp[j]);
			}
		}
		comb(0,0);
		System.out.println(maxVal);
	}

}
