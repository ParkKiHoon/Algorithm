N,M=map(int,input().split(" "))
board=[input() for _ in range(N)]
visited=[]
visited2=[[0]*M for _ in range(N)]
#print(visited)
#print(board)
dx = [0,0,1,-1]
dy = [1,-1,0,0]
rx,ry,bx,by=0,0,0,0
for i in range(N):
    for j in range(M):
        if board[i][j]=="R":
            rx,ry=i,j
        elif board[i][j]=="B":
            bx,by=i,j

from collections import deque
init=(rx,ry,bx,by,1)
q=deque()
q.append(init)

def move(x,y,dx,dy):
    cnt=0
    while board[x+dx][y+dy]!="#" and board[x+dx][y+dy]!="O":
        x+=dx
        y+=dy
        cnt+=1
    return x,y,cnt


ans=-1
while q and ans==-1:
    rx,ry,bx,by,dep=q.popleft()
    if dep>10:
        break
    #print(bx,by,rx,ry,dep)
    for i in range(4):
        next_rx, next_ry, cnt_r = move(rx, ry, dx[i], dy[i])
        next_bx, next_by, cnt_b = move(bx, by, dx[i], dy[i])
        #print(next_bx,next_by,next_rx,next_ry)
        if board[next_bx+dx[i]][next_by+dy[i]]=='O':
            continue

        if next_rx==next_bx and next_ry==next_by:
                if cnt_r>cnt_b:
                    next_rx= next_bx - dx[i]
                    next_ry= next_by - dy[i]
                else:
                    next_bx = next_rx - dx[i]
                    next_by = next_ry - dy[i]

        else:
            if board[next_rx+dx[i]][next_ry+dy[i]]=='O':

                ans=dep
                break

        if (next_rx,next_ry,next_bx,next_by) in visited :
            pass
        else:
            q.append((next_rx,next_ry,next_bx,next_by,dep+1))
            visited.append((next_rx,next_ry,next_bx,next_by))



print(ans)
