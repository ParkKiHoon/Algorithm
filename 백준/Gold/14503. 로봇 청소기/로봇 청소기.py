n,m=map(int,input().split())
rx,ry,dir=map(int,input().split())
board=[list(map(int,input().split())) for _ in range(n)]

dx=[-1, 0, 1, 0]
dy=[ 0, 1, 0,-1]


cnt=0
while True:
    if board[rx][ry]==0:
        board[rx][ry]=2
        cnt+=1

    isLeft=0
    for i in range(4):
        if 0<=rx+dx[i]<n and 0<=ry+dy[i]<m and board[rx+dx[i]][ry+dy[i]]==0:
            isLeft=1
            break

    if isLeft:
        dir = (dir-1)%4
        if 0 <= rx + dx[dir] < n and 0 <= ry + dy[dir] < m and board[rx + dx[dir]][ry + dy[dir]] == 0:
            rx=rx + dx[dir]
            ry=ry + dy[dir]
    else:
        if 0 <= rx + dx[(dir-2)%4] < n and 0 <= ry + dy[(dir-2)%4] < m:
            if board[rx + dx[(dir-2)%4]][ry + dy[(dir-2)%4]] == 0 or board[rx + dx[(dir-2)%4]][ry + dy[(dir-2)%4]] == 2:
                rx=rx + dx[(dir-2)%4]
                ry=ry + dy[(dir-2)%4]
            else:
                break

print(cnt)