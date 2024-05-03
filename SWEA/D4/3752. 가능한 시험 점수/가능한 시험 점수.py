times = int(input())
for time in range(times):
    n=int(input())
    arr=list(map(int,input().split()))
    ans=[0]
    for i in arr:
        tmp=[]
        for j in ans:
            tmp.append(i+j)
        ans=list(set(ans+tmp))
    print("#",time+1," ",len(ans),sep="")