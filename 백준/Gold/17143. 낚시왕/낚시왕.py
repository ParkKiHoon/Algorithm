import copy

r,c,m = map(int,input().split())
board = [[0 for _ in range(c)] for _ in range(r)]
ans=[0]
dx=[-1,1,0,0]
dy=[0,0,1,-1]

for i in range(m):
    v1,v2,v3,v4,v5=map(int,input().split())
    board[v1-1][v2-1]=(v3,v4-1,v5)

def fishing(pos):
    for i in range(r):
        if board[i][pos]!=0:
            ans[0]+=board[i][pos][2]
            board[i][pos]=0
            break

def move():
    tmp = [[0 for _ in range(c)] for _ in range(r)]
    for i in range(r):
        for j in range(c):
            if board[i][j]!=0:
                x,y = i, j
                s,d,z=board[i][j]
                cnt=s

                while cnt>0:
                    nx = x + dx[d]
                    ny = y + dy[d]
                    if nx<0 or nx>= r or ny<0 or ny>=c:
                        if d==0 or d==2:
                            d+=1
                        else:
                            d-=1
                        continue
                    else:
                        x, y = nx, ny
                        cnt-=1
                if tmp[x][y]:
                    if tmp[x][y][2]<z:
                        tmp[x][y]=(s,d,z)
                else:
                    tmp[x][y] = (s, d, z)
    for i in range(r):
        for j in range(c):
            board[i][j]=tmp[i][j]

for i in range(0,c):
    fishing(i)
    move()
print(ans[0])