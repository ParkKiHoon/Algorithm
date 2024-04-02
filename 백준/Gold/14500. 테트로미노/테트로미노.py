import copy

n,m=map(int,input().split())
board=[list(map(int,input().split())) for _ in range(n)]
maxval=[0,max(map(max,board))]

dx=[0,0,1,-1]
dy=[1,-1,0,0]
def dfs(arr,cnt,total):
    #print(visited)
    if (total+maxval[1]*(4-cnt))<= maxval[0]:
        return
    if cnt==4:
        maxval[0]=max(maxval[0],total)
        return
    for i in range(4):
        x,y=arr[0],arr[1]
        x+=dx[i]
        y+=dy[i]
        if x<n and x>=0 and y<m and y>=0 and visited[x][y]==0:
            visited[x][y]=1
            dfs((x,y),cnt+1,total+board[x][y])
            if cnt==2:
                dfs((x-dx[i], y-dy[i]), cnt + 1, total + board[x][y])
            visited[x][y]=0


visited = [[0] * m for _ in range(n)]
for i in range(0,n,1):
    for j in range(0,m,1):
        visited[i][j]=1
        arr=(i,j)
        dfs(arr,1,board[i][j])
        visited[i][j] = 0

print(maxval[0])
