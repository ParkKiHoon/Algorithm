r, c, t = map(int,input().split())
board=[]
for i in range(r):
    board.append(list(map(int,input().split())))

air=[]
for i in range(r):
    if board[i][0]==-1:
        air.append(i)



dx=[0,0,1,-1]
dy=[1,-1,0,0]

for times in range(t):
    tmp = [[0 for _ in range(c)] for _ in range(r)]
    for i in range(r):
        for j in range(c):
            if board[i][j]>0:
                cnt=0
                for k in range(4):
                        y=i+dy[k]
                        x=j+dx[k]
                        if 0<=y<r and 0<=x<c and board[y][x]!=-1:
                            cnt+=1
                            tmp[y][x] += board[i][j]//5
                board[i][j] = board[i][j] - (board[i][j]//5)*cnt

    for i in range(r):
        for j in range(c):
            board[i][j]+=tmp[i][j]

    for i in range(air[0]-1,0,-1):
        board[i][0]=board[i-1][0]
    for i in range(0,c-1,1):
        board[0][i]=board[0][i+1]
    for i in range(0,air[0],1):
        board[i][c-1]=board[i+1][c-1]
    for i in range(c-2,0,-1):
        board[air[0]][i+1]=board[air[0]][i]
    board[air[0]][1]=0

    for i in range(air[1]+1,r-1,1):
        board[i][0]=board[i+1][0]
    for i in range(0,c-1,1):
        board[r-1][i]=board[r-1][i+1]
    for i in range(r-1,air[1],-1):
        board[i][c-1]=board[i-1][c-1]
    for i in range(c-2,0,-1):
        board[air[1]][i+1]=board[air[1]][i]
    board[air[1]][1]=0

ans=0
for i in range(r):
    for j in range(c):
        if board[i][j]>0:
            ans+=board[i][j]

print(ans)