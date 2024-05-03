times = int(input())
for time in range(times):
    n=int(input())
    board=[]
    for i in range(n):
        tmp=input()
        tmp2=[]
        for j in tmp:
            tmp2.append(int(j))
        board.append(tmp2)

    dx=[0,0,1,-1]
    dy=[1,-1,0,0]
    dist=[[999999999999 for _ in range(n)]for _ in range(n)]
    dist[0][0]=0
    from collections import deque
    queue=deque()
    queue.append([0,0])
    while queue:
        x,y=queue.popleft()
        for i in range(4):
            cx=x+dx[i]
            cy=y+dy[i]
            if 0<=cx<n and 0<=cy<n:
                if dist[x][y]+board[cx][cy]<dist[cx][cy]:
                    dist[cx][cy]=dist[x][y]+board[cx][cy]
                    queue.append([cx,cy])
    print("#",time+1," ",dist[n-1][n-1],sep="")