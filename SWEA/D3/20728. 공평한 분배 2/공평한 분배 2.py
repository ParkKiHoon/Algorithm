times=int(input())
for time in range(times):
    n,k=map(int,input().split())
    arr=list(map(int,input().split()))
    arr.sort()
    maxval=99999999999
    for i in range(0,n):
        if i+k-1>=n:
            break
        maxval=min(maxval,arr[i+k-1]-arr[i])
    print("#",time+1," ",maxval,sep="")