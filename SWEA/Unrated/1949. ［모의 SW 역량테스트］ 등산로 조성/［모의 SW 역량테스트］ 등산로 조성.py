T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    n,k = map(int,input().split())
    board = [list(map(int,input().split())) for _ in range(n)]
    peaks = []
    max_peak = max(map(max,board))
    for i in range(n):
        for j in range(n):
            if board[i][j]==max_peak:
                peaks.append([i,j])



    answer=[0]
    dx=[0,0,1,-1]
    dy=[1,-1,0,0]
    def dfs(x,y,cnt):
        answer[0]=max(answer[0],cnt)

        for i in range(4):
            cx=x+dx[i]
            cy=y+dy[i]
            if 0<=cx<n and 0<=cy<n and board[cx][cy]<board[x][y] and visited[cx][cy]==0:
                visited[cx][cy]=1
                dfs(cx,cy,cnt+1)
                visited[cx][cy]=0


    for i in range(n):
        for j in range(n):
            for deep in range(k):
                deep+=1
                if board[i][j]-deep>=0:
                    board[i][j]-=deep
                    for peak in peaks:
                        visited=[[0 for _ in range(n)] for _ in range(n)]
                        visited[peak[0]][peak[1]]=1
                        dfs(peak[0],peak[1],0)
                    board[i][j]+=deep
    print("#",test_case," ",answer[0]+1,sep="")