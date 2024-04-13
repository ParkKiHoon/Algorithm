T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    n = int(input())
    board = [list(map(int,input().split())) for _ in range(n)]
    wormhole=[[],[],[],[],[],[],[],[],[],[],[]]

    for i in range(n):
        for j in range(n):
            if 6<=board[i][j]<=10:
                wormhole[board[i][j]].append([i,j])


    dx=[-1,1,0,0]
    dy=[0,0,-1,1]
    max_val=0
    #상 하 좌 우
    def change_dir(dir):
        if dir in [0, 2]:
            dir += 1
        elif dir in [1, 3]:
            dir -= 1
        return dir
    def move(x,y,dir):
        cnt=0
        not_move=0
        ix,iy=x,y
        while True:
            cx=x+dx[dir]
            cy=y+dy[dir]

            if 0<=cx<n and 0<=cy<n:
                if board[cx][cy]==-1 or [cx,cy]==[ix,iy] :
                    return cnt

                if 6<=board[cx][cy]<=10:
                    worm = wormhole[board[cx][cy]]

                    if worm[0][0]==cx and worm[0][1]==cy:
                        cx, cy = worm[1][0], worm[1][1]
                        not_move = 0
                    else:
                        cx, cy = worm[0][0], worm[0][1]
                        not_move = 0
                    x,y=cx,cy

                if board[cx][cy]==0:
                    x, y = cx, cy
                    not_move = 0

                elif board[cx][cy]==1:
                    if dir in [0,3]:
                        dir=change_dir(dir)
                        if not_move == 1:
                            return cnt
                        not_move = 1
                        x, y = cx, cy
                    elif dir==1:
                        dir=3
                        x, y = cx, cy
                        not_move = 0
                    elif dir==2:
                        dir=0
                        x, y = cx, cy
                        not_move = 0
                    cnt += 1

                elif board[cx][cy]==2:
                    if dir in [1,3]:
                        dir=change_dir(dir)
                        if not_move == 1:
                            return cnt
                        not_move = 1
                        x, y = cx, cy
                    elif dir==0:
                        dir=3
                        x, y = cx, cy
                        not_move = 0
                    elif dir==2:
                        dir=1
                        x, y = cx, cy
                        not_move = 0
                    cnt += 1

                elif board[cx][cy]==3:
                    if dir in [1,2]:
                        dir=change_dir(dir)
                        if not_move == 1:
                            return cnt
                        x, y = cx, cy
                        not_move = 1
                    elif dir==0:
                        dir=2
                        x, y = cx, cy
                        not_move = 0
                    elif dir==3:
                        dir=1
                        x, y = cx, cy
                        not_move = 0
                    cnt += 1

                elif board[cx][cy]==4:
                    if dir in [0,2]:
                        dir=change_dir(dir)
                        if not_move == 1:
                            return cnt
                        x, y = cx, cy
                        not_move = 1
                    elif dir==1:
                        dir=2
                        x, y = cx, cy
                        not_move = 0
                    elif dir==3:
                        dir=0
                        x, y = cx, cy
                        not_move = 0
                    cnt += 1

                elif board[cx][cy]==5:
                    dir=change_dir(dir)
                    cnt += 1
                    if not_move == 1:
                        return cnt
                    not_move = 1
                    x, y = cx, cy
            else:
                dir=change_dir(dir)
                cnt+=1
                if not_move==1:
                    return cnt
                not_move=1
                x, y = cx, cy

    for i in range(n):
        for j in range(n):
            for k in range(4):
                if board[i][j]==0:
                    max_val = max(move(i, j, k), max_val)
    print("#",test_case," ",max_val,sep="")