dic={}
board=[[0 for _ in range(4)] for _ in range(4)]
dir={1:[-1,0], 2:[-1,-1], 3:[0,-1], 4:[1,-1], 5:[1,0], 6:[1,1], 7:[0,1], 8:[-1,1]}
dead=[]
shark=0
#번호 = (x,y,dir)
for i in range(4):
    a1,a2,b1,b2,c1,c2,d1,d2=map(int,input().split())
    dic[a1]=(i,0,a2)
    dic[b1]=(i,1,b2)
    dic[c1]=(i,2,c2)
    dic[d1]=(i,3,d2)
    if i==0:
        shark=a1
        dead.append(shark)

for i in dic:
    x,y,trash=dic[i]
    board[x][y]=i
def move_fish():
    #물고기 이동, 죽었거나 or 상어인경우 패스
    for i in range(1,17):
        if i in dead or i==shark:
            continue
        x,y,z=dic[i]
        cnt=0

        while cnt!=8:
            dx,dy=x+dir[z][0],y+dir[z][1]
            if 0<=dx<4 and 0<=dy<4 and board[dx][dy]!=shark:
                next=board[dx][dy]
                tmp1,tmp2,tmp3=dic[next]
                dic[next]=(x,y,tmp3)
                dic[i]=(tmp1,tmp2,z)
                board[x][y]=next
                board[dx][dy]=i
                break
            z=(z%8)+1
            cnt+=1

ans=0
def dfs(cnt):
    global board
    global ans
    global dic

    ans=max(ans,cnt)
    board_copy=[arr[:] for arr in board]
    dic_copy=dic.copy()
    move_fish()
    for i in [shark]:
        x, y, z = dic[i]
        for mul in range(1, 4):
            dx, dy = x + (dir[z][0]*mul), y + (dir[z][1]*mul)
            if 0 <= dx < 4 and 0 <= dy < 4 and board[dx][dy] not in dead:
                next = board[dx][dy]
                tmp1, tmp2, tmp3 = dic[next]
                dic[next] = (x, y, z)
                dic[i] = (tmp1, tmp2, tmp3)
                board[x][y] = next
                board[dx][dy] = i
                dead.append(next)

                dfs(cnt+next)

                dead.pop()
                board[dx][dy]=next
                board[x][y]=i
                dic[i]=(x,y,z)
                dic[next]=(tmp1, tmp2, tmp3)
    dic=dic_copy.copy()
    board = [arr[:] for arr in board_copy]

#상어 이동
dfs(dead[0])
print(ans)