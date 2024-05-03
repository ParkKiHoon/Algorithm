times = int(input())
for time in range(times):
    n=4
    arr=[]
    for i in range(n):
        arr.append(list(map(str,input().split())))

    dx = [1,-1,0,0]
    dy = [0,0,1,-1]
    ans=[]
    def dfs(x,y,bul,idx):
        global ans
        if idx==7:
            ans.append(bul)
            return
        for i in range(4):
            cx=x+dx[i]
            cy=y+dy[i]
            if 0<=cx<n and 0<=cy<n:
                dfs(cx,cy,bul+arr[cx][cy],idx+1)

    for i in range(4):
        for j in range(4):
            dfs(i,j,"",0)

    print("#",time+1," ",len(set(ans)),sep="")