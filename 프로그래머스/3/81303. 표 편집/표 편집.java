import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;
class Solution {
    public String solution(int n, int k, String[] cmd) {
		int[] body = new int[n];
		int[] head = new int[n];
		int[] tail = new int[n];
		for (int i = 0; i < n; i++) {
			body[i] = i;
			head[i] = i - 1;
			tail[i] = i + 1;
		}
		head[0] = -2;
		tail[n - 1] = -3;

		Stack<Integer> delRecord = new Stack<>();
		for (String str : cmd) {
			if (str.charAt(0) == 'U') {
				int upCnt = Integer.parseInt(str.split(" ")[1]);

				for (int i = 0; i < upCnt; i++) {
					if(head[k]==-2) {
						break;
					}
					k = head[k];
				}

			}
			if (str.charAt(0) == 'D') {
				int downCnt = Integer.parseInt(str.split(" ")[1]);
				
				for (int i = 0; i < downCnt; i++) {
					if(tail[k]==-3) {
						break;
					}
					k = tail[k];
				}

			}
			if (str.charAt(0) == 'C') {
				body[k] = -1;
				if (k + 1 < n && tail[k]!=-3) {
					head[tail[k]] = head[k];
				}
				if (k - 1 >= 0 && head[k]!=-2) {
					tail[head[k]] = tail[k];
				}
				delRecord.push(k);
				if (tail[k] == -3) {
					k = head[k];
				} else {
					k=tail[k];
				}

			}
			if (str.charAt(0) == 'Z') {
				if (!delRecord.isEmpty()) {
					int tmp = delRecord.pop();
					int pos = tmp;
					body[pos] = pos;
					if (pos + 1 < n && tail[tmp]!=-3) {
						head[tail[tmp]] = pos;
					}
					if (pos - 1 >= 0 && head[tmp]!=-2) {
						tail[head[tmp]] = pos;
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i : body) {
			if (i > -1) {
				sb.append("O");
			}
			else {
				sb.append("X");
			}
		}
		return sb.toString();
    }
}