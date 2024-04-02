import copy

n,l,r= map(int,input().split())
board = [list(map(int,input().split())) for _ in range(n)]
visited = [[0 for _ in range(n)] for _ in range(n)]
dx=[0,0,1,-1]
dy=[1,-1,0,0]

from collections import deque
def bfs(x,y):
    tmp_list=[(x,y)]
    queue = deque(tmp_list)
    while queue:
        q=queue.popleft()
        for times in range(4):
            tx = q[0] + dx[times]
            ty = q[1] + dy[times]
            if 0 <= tx < n and 0 <= ty < n:
                if l <= abs(board[tx][ty]-board[q[0]][q[1]]) <= r and visited2[tx][ty]==0:
                    queue.append((tx,ty))
                    tmp.append((tx,ty))
                    visited2[tx][ty]=1

def is_stop(arr):
    for i in arr:
        if len(i)>1:
            return 0
    return 1

ans=0
while True:
    visited2=copy.deepcopy(visited)
    arr=[]
    for x in range(n):
        for y in range(n):
            if visited2[x][y]==0:
                visited2[x][y]=1
                tmp=[]
                tmp.append((x,y))
                bfs(x,y)
                arr.append(tmp)
    if is_stop(arr):
        break
    for i in arr:
        if len(i)>1:
            cnt=0
            for j in i:
                cnt+=board[j[0]][j[1]]
            for j in i:
                board[j[0]][j[1]]=cnt//len(i)
    ans+=1
print(ans)