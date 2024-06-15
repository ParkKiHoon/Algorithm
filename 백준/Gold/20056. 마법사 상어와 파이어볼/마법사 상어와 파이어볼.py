N,M,K=map(int,input().split())
board=[[[]for i in range(N)] for _ in range(N)]
dx=[-1,-1,0,1,1,1,0,-1]
dy=[0,1,1,1,0,-1,-1,-1]
fireballExist=[]
for _ in range(M):
    a,b,c,d,e=map(int,input().split())
    board[a-1][b-1].append((c,d,e))
    if (a-1,b-1) not in fireballExist:
        fireballExist.append((a-1,b-1))

for _ in range(K):
    tmp=[]
    for i in fireballExist:
        while board[i[0]][i[1]]:
            p=board[i[0]][i[1]].pop()

            tmp.append((i[0],i[1],p[0],p[1],p[2]))
    fireballExist.clear()

    for i in tmp:
        x=(i[0] + dx[i[4]] * i[3]) % N
        y=(i[1] + dy[i[4]] * i[3]) % N
        board[x][y].append((i[2],i[3],i[4]))
        if (x,y) not in fireballExist:
            fireballExist.append((x,y))

    removeList=[]
    for i in fireballExist:
        if len(board[i[0]][i[1]])>1:
            totalWeight=0
            totalSpeed=0
            oddCnt=0
            evenCnt=0
            for j in board[i[0]][i[1]]:
                totalWeight+=j[0]
                totalSpeed+=j[1]
                if j[2]%2==0:
                    evenCnt+=1
                else:
                    oddCnt+=1
            totalWeight=int(totalWeight//5)
            if totalWeight==0:
                board[i[0]][i[1]].clear()
                removeList.append((i[0],i[1]))
                continue
            totalSpeed=int(totalSpeed//len(board[i[0]][i[1]]))
            if oddCnt==0 or evenCnt==0:
                board[i[0]][i[1]] = [(totalWeight, totalSpeed, i) for i in range(0, 8, 2)]
            else:
                board[i[0]][i[1]] = [(totalWeight, totalSpeed, i) for i in range(1, 8, 2)]

    for i in removeList:
        fireballExist.remove(i)

ans=0
for i in range(N):
    for j in range(N):
        if len(board[i][j])>0:
            for k in board[i][j]:
                ans+=k[0]

print(ans)