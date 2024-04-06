n, m, h = map(int,input().split())
order = [list(map(int,input().split())) for _ in range(m)]
board= [[0 for _ in range(n)] for _ in range(h)]
for i in order:
    board[i[0]-1][i[1]-1]=1

def downable(board):
    for i in range(n):
        num = i
        for j in range(h):
            if board[j][num]==1:
                num+=1
            elif num>0 and board[j][num-1]==1:
                num-=1
        if num!=i:
            return -1
    return 1

ans=[99999999]
def dfs(x,y,cnt):
    if cnt>=ans[0]:
        return
    if downable(board)!=-1:
        ans[0]=min(ans[0],cnt)
    if cnt==3:
        return
    for i in range(x,h):
        for j in range(0,n-1):
            if board[i][j]==0:
                board[i][j]=1
                dfs(i,j+2,cnt+1)
                board[i][j]=0

dfs(0,0,0)
if ans[0]>3:
    print(-1)
else:
    print(ans[0])