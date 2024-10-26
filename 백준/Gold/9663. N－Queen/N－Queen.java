import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int n=Integer.parseInt(in.readLine());
		
        board=new int[n];
        ans=0;
        dfs(0,n);
        System.out.println(ans);
	}

    static int[] board;
    static int ans;
    
    public static void dfs(int d, int depth){
        if(d==depth){
            ans++;
            return;
        }
        
        for(int i=0;i<board.length;i++){
            board[d]=i;
            if(valid(d)){
                dfs(d+1,depth);
            }
        }
    }
    
    public static boolean valid(int d){
        for(int i=0;i<d;i++){
            if(board[i]==board[d]){
                return false;
            }
            if(Math.abs(board[i]-board[d])==Math.abs(i-d)){
                return false;
            }
        }
        return true;
    }
}