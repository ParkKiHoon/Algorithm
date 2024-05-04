import copy

times = int(input())
for time in range(times):
    n,m=map(int,input().split())
    board=[]
    for i in range(n):
        tmp_arr=[]
        tmp=input()
        for j in range(m):
            tmp_arr.append(tmp[j])
        board.append(tmp_arr)
    endPoint=[]
    for i in range(n):
        for j in range(m):
            if board[i][j]=="@":
                endPoint.append([i,j])
    if len(endPoint)==0:
        print("#", time + 1, " ", "NO", sep="")
        continue
    checkSide=[[-1,0],[0,1],[1,0],[0,-1]]
    end=0
    for i in endPoint:
        x, y = i
        badCount=0
        for j in range(4):
            cx=x+checkSide[j][0]
            cy=y+checkSide[j][1]
            if 0<=cx<n and 0<=cy<m:
                if j==0 or j==2:
                    if board[cx][cy] in ["<",">"]:
                        badCount+=1
                else:
                    if board[cx][cy] in ["^","v"]:
                        badCount+=1
        if badCount==4:
            end=1
            break
    if end==1:
        print("#", time + 1, " ", "NO", sep="")
        continue

    dx=[0,0,-1,1]
    dy=[-1,1,0,0]
    ans=[0]
    visited=[]
    def toStr(val):
        return str(val)
    def work(x,y,direct,memory):
        if toStr(x)+toStr(y)+toStr(direct)+toStr(memory) in visited:
            return
        else:
            visited.append(toStr(x)+toStr(y)+toStr(direct)+toStr(memory))
        if ans[0]==1:
            return
        str=board[x][y]
        if str=="<":
            direct=0
        elif str==">":
            direct = 1
        elif str=="^":
            direct = 2
        elif str=="v":
            direct = 3
        elif str=="_":
            if memory==0:
                direct=1
            else:
                direct=0
        elif str=="|":
            if memory==0:
                direct=3
            else:
                direct=2
        elif str=="?":
            for i in range(4):
                work((x+dx[i])%n,(y+dy[i])%m,i,memory)
        elif str==".":
            pass
        elif str=="@":
            ans[0]=1
            return
        elif str=="+":
            if memory==15:
                memory=0
            else:
                memory+=1
        elif str=="-":
            if memory==0:
                memory=15
            else:
                memory-=1
        elif 0<=int(str)<=9:
            memory=int(str)
        work((x+dx[direct])%n,(y+dy[direct])%m,direct,memory)
    work(0,0,1,0)
    print("#", time + 1, " ", "YES" if ans[0]==1 else "NO", sep="")