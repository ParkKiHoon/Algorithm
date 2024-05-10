import copy

times = int(input())
def find_parent(x):
    if arr[x]==x:
        return x
    else:
        return find_parent(arr[x])

for time in range(times):
    n,m=map(int,input().split())
    arr=[i for i in range(n+1)]
    for i in range(m):
        a,b=map(int,input().split())
        arr[find_parent(a)]=find_parent(b)

    cnt=0
    for i in range(1,n+1):
        if arr[i]==i:
            cnt+=1
    print("#", time + 1, " ", cnt, sep="")