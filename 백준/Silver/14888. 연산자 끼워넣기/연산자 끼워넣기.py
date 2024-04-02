import math
n=int(input())
arr=list(map(int,input().split()))
order=list(map(int,input().split()))

maxval=[-1000000001]
minval=[1000000001]

def cal(temp,pos,i):
    if i==0:
        return temp+arr[pos]
    elif i==1:
        return temp-arr[pos]
    elif i==2:
        return temp*arr[pos]
    elif i==3:
        return int(temp / arr[pos])

def dfs(pos,temp):
    if pos==n:
        maxval[0]=max(maxval[0],temp)
        minval[0]=min(minval[0],temp)
        return
    for i in range(4):
        if order[i]>0:
            order[i]-=1
            dfs(pos+1,cal(temp,pos,i))
            order[i]+=1

dfs(1,arr[0])
print(maxval[0])
print(minval[0])