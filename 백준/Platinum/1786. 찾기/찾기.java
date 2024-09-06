import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    // 실패함수(Pi 배열) 생성
    public static int[] getPi(String p) {
        int j=0;
        int[] pi=new int[p.length()];
    	
        for(int i=1;i<p.length();i++) {
        	while(j>0 && p.charAt(i)!=p.charAt(j)) {
        		j=pi[j-1];
        	}
        	if(p.charAt(i)==p.charAt(j)) {
        		pi[i]=++j;
        	}
        }
    	
    	
        return pi;
        

    }

    // KMP 알고리즘으로 패턴을 찾음
    public static List<Integer> kmp(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int[] pi = getPi(p);
        int n = s.length();
        int m = p.length();
        int j = 0;

        for(int i=0;i<n;i++) {
        	while(j>0 && s.charAt(i)!=p.charAt(j)) {
        		j=pi[j-1];
        	}
        	if(s.charAt(i)==p.charAt(j)) {
        		if(j==m-1) {
        			ans.add(i-m+1);
        			j=pi[j];
        		}else {
        			j++;
        		}
        	}
        }
        
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine(); // 전체 문자열
        String p = scanner.nextLine(); // 찾을 패턴 문자열

        List<Integer> matched = kmp(s, p);
        System.out.println(matched.size()); // 매칭된 횟수 출력

        for (int idx : matched) {
            System.out.print((idx + 1) + " "); // 1-based index로 출력
        }

        scanner.close();
    }
}