times = int(input())
for time in range(times):
    n,b=map(int,input().split())
    arr=list(map(int,input().split()))
    ans=[0]
    for i in arr:
        tmp=[]
        for j in ans:
            tmp.append(j+i)
        ans=list(set(ans+tmp))
    ans.sort()
    for i in ans:
        if i>=b:
            print("#{} {}".format(time + 1, i-b))
            break