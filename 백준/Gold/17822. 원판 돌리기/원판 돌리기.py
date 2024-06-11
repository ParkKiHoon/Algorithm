from collections import deque
N,M,T=map(int,input().split())
board=[]
dx=[0,0,1,-1]
dy=[1,-1,0,0]
for i in range(N):
    tmp=list(map(int,input().split()))
    board.append(deque(tmp))

def bfs(r,c,val):
    queue=deque()
    queue.append((r,c))
    ans=[]
    while queue:
        x,y=queue.popleft()
        for i in range(4):
            cx=x+dx[i]
            cy=y+dy[i]
            if 0<=cx<N:
                cy=cy%M
                if cy==M:
                    cy=0

                if board[cx][cy]!=0 and board[cx][cy]==val and (cx,cy) not in ans:
                    queue.append((cx,cy))
                    ans.append((cx,cy))
    for i in ans:
        board[i[0]][i[1]]=0
    return len(ans)

for i in range(T):
    x,d,k=map(int,input().split())
    for i in range(N):
        if (i+1)%x==0:
            board[i].rotate(k if d==0 else -k)
    changedNum=0
    for r in range(N):
        for c in range(M):
            changedNum+=bfs(r,c,board[r][c])

    if not changedNum:
        tmp=0
        num=0
        for r in range(N):
            for c in range(M):
                tmp+=board[r][c]
                if board[r][c]>0:
                    num+=1
        if num==0:
            break
        for r in range(N):
            for c in range(M):
                if board[r][c]>0 and board[r][c]>(tmp/num):
                    board[r][c]-=1
                elif board[r][c]>0 and board[r][c]<(tmp/num):
                    board[r][c]+=1

total=0
for r in range(N):
    for c in range(M):
        total+=board[r][c]
print(total)