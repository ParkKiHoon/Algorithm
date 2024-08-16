import java.util.ArrayDeque;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
		ArrayDeque<String> deque1= new ArrayDeque<String>();
		ArrayDeque<String> deque2= new ArrayDeque<String>();
		ArrayDeque<String> deque3= new ArrayDeque<String>();
		for(String str: cards1) {
			deque1.addLast(str);
		}
		for(String str: cards2) {
			deque2.addLast(str);
		}
		for(String str: goal) {
			deque3.addLast(str);
		}
		
		while(!deque3.isEmpty()) {
			
			if(!deque1.isEmpty() && deque3.getFirst().equals(deque1.getFirst())) {
				deque3.removeFirst();
				deque1.removeFirst();
			}
			
			else if(!deque2.isEmpty() && deque3.getFirst().equals(deque2.getFirst())) {
				deque3.removeFirst();
				deque2.removeFirst();
			}
			else {
				break;
			}
		}
		return deque3.isEmpty()? "Yes":"No";
    }
}