import copy
from collections import deque
times = int(input())
for time in range(times):
    n=int(input())
    board=[]
    for i in range(n):
        board.append(list(map(int,input().split())))

    max_cnt=0
    max_arr=[]
    dx=[0,0,1,-1]
    dy=[1,-1,0,0]
    def bfs(x,y):
        queue=deque()
        queue.append([x,y])
        cnt=0
        while queue:
            cnt+=1
            qx,qy=queue.popleft()
            for i in range(4):
                cx = qx + dx[i]
                cy = qy + dy[i]
                if 0 <= cx < n and 0 <= cy < n and board[cx][cy] == board[qx][qy] + 1:
                    queue.append([cx,cy])

        return cnt



    for i in range(n):
        for j in range(n):
            cnt=bfs(i,j)
            if cnt>max_cnt:
                max_arr.clear()
                max_cnt=cnt
                max_arr.append(board[i][j])
            elif cnt==max_cnt:
                max_arr.append(board[i][j])

    max_arr.sort()
    print("#", time + 1," ", max_arr[0], " ",max_cnt, sep="")