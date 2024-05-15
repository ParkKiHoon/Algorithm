times = int(input())
for time in range(times):
    n=int(input())
    board=[list(map(int,input().split())) for _ in range(n)]
    visited=[[0 for _ in range(n)] for _ in range(n)]
    ans=[]
    for i in range(n):
        for j in range(n):
            if board[i][j]!=0 and visited[i][j]==0:
                x=i
                y=j
                while True:
                    if x>=n or board[x][j]==0:
                        break
                    x+=1
                while True:
                    if y>=n or board[i][y]==0:
                        break
                    y+=1
                ans.append([x-i,y-j])
                for i2 in range(i,x):
                    for j2 in range(j,y):
                        visited[i2][j2]=1
    ans.sort(key=lambda x:((x[0]*x[1]),x[0]))
    print("#{} {}".format(time+1,len(ans)),end="")
    for i in range(len(ans)):
        print(" "+str(ans[i][0])+" "+str(ans[i][1]),end="")
    print("")
