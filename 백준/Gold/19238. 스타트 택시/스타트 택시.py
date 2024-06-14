from collections import deque
import copy
N,M,F=map(int,input().split())
board=[]
board2=[]
for i in range(N):
    tmp=[]
    for j in list(map(int, input().split())):
        tmp.append([j])
    board.append(tmp)
    board2.append(copy.deepcopy(tmp))
visited_copy=[[0 for _ in range(N)] for _ in range(N)]
for i in range(N):
    for j in range(N):
        visited_copy[i][j]=board[i][j][0]
dx=[-1,0,0,1]
dy=[0,-1,1,0]

x,y=map(int,input().split())
x-=1
y-=1

customer=0
# 손님=10~29
# 목적지 = 손님 + 20
for i,k in enumerate([list(map(int,input().split())) for _ in range(M)]):
    board[k[0]-1][k[1]-1].append(i+2)
    board2[k[2]-1][k[3]-1].append(i+2)
    customer+=1

def nearestDest(cx,cy,target):
    visited[cx][cy]=1
    queue=deque()
    queue.append((cx,cy))
    cnt=0
    while queue:
        cnt+=1
        tmp=[]
        while queue:
            tx,ty=queue.popleft()
            for i in range(4):
                bx=tx+dx[i]
                by=ty+dy[i]
                if 0<=bx<N and 0<=by<N and visited[bx][by]==0:
                    visited[bx][by]=1
                    tmp.append((bx,by))
                    if target in board2[bx][by]:
                        return (cnt,bx,by)
        queue=deque(tmp)
    return (-1,-1,-1)

def nearestCust(cx,cy):
    if len(board[cx][cy])>1 and board[cx][cy][1]>1:
        return (0,cx,cy)
    visited[cx][cy]=1
    queue=deque()
    queue.append((cx,cy))
    cnt=0
    find=[]
    while queue:
        cnt+=1
        tmp=[]
        while queue:
            tx,ty=queue.popleft()
            for i in range(4):
                bx=tx+dx[i]
                by=ty+dy[i]
                if 0<=bx<N and 0<=by<N and visited[bx][by]==0:
                    visited[bx][by]=1
                    tmp.append((bx,by))
                    if len(board[bx][by])>1 :
                        find.append((bx,by))
        if len(find)>0:
            find.sort(key=lambda x:(x[0],x[1]))

            return (cnt,find[0][0],find[0][1])
        queue=deque(tmp)
    return (-1,-1,-1)

ans=0
visited=[[0 for _ in range(N)] for _ in range(N)]
for i in range(customer):
    #방문 초기화
    for i in range(N):
        for j in range(N):
            visited[i][j]=visited_copy[i][j]

    #손님 찾기
    c1,c2,c3=nearestCust(x,y)
    x,y=c2,c3
    F-=c1
    if F<0 or c1<0:
        ans=-1
        break
    target=board[x][y][1]
    del board[x][y][1]


    #방문 초기화
    for i in range(N):
        for j in range(N):
            visited[i][j]=visited_copy[i][j]

    #목적지 이동
    d1,d2,d3 = nearestDest(x,y,target)
    x,y=d2,d3
    F-=d1
    if F<0 or d1<0:
        ans=-1
        break
    F+=(2*d1)
    board2[x][y].remove(target)


if ans==-1:
    print(ans)
else:
    print(F)