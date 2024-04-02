from collections import deque
n=int(input())
k=int(input())
apple=[]
for i in range(k):
    x,y=map(int,input().split())
    apple.append((x,y))
l=int(input())
temp=[]
apple.sort()

for i in range(l):
    x,y=input().split()
    temp.append((int(x),y))
temp.sort()
rotate=deque(temp)
board=[[0]*(n+2) for _ in range(n+2)]
for i in range(n+2):
    for j in range(n+2):
        if j==0 or j==n+1 or i==0 or i==n+1:
            board[i][j]='#'
#print(board)
init=(1,1)
q=deque()
q.append(init)
dx=[0,1,0,-1]
dy=[1,0,-1,0]
dir=0
cnt=1
while q:

    x,y=q[0]
    x,y=x+dx[dir],y+dy[dir]
    if board[x][y]=='#' or (x,y) in q:
        #print(board[x][y])
        print(cnt)
        break

    q.appendleft((x,y))
    if (x,y) in apple:
        apple.remove((x,y))
        #print("AA")
    else:
        q.pop()
        #print("BB")
    if len(rotate)>0 and cnt == rotate[0][0]:
        rot=rotate.popleft()
        if rot[1]=="L":
            dir = (dir-1)%4
        elif rot[1]=="D":
            dir = (dir+1)%4
    #print(q,cnt)
    cnt+=1
