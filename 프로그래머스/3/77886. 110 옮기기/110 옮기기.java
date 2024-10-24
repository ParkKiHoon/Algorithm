import java.util.Stack;

class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        
        for(int i=0; i<s.length; i++) {
            int cnt = 0;
            Stack<Character> c = new Stack<>();
            for(int j=0; j<s[i].length(); j++) {
                if(s[i].charAt(j) == '1') {
                    c.add('1');
                    continue;
                }
                if(c.size() < 2 || c.peek() == '0') {
                    c.add('0');
                    continue;
                }
                char temp = c.pop();
                if(c.peek() == '0') {
                    c.add('1');
                    c.add('0');
                    continue;
                }
                c.pop();
                cnt++;
            }
            
            String temp = c.toString().replace(", ", "");
            temp = temp.substring(1, temp.length()-1);
            
            answer[i] = "";

            int idx = temp.indexOf("11");
            if(idx != -1) {
                answer[i] += temp.substring(0, idx);
                temp = temp.substring(idx);
            }
            
            idx = temp.lastIndexOf("0");
            if(idx == -1) {
                answer[i] += "110".repeat(cnt);
                answer[i] += temp;
            } else {
                answer[i] += temp.substring(0, idx + 1);
                answer[i] += "110".repeat(cnt);
                answer[i] += temp.substring(idx + 1);
            }
        }
        
        return answer;
    }
}