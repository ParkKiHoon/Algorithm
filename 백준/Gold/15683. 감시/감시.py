import copy

n,m = map(int,input().split())
board = [list(map(int,input().split())) for _ in range(n)]
cctv=[]
for i in range(n):
    for j in range(m):
        if board[i][j] in [1,2,3,4,5]:
            cctv.append((board[i][j],i,j))

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]
direct = { 1: [[1], [2], [3], [4]] , 2: [[1,3], [2,4]], 3: [[1,2], [2,3], [3,4], [4,1]], 4:[[1,2,3], [2,3,4], [3,4,1], [4,1,2]], 5:[[1,2,3,4]] }
min_val=[2147483647]


def search(arr, dir, x, y):
    for i in dir:
        nx=x
        ny=y
        while 1:
            nx+=dx[i-1]
            ny+=dy[i-1]
            if nx<0 or ny<0 or nx>=n or ny>=m:
                break
            if arr[nx][ny]==6:
                break
            if arr[nx][ny]==0:
                arr[nx][ny]=7


def dfs(depth, board):
    if depth==len(cctv):
        cnt=0
        for i in range(n):
            cnt+=board[i].count(0)
        min_val[0]=min(min_val[0],cnt)
        return

    tmp= copy.deepcopy(board)
    now , x , y =cctv[depth]
    for i in direct[now]:
        search(tmp,i,x,y)
        dfs(depth+1,tmp)
        tmp=copy.deepcopy(board)

dfs(0,board)
print(min_val[0])