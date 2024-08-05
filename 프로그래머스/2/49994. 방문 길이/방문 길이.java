import java.io.IOException;
import java.util.HashSet;
class Solution {
    public int solution(String dirs) {
		int x=0;
		int y=0;
		HashSet<String> ans=new HashSet<>();
		for(int i=0; i<dirs.length();i++) {
			char order = dirs.charAt(i);
			if(order=='U') {
				if(y>=5) {
					continue;
				}
				ans.add(x+","+y+","+x+","+(y+1));
				ans.add(x+","+(y+1)+","+x+","+y);
				y++;
			}
			else if(order=='D') {
				if(y<=-5) {
					continue;
				}
				ans.add(x+","+y+","+x+","+(y-1));
				ans.add(x+","+(y-1)+","+x+","+y);
				y--;
			}
			else if(order=='R') {
				if(x>=5) {
					continue;
				}
				ans.add(x+","+y+","+(x+1)+","+y);
				ans.add((x+1)+","+y+","+x+","+y);
				x++;
			}
			else if(order=='L') {
				if(x<=-5) {
					continue;
				}
				ans.add(x+","+y+","+(x-1)+","+y);
				ans.add((x-1)+","+y+","+x+","+y);
				x--;
			}
		}
		return ans.size()/2;
    }
}