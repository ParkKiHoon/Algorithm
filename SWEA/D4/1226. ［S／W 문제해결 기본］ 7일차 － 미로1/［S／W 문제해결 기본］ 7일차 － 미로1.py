import copy

times = 10
for time in range(times):
    n=int(input())
    board=[]
    start=[]
    end=[]
    for i in range(16):
        tmp=input()
        arr_tmp=[]
        for j in range(16):
            arr_tmp.append(int(tmp[j]))
            if tmp[j]=="2":
                start.append(i)
                start.append(j)
            elif tmp[j]=="3":
                end.append(i)
                end.append(j)

        board.append(arr_tmp)

    ans=0
    visited=copy.deepcopy(board)
    visited[start[0]][start[1]]=1
    visited[end[0]][end[1]]=0

    dx=[0,0,-1,1]
    dy=[-1,1,0,0]
    def dfs(x,y):
        global end
        global ans
        if x==end[0] and y==end[1]:
            ans=1
            return

        for i in range(4):
            cx=x+dx[i]
            cy=y+dy[i]
            if 0<=cx<16 and 0<=cy<16 and visited[cx][cy]==0:
                visited[cx][cy]=1
                dfs(cx,cy)
                visited[cx][cy]=0
    dfs(start[0],start[1])
    print("#", time + 1, " ", ans, sep="")
