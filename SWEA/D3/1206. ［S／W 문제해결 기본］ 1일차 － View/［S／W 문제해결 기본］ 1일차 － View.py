times = 10
for time in range(times):
    n=int(input())
    arr=list(map(int,input().split()))

    cnt=0
    for i in range(2,len(arr)-2):
        leftMax=max(arr[i-1],arr[i-2])
        rightMax=max(arr[i+1],arr[i+2])
        tmp=arr[i]-(max(leftMax,rightMax))
        if tmp>0:
            cnt+=tmp
    print("#{} {}".format(time+1,cnt))