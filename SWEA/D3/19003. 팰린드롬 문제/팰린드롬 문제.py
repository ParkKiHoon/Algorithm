times = int(input())
for time in range(times):
    n,m=map(int,input().split())
    arr=[]
    for i in range(n):
        arr.append(input())

    left=[]
    middle=[]
    right=[]

    for i in range(len(arr)):
        for j in range(len(arr)):
            cnt=0
            for k in range(m):
                if arr[i][k]!=arr[j][-k-1]:
                    cnt=1
                    break
            if cnt==0:
                if i==j:
                    middle.append(i)
                    break
                else:
                    left.append(i)
                    right.append(j)
                    break
    ans=0
    ans=m*len(left) + (m* 1 if len(middle)>0 else 0)
    print("#",time+1," ",ans,sep="")