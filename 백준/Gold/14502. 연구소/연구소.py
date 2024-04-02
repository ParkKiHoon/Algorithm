import copy
from collections import deque
from itertools import combinations

n,m=map(int,input().split())
board=[list(map(int,input().split())) for _ in range(n)]
maxval=[0]
dx=[0,0,1,-1]
dy=[1,-1,0,0]

def bfs(board_copy):
    queue=deque()
    for i in range(n):
        for j in range(m):
            if board[i][j]==2:
                queue.append((i,j))

    while queue:
        x,y=queue.popleft()
        for i in range(4):
            cx=x+dx[i]
            cy=y+dy[i]
            if 0<=cx<n and 0<=cy<m and board_copy[cx][cy]==0:
                board_copy[cx][cy]=2
                queue.append((cx,cy))

    cnt=0
    for i in range(n):
        for j in range(m):
            if board_copy[i][j]==0:
                cnt+=1
    maxval[0]=max(cnt,maxval[0])

arr=[]
for i in range(n):
    for j in range(m):
        if board[i][j] == 0:
            arr.append((i, j))
arr=list(combinations(arr,3))

for i in arr:
    board_copy=copy.deepcopy(board)
    for j in i:
        board_copy[j[0]][j[1]]=1
    bfs(board_copy)

print(maxval[0])