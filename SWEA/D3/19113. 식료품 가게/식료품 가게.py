times = int(input())
from collections import deque
for time in range(times):
    n=int(input())
    arr=deque(list(map(int,input().split())))
    ans=[]
    while True:
        if len(arr)==0:
            break
        for i in range(len(arr)):
            if arr[i]*3==arr[0]*4:
                del arr[i]
                ans.append(arr[0])
                arr.popleft()
                break
    print("#",time+1,sep="",end="")
    for i in ans:
        print(" ",i,sep="",end="")
    print()