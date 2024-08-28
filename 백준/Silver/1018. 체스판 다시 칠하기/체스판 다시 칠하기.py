m,n = map(int,input().split())
board=[]
ans=99999999999999999
for i in range(m):
    tmp=[]
    for inp in input():
        tmp.append(inp)
    board.append(tmp)

def check(x,y):
    global ans
    cnt1=0
    for i in range(8):
        for j in range(8):
            if (i+j)%2==0 and board[x+i][y+j]=='B':
                cnt1+=1
            elif (i+j)%2==1 and board[x+i][y+j]=='W':
                cnt1+=1
    cnt2=0
    for i in range(8):
        for j in range(8):
            if (i+j)%2==0 and board[x+i][y+j]=='W':
                cnt2+=1
            elif (i+j)%2==1 and board[x+i][y+j]=='B':
                cnt2+=1
    ans=min(ans,cnt1,cnt2)

for i in range(0,m-7):
    for j in range(0,n-7):
        check(i,j)
print(ans)
