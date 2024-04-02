n = int(input())
order = [list(map(int,input().split())) for _ in range(n)]
board = [[0 for _ in range(101)] for _ in range(101)]

dx=[1,0,-1,0]
dy=[0,-1,0,1]
def move(x,y,move_order):
    board[y][x]=1
    for i in move_order:
        y=y+dy[i]
        x=x+dx[i]
        board[y][x]=1



for i in order:
    tmp=[i[2]]
    for j in range(i[3]):
        arr_for_add = []
        for k in reversed(tmp):
            arr_for_add.append((k+1)%4)
        tmp=tmp+arr_for_add
    move(i[0],i[1],tmp)


ans=0
for i in range(100):
    for j in range(100):
        if board[i][j]==1 and board[i+1][j]==1 and board[i][j+1]==1 and board[i+1][j+1]==1:
            ans+=1

print(ans)