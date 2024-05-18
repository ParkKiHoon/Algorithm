times=int(input())
for time in range(times):
    st,n=input().split()
    arr=[int(i) for i in st]
    n=int(n)
    ans=0
    N=len(arr)
    used=[]
    def dfs(cnt):
        global ans
        if cnt==n:
            ans=max(ans,int("".join(map(str,arr))))

        else:
            for i in range(0,N-1):
                for j in range(i+1,N):
                    arr[i],arr[j]=arr[j],arr[i]
                    if (cnt,int("".join(map(str,arr)))) in used:
                        pass
                    else:
                        dfs(cnt+1)
                        used.append((cnt,int("".join(map(str,arr)))))
                    arr[j], arr[i] = arr[i], arr[j]
    dfs(0)
    print("#{} {}".format(time+1,ans))