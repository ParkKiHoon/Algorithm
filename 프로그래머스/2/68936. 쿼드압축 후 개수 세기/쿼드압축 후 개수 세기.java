class Solution {
    public int[] solution(int[][] arr) {
        int[] answer = {0, 0};
        
        int n = arr.length / 2;
        
        int[][] prev = arr;
        int[][] merge = new int[n][n];
        
        int[] temp = {0, 0, 0};
        
        while(n >= 1) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(prev[i*2][j*2] == prev[i*2][j*2+1]
                      && prev[i*2][j*2] == prev[i*2+1][j*2]
                      && prev[i*2][j*2] == prev[i*2+1][j*2+1]) {
                        merge[i][j] = prev[i*2][j*2];
                    } else {
                        temp[prev[i*2][j*2]]++;
                        temp[prev[i*2][j*2+1]]++;
                        temp[prev[i*2+1][j*2]]++;
                        temp[prev[i*2+1][j*2+1]]++;
                        merge[i][j] = 2;
                    }
                }
            }
            prev = merge;
            n /= 2;
            merge = new int[n][n];
        }
        
        temp[prev[0][0]]++;
        
        answer[0] = temp[0];
        answer[1] = temp[1];
        
        return answer;
    }
}