times = int(input())
for time in range(times):
    n,m=map(int,input().split())
    n1=list(map(str,input().split()))
    m1=list(map(str,input().split()))
    k=int(input())
    arr=[]
    ans=[]
    for i in range(k):
        arr.append(int(input()))
    for i in arr:
        ans.append(n1[(i-1)%n]+m1[(i-1)%m])

    print("#",time+1," "," ".join(ans),sep="")