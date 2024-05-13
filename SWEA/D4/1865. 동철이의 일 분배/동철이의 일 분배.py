times = int(input())
for time in range(times):
    N=int(input())
    arr=[list(map(int,input().split())) for _ in range(N)]
    ans=0


    def dfs(n,list,total):
        global ans

        if total<=ans:
            return

        if n==N:
            ans=max(ans,total)
            return

        for i in range(N):
            if i not in list:
                list.append(i)
                dfs(n+1,list,total*arr[n][i]/100)
                list.pop()

    dfs(0,[],1)
    print("#{} {:.6f}".format(time+1,ans*100))