import math

times = 10
for time in range(times):
    a,n = map(int,input().split())
    board1=[-1 for _ in range(100)]
    board2=[-1 for _ in range(100)]
    arr=list(map(int,input().split()))
    for i in range(0,len(arr),2):
        if board1[arr[i]]==-1:
            board1[arr[i]]=arr[i+1]
        else :
            board2[arr[i]]=arr[i+1]


    ans=0
    def dfs(pos):
        global ans
        if pos==-1:
            return
        elif pos==99:
            ans=1
            return
        dfs(board1[pos])
        dfs(board2[pos])

    dfs(board1[0])
    dfs(board2[0])

    print("#",time+1, " ", ans,sep="")