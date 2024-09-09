import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in= new BufferedReader(new InputStreamReader(System.in));
		str1=in.readLine();
		str2=in.readLine();
		dfs(str1,str2);
		System.out.println(ans);
	}
	static String str1;
	static String str2;
	static int ans=0;
	private static void dfs(String str1 , String str2) {
		if(str1.equals(str2)) {
			ans=1;
			return;
		}
		if(str1.length()>str2.length()) {
			return;
		}
		
		StringBuilder sb=new StringBuilder();
		StringBuilder tmp=new StringBuilder();
		sb.append(str2);
		tmp.append(str2);
		if(sb.charAt(sb.length()-1)=='A') {
			tmp.deleteCharAt(tmp.length()-1);
			dfs(str1,tmp.toString());
		}
		if(sb.charAt(0)=='B'){
			sb.deleteCharAt(0);
			sb.reverse();
			dfs(str1,sb.toString());
		}else {
			return;
		}

	}
}