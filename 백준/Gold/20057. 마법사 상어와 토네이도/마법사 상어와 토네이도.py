N=int(input())
board=[list(map(int,input().split())) for _ in range(N)]

def rotate_2d(list_2d):
    n = len(list_2d)
    m = len(list_2d[0])
    new = [[0] * n for _ in range(m)]
    for i in range(n):
        for j in range(m):
            new[j][n-i-1] = list_2d[i][j]
    return new
dx=[0,1,0,-1]
dy=[-1,0,1,0]
left=[ [0,0,0.02,0,0], [0,0.1,0.07,0.01,0], [0.05,0.00,0,0,0], [0,0.1,0.07,0.01,0], [0,0,0.02,0,0] ]
up=rotate_2d(left)
right=rotate_2d(up)
down=rotate_2d(right)
ratio=[left,down,right,up]

x,y=N//2,N//2
ans=0
def add(x,y,dir):

    global ans
    tmp=board[x][y]
    minus=0
    for i in range(-2,3):
        for j in range(-2,3):
            cx=x+i
            cy=y+j
            if 0<=cx<N and 0<=cy<N:
                move=int(tmp * ratio[dir][i+2][j+2])
                board[cx][cy]+= move
                minus += move
            else:
                move = int(tmp * ratio[dir][i + 2][j + 2])
                ans+=move
                minus += move

    if 0<=x+dx[dir]<N and 0<=y+dy[dir]<N:
        board[x+dx[dir]][y+dy[dir]]+=(tmp-minus)
    else:
        ans+=(tmp-minus)
    board[x][y]=0



cnt=1
change=0
dir=0
while True:
    breakP=0
    for _ in range(cnt):
        x+=dx[dir]
        y+=dy[dir]

        if x<=0 and y<=0:
            add(x,y,dir)
            breakP=1
            break
        else:
            add(x,y,dir)
    if breakP:
        break

    change+=1
    if change==2:
        cnt+=1
        change=0
    dir=(dir+1)%4
print(ans)