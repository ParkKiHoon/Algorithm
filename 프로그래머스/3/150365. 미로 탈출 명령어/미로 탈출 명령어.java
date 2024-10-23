class Solution {
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer = "";
        
        int dx = r - x;
        int dy = c - y;
        
        int extra = Math.abs(dx) + Math.abs(dy) - k;
        
        if(extra % 2 != 0) {
            return "impossible";
        } else if(extra > 0) {
            return "impossible";
        }
        
        extra = -extra;
        
        // d, l, r, u
        int d = dx > 0 ? dx : 0;
        int l = dy < 0 ? -dy : 0;
        int rr = dy > 0 ? dy : 0;
        int u = dx < 0 ? -dx : 0;
        
        x += d;
        
        if(x < n) {
            int vertical = Math.min(extra/2, n-x);
            d += vertical;
            u += vertical;
            extra -= vertical * 2;
        }
        
        y -= l;
        int rl = 0;
        
        if(extra > 0 && y > 1) {
            int horizontal = Math.min(extra/2, y-1);
            l += horizontal;
            rr += horizontal;
            extra -= horizontal * 2;
        }
        rl = extra / 2;
        
        for(int i=0; i<d; i++) answer += "d";
        for(int i=0; i<l; i++) answer += "l";
        for(int i=0; i<rl; i++) answer += "rl";
        for(int i=0; i<rr; i++) answer += "r";
        for(int i=0; i<u; i++) answer += "u";
        
        return answer;
    }
}