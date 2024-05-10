import copy

times = int(input())
for time in range(times):
    n,m=map(int,input().split())
    board=[]
    for i in range(n):
        tmp=input()
        tmp_list=[]
        for j in tmp:
            tmp_list.append(j)
        board.append(tmp_list)

    cnt=0
    for i in range(m):
        if board[0][i]!="W":
            board[0][i]="W"
            cnt+=1
    for i in range(m):
        if board[n-1][i]!="R":
            board[n-1][i]="R"
            cnt+=1
    arr2=[]
    for i in range(1,n-1):
        tmp=[]
        tmp.append(m - board[i].count("W"))
        tmp.append(m - board[i].count("B"))
        tmp.append(m - board[i].count("R"))
        arr2.append(tmp)

    stop=len(arr2)
    ans=99999999999
    def dfs(arr,cnt):
        global ans
        if len(arr)>1 and arr[-1]<arr[-2]:
            return
        if cnt==stop:
            if 1 in arr:
                tmp_min=0
                for i,d in enumerate(arr):
                    tmp_min+=arr2[i][d]
                ans=min(tmp_min,ans)
            return
        for i in range(0,3):
            dfs(arr+[i],cnt+1)

    dfs([],0)


    print("#{} {}".format(time+1,ans+cnt))
