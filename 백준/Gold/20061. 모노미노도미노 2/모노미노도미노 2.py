board=[[0 for _ in range(10)] for _ in range(10)]
n=int(input())
cnt=[0]
def inspect_line(green,blue):
    green_cnt=[]
    for i in green[::-1]:
        if all(list(board[i][j] for j in range(0,4))):
            for j in range(0,4):
                board[i][j]=0
            green_cnt.append(i)
    if len(green_cnt)>0:
        for i in range(green_cnt[0],3,-1):
            for j in range(0,4):
                board[i][j]=board[i-len(green_cnt)][j]

    blue_cnt = []
    for i in blue[::-1]:
        if all(list(board[j][i] for j in range(0,4))):
            for j in range(0,4):
                board[j][i]=0
            blue_cnt.append(i)
    if len(blue_cnt)>0:
        for i in range(blue_cnt[0],3,-1):
            for j in range(0,4):
                board[j][i]=board[j][i-len(blue_cnt)]
    cnt[0]+=(len(green_cnt)+len(blue_cnt))

def inspect_over():
    greenPush=0
    for i in range(0,4):
        if board[5][i]!=0:
            greenPush=1
            break
    for i in range(0,4):
        if board[4][i]!=0:
            greenPush=2
            break
    for i in range(9,3,-1):
        for j in range(0,4):
            board[i][j]=board[i-greenPush][j]

    bluePush=0
    for i in range(0,4):
        if board[i][5]!=0:
            bluePush=1
            break
    for i in range(0,4):
        if board[i][4]!=0:
            bluePush=2
            break
    for i in range(9,3,-1):
        for j in range(0,4):
            board[j][i]=board[j][i-bluePush]

for _ in range(n):
    t,x,y=map(int,input().split())
    ox,oy=x,y
    greenList=[]
    blueList=[]

    #기본블럭
    if t==1:
        while True:
            if x==9:
                greenList.append(x)
                board[x][y]=1
                break
            if board[x+1][y]==1:
                greenList.append(x)
                board[x][y]=1
                break
            x+=1

        x=ox
        while True:
            if y==9:
                blueList.append(y)
                board[x][y]=1
                break
            if board[x][y+1]==1:
                blueList.append(y)
                board[x][y]=1
                break
            y+=1

    #가로블럭
    elif t==2:
        while True:
            if x==9:
                greenList.append(x)
                board[x][y]=1
                board[x][y+1]=1
                break
            if board[x+1][y] or board[x+1][y+1]:
                greenList.append(x)
                board[x][y]=1
                board[x][y+1]=1
                break
            x+=1

        x=ox
        while True:
            if y==8:
                blueList.append(8)
                blueList.append(9)
                board[x][8]=1
                board[x][9]=1
                break
            if board[x][y+2]:
                blueList.append(y)
                blueList.append(y + 1)
                board[x][y]=1
                board[x][y+1]=1
                break
            y+=1

    #세로블럭
    elif t==3:
        while True:
            if x==8:
                greenList.append(8)
                greenList.append(9)
                board[8][y]=1
                board[9][y]=1
                break
            if board[x+2][y]:
                greenList.append(x)
                greenList.append(x + 1)
                board[x][y]=1
                board[x+1][y]=1
                break
            x+=1

        x=ox
        while True:
            if y==9:
                blueList.append(y)
                board[x][y]=1
                board[x+1][y]=1
                break
            if board[x][y+1] or board[x+1][y+1]:
                blueList.append(y)
                board[x][y]=1
                board[x+1][y]=1
                break
            y+=1

    inspect_line(greenList,blueList)
    inspect_over()

now=0
for i in range(6,10):
    for j in range(0,4):
        if board[i][j]>0:
            now+=1
for i in range(6,10):
    for j in range(0,4):
        if board[j][i]>0:
            now+=1
print(cnt[0])
print(now)
