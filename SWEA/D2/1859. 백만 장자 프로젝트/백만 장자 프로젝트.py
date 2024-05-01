n=int(input())
for k in range(n):
    items=int(input())
    arr=list(map(int,input().split()))
    max=0
    ans=0
    for i in range(items-1,-1,-1):
        if arr[i]>max:
            max=arr[i]
        if arr[i]<=max:
            ans+=max-arr[i]
    print("#",k+1," ",ans,sep="")