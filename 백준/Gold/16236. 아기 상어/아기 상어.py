from collections import deque
n = int(input())
board = [list(map(int,input().split())) for _ in range(n)]

x,y=0,0
jaws=[2,0]
for i in range(n):
    for j in range(n):
        if board[i][j]==9:
            x,y=i,j

dx=[0,0,1,-1]
dy=[1,-1,0,0]
def bfs(x,y):
    queue=deque()
    queue.append((x,y))
    ans=[]
    visited=[[0 for _ in range(n)] for _ in range(n)]
    visited[x][y]=1
    while queue:
        q=queue.popleft()
        for i in range(4):
            xx=q[0]+dx[i]
            yy=q[1]+dy[i]
            if 0<= xx <n and 0<= yy <n and visited[xx][yy]==0:
                if 0 < board[xx][yy] < jaws[0]:
                    visited[xx][yy]=visited[q[0]][q[1]]+1
                    ans.append((visited[xx][yy]-1, xx, yy))
                    queue.append((xx, yy))
                elif board[xx][yy] ==jaws[0] or board[xx][yy]==0:
                    visited[xx][yy] = visited[q[0]][q[1]] + 1
                    queue.append((xx,yy))
    return ans

val=0

while True:

    res=bfs(x,y)
    if len(res)==0:
        print(val)
        break
    res.sort(key=lambda x:(x[0],x[1],x[2]))
    board[x][y]=0
    x,y=res[0][1],res[0][2]
    val+=res[0][0]
    board[x][y]=0

    jaws[1]+=1
    if jaws[0]==jaws[1]:
        jaws[0]+=1
        jaws[1]=0