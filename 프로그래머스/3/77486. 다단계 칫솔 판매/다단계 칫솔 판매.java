import java.util.Arrays;
import java.util.HashMap;
class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
		for(int i=0;i<amount.length;i++) {
			amount[i]*=100;
		}
		HashMap<String, Integer> mapping = new HashMap<String, Integer>();
		int[] parent = new int[10005];
		int[] depth = new int[10005];

		mapping.put("-", 0);
		int cnt = 0;
		for (int i = 0; i < enroll.length; i++) {
			mapping.put(enroll[i], ++cnt);
		}
		depth[0]=0;
		
		for(int i=0;i<enroll.length;i++) {
			int pid=mapping.get(referral[i]);
			int cid=mapping.get(enroll[i]);
			parent[cid]=pid;
			depth[cid]=depth[pid]+1;
		}
		
		int[] ans=new int[10005];
		for(int i=0;i<amount.length;i++) {
			int cid=mapping.get(seller[i]);
			int cycle=depth[cid];
			for(int j=0;j<=cycle;j++) {
				int tmp=(amount[i]-(int)(amount[i]*0.1));
				ans[cid]+=tmp;
				amount[i]-=tmp;
				cid=parent[cid];
			}
		}
		int[] answer=new int[enroll.length];
		for(int i=0; i<enroll.length;i++) {
			answer[i]=ans[mapping.get(enroll[i])];;
		}
        return answer;
    }
}